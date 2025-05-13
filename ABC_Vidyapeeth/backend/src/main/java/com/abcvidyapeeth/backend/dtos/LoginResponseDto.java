package com.abcvidyapeeth.backend.dtos;

import java.util.List;
import lombok.Data;

@Data
public class LoginResponseDto {

	private String userId;
	private String token;
	private String name;
	private String roles;
    
	private Long studentId; 
//    private List<String> roleviewMenu;
	
	private boolean response=false;
	private String message;
	
	public LoginResponseDto() {}
	
	public LoginResponseDto(String message) {
		this.message = message;
	}
	
	public LoginResponseDto(boolean response, String message, String name, String userId, String token, String roles) {
		this.name = name;
		this.roles = roles;
		this.token = token;
		this.userId = userId;
		this.message = message;
		this.response = response;
	}
}