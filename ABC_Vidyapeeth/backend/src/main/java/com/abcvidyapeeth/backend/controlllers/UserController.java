package com.abcvidyapeeth.backend.controlllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abcvidyapeeth.backend.dtos.ApiResponse;
import com.abcvidyapeeth.backend.dtos.UserDto;
import com.abcvidyapeeth.backend.services.UserService;
import com.abcvidyapeeth.backend.dtos.LoginResponseDto;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired UserService servUser;
	
	@PostMapping("/registerUser")
	public ResponseEntity<ApiResponse> registerUser(@RequestBody UserDto dto){
		try {
			if(dto.getUserName()==null || dto.getPassword()==null)
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.builder().status(false).message("Please fill mandatory fields !!").build());
			return servUser.registerUser(dto);
		}
		catch(Exception e) {
			System.out.println("UserController.registerUser[] ->"+ e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.builder().status(false).message("There is something wrong !!").build());
		}
	}
	
	
	@PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody UserDto dto) {
    	try {
    		return servUser.authenticate(dto);
    	}
    	catch (BadCredentialsException e) {
    		return ResponseEntity.ofNullable(new LoginResponseDto("Invalid Credential !!"));
    	}
    	catch (Exception e) {
    		return ResponseEntity.ofNullable(new LoginResponseDto("There is something wrong !!"));
    	}
    }
}
