package com.abcvidyapeeth.backend.controlllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abcvidyapeeth.backend.dtos.ApiResponse;
import com.abcvidyapeeth.backend.dtos.NewAdmissionRegistrationDto;
import com.abcvidyapeeth.backend.services.RegistrationService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
	
	@Autowired RegistrationService servReg;
	
	
	@PostMapping("/saveNewAdmissionReg")
	public ResponseEntity<ApiResponse> saveNewAdmissionReg(@RequestBody NewAdmissionRegistrationDto dto){
		try {
			if (dto.getStudentName() == null || dto.getFatherName() == null || dto.getGender() == null || dto.getDob() == null || dto.getMobileNo() == null || dto.getAddress() == null ||
				    dto.getState() == null || dto.getCountry() == null || dto.getPin() == null || dto.getAcademicTerm() == null) {
				return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.builder().status(false).message("Please fill all required fields").build());
			}
			return servReg.saveNewAdmissionReg(dto);
			
		}
		catch(Exception e) {
			System.out.println("RegistrationController.saveNewAdmissionReg[] ->"+ e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.builder().status(false).message("There is something wrong").build());
		}
	}
}
