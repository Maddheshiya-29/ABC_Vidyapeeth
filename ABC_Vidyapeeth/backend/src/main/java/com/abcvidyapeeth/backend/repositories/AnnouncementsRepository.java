package com.abcvidyapeeth.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abcvidyapeeth.backend.entities.Announcements;

public interface AnnouncementsRepository extends JpaRepository<Announcements, Long>{
	
	public List<Announcements> findAllByDeleted(boolean deleted);
}
