package com.abcvidyapeeth.backend.dtos;

import lombok.Data;

@Data
public class UserDto {

	private Long id;
	private String userName;
	private String password;
	private Boolean deleted;
	private String email;

}
