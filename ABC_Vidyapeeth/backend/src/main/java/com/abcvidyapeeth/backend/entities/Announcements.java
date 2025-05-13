package com.abcvidyapeeth.backend.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name="announcements")
public class Announcements {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
		
	@Column(name="deleted", nullable=false)
	private Boolean deleted=false;
	
	@Column(name="message", nullable=false)
	private String message;
	
	@Column(name="date_time", nullable=false)
	private LocalDateTime dateTime;
}
