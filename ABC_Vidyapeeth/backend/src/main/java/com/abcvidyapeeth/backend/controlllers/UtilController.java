package com.abcvidyapeeth.backend.controlllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abcvidyapeeth.backend.services.UtilService;

@RestController
@RequestMapping("/util")
public class UtilController {
	
	@Autowired UtilService util;
	
	@GetMapping("/announcements")
	public ResponseEntity<List<String>> announcements(){
		return util.announcements();
	}
}
