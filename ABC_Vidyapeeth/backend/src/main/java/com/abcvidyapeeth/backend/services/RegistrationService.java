package com.abcvidyapeeth.backend.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.abcvidyapeeth.backend.dtos.ApiResponse;
import com.abcvidyapeeth.backend.dtos.NewAdmissionRegistrationDto;
import com.abcvidyapeeth.backend.entities.NewAdmissionRegistration;
import com.abcvidyapeeth.backend.repositories.NewAdmissionRegistrationRepository;

@Service
public class RegistrationService {

	@Autowired NewAdmissionRegistrationRepository repoNewAdmReg;

	public ResponseEntity<ApiResponse> saveNewAdmissionReg(NewAdmissionRegistrationDto dto) {
		NewAdmissionRegistration reg = new NewAdmissionRegistration();
		if(dto.getId()!=null)
			reg = repoNewAdmReg.findByDeletedAndId(false, dto.getId());
		if(dto.getDeleted())
			reg.setDeleted(true);
		else {
			reg.setAcademicTerm(dto.getAcademicTerm().trim());
		    reg.setStudentName(dto.getStudentName().trim());
		    reg.setFatherName(dto.getFatherName().trim());
		    reg.setAadharNumber(dto.getAadharNumber()==null ? null : dto.getAadharNumber().trim());
		    reg.setMotherName(dto.getMotherName().trim());
		    reg.setGender(dto.getGender().trim());
		    reg.setDob(LocalDate.parse(dto.getDob()));
		    reg.setMobileNo(dto.getMobileNo().trim());
		    reg.setEmail(dto.getEmail().trim());
		    reg.setAddress(dto.getAddress().trim());
		    reg.setDistrict(dto.getDistrict().trim());
		    reg.setState(dto.getState().trim());
		    reg.setCountry(dto.getCountry().trim());
		    reg.setPin(dto.getPin().trim());
		    reg.setAdmissionForClass(dto.getAdmissionForClass().trim());
		    reg.setLastClass(dto.getLastClass().trim());
		    reg.setPassingYear(dto.getPassingYear().trim());
		}

	    repoNewAdmReg.save(reg);
		return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.builder().status(true).message(dto.getDeleted() ? "Deleted Successfully" : "Data saved successfully !!").build());
	}
}

