package com.abcvidyapeeth.backend.entities;


import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name="new_admission_registration")
public class NewAdmissionRegistration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="academic_term", nullable=false)
	private String academicTerm;
	
	@Column(name="student_name", nullable=false)
	private String studentName;
	
	@Column(name="father_name", nullable=false)
	private String fatherName;
	
	@Column(name="aadhar", nullable=true)
	private String aadharNumber;
	
	@Column(name="mother_name", nullable=false)
	private String motherName;

	@Column(name="gender", nullable=false)
	private String gender;
	
	@DateTimeFormat(pattern="dd-MMM-yyyy")
	@Column(name="dob", nullable=false)
    private LocalDate dob;

	@Column(name="mobile_no", nullable=false)
	private String mobileNo;
	
	@Column(name="email", nullable=true)
	private String email;

	@Column(name="address", nullable=false)
	private String address;
	
	@Column(name="district", nullable=false)
	private String district;
	
	@Column(name="state", nullable=false)
	private String state;
	
	@Column(name="country", nullable=false)
	private String country;
	
	@Column(name="admission_for_class", nullable=false)
	private String admissionForClass;
	
	@Column(name="last_class", nullable=false)
	private String lastClass;
	
	@Column(name="passing_year", nullable=false)
	private String passingYear;
	
	@Column(name="pin", nullable=false)
	private String pin;
	
	@Column(name="deleted", nullable=false)
	private Boolean deleted = false;
	
}
