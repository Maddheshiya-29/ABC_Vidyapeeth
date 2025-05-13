package com.abcvidyapeeth.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcvidyapeeth.backend.entity.Announcement;
import com.abcvidyapeeth.backend.repository.AnnouncementRepository;

@Service
public class AnnouncementService {

    @Autowired
    private AnnouncementRepository announcementRepository;

    public List<Announcement> getAllAnnouncements() {
        return announcementRepository.findAll();
    }

    public Announcement createAnnouncement(Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    public Announcement updateAnnouncement(Long id, Announcement announcement) {
        Announcement existingAnnouncement = announcementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Announcement not found"));

        existingAnnouncement.setMessage(announcement.getMessage());

        return announcementRepository.save(existingAnnouncement);
    }

    public void deleteAnnouncement(Long id) {
        announcementRepository.deleteById(id);
    }
}
