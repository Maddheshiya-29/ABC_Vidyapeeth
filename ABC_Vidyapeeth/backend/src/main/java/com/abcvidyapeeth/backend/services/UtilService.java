package com.abcvidyapeeth.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.abcvidyapeeth.backend.entities.Announcements;
import com.abcvidyapeeth.backend.repositories.AnnouncementsRepository;

@Service
public class UtilService {
	
	@Autowired AnnouncementsRepository repoAnno;
	
	public ResponseEntity<List<String>> announcements() {
		List<String> notices = new ArrayList<String>();
		
		for (Announcements notice : repoAnno.findAllByDeleted(false)) {
			notices.add(notice.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(notices);
	}
}
