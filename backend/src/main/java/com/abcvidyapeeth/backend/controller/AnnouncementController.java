package com.abcvidyapeeth.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abcvidyapeeth.backend.entity.Announcement;
import com.abcvidyapeeth.backend.service.AnnouncementService;

@RestController
@RequestMapping("/api/announcements")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @GetMapping
    public List<Announcement> getAllAnnouncements() {
        return announcementService.getAllAnnouncements();
    }

    @PostMapping
    public Announcement createAnnouncement(@RequestBody Announcement announcement) {
        return announcementService.createAnnouncement(announcement);
    }

    @PutMapping("/{id}")
    public Announcement updateAnnouncement(@PathVariable Long id, @RequestBody Announcement announcement) {
        return announcementService.updateAnnouncement(id, announcement);
    }

    @DeleteMapping("/{id}")
    public void deleteAnnouncement(@PathVariable Long id) {
        announcementService.deleteAnnouncement(id);
    }
}
