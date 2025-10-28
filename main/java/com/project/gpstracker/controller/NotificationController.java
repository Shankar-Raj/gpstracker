package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.CustomResponseHandler;
import com.project.gpstracker.service.NotificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService NotificationService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllNotifications() {
        return ResponseEntity.ok(CustomResponseHandler.of(NotificationService.getAllNotifications()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNotificationById(@PathVariable Long id) {
        return ResponseEntity.ok(CustomResponseHandler.of(NotificationService.getNotificationById(id)));
    }

    @GetMapping("/{userId}/{deviceId}/{groupId}")
    public ResponseEntity<?> getNotifications(
            @PathVariable int userId,
            @PathVariable int deviceId,
            @PathVariable int groupId,
            @RequestParam (required = false, defaultValue = "false") boolean all,
            @RequestParam (required = false, defaultValue = "false") boolean refresh) {
        return ResponseEntity.ok(CustomResponseHandler.of(NotificationService.getNotifications( all, userId, deviceId, groupId, refresh)));
    }
}
