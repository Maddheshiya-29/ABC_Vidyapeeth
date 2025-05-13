package com.abcvidyapeeth.backend.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse {
	
	
	private String message;
	private boolean status;

}
