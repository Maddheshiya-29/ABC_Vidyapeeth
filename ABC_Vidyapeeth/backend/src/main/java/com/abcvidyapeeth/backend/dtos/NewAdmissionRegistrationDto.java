package com.abcvidyapeeth.backend.dtos;

import lombok.Data;

@Data
public class NewAdmissionRegistrationDto {

	private Long id;
    private String academicTerm;
    private String studentName;
    private String fatherName;
    private String aadharNumber;
    private String motherName;
    private String gender;
    private String dob;
    private String mobileNo;
    private String email;
    private String address;
    private String district;
    private String state;
    private String country;
    private String pin;
	private String admissionForClass;
	private String lastClass;
	private String passingYear;
    private Boolean deleted = false;
    
    public NewAdmissionRegistrationDto() {}
    
    public NewAdmissionRegistrationDto(Long id, String academicTerm, String studentName, String fatherName,
            String aadharNumber, String motherName, String gender, String dob,
            String mobileNo, String email, String address, String district,
            String state, String country, String pin) {
		this.id = id;
		this.academicTerm = academicTerm;
		this.studentName = studentName;
		this.fatherName = fatherName;
		this.aadharNumber = aadharNumber;
		this.motherName = motherName;
		this.gender = gender;
		this.dob = dob;
		this.mobileNo = mobileNo;
		this.email = email;
		this.address = address;
		this.district = district;
		this.state = state;
		this.country = country;
		this.pin = pin;
	}
}
