package com.abcvidyapeeth.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abcvidyapeeth.backend.entity.Announcement;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}
