package com.abcvidyapeeth.backend.services;

import com.abcvidyapeeth.backend.dtos.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.abcvidyapeeth.backend.dtos.ApiResponse;
import com.abcvidyapeeth.backend.dtos.UserDto;
import com.abcvidyapeeth.backend.entities.User;
import com.abcvidyapeeth.backend.repositories.UserRepository;


@Service
public class UserService {
    

    @Autowired UserRepository repoUser;
	@Autowired AuthenticationManager authenticationManager;
    @Autowired JwtService jwtService;
    
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    
    public ResponseEntity<ApiResponse> registerUser(UserDto dto){
        User usr = new User();
        usr.setUserName(dto.getUserName());
        String encodedPassword = encoder.encode(dto.getPassword());
        usr.setPassword(encodedPassword);
        repoUser.save(usr);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.builder().status(true).message("User Registered successfully !!").build());
    }
    
    public ResponseEntity<LoginResponseDto> authenticate(UserDto dto) {
        String roleName = null;
//        List<String> roleViewMenu = new ArrayList<String>();
        
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUserName(), dto.getPassword()));
        User user = repoUser.findByDeletedAndUserName(false, dto.getUserName()).get();
        
        for (com.abcvidyapeeth.backend.entities.Role role : user.getRoles()) {
            roleName = role.getRoleName();
//            roleViewMenu = repoRoleView.getAllMenusByRole(roleName);
        }
        LoginResponseDto responseDTO = new LoginResponseDto(true, "Login Successfull.", user.getName(), user.getUsername(), jwtService.generateToken(user), roleName);
        
//        if (roleName.equals("student")) {
////        	responseDTO.setBceceId(user.getBceceId());
////        	responseDTO.setStudentId(user.getStudentId());
//        }
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }
    
}
