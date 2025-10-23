package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.ErrorSessionHandler;
import com.project.gpstracker.model.Notification;
import com.project.gpstracker.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService NotificationService;

    public NotificationController(NotificationService NotificationService) {
        this.NotificationService = NotificationService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllNotifications() {

        Notification[] Notifications = NotificationService.getAllNotifications();

        // If null, it means session expired (RestHandler returned null)
        if (Notifications == null)
            return ErrorSessionHandler.sessionExpired();

        return ResponseEntity.ok(Notifications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNotificationById(@PathVariable Long id) {
         
        Notification Notifications = NotificationService.getNotificationById(id);

        // If null, it means session expired (RestHandler returned null)
        if (Notifications == null) {
            return ErrorSessionHandler.sessionExpired();
        }

        return ResponseEntity.ok(Notifications);
    }

    @GetMapping("/{userId}/{deviceId}/{groupId}")
    public ResponseEntity<?> getNotifications(

            @PathVariable int userId,
            @PathVariable int deviceId,
            @PathVariable int groupId,
            @RequestParam (required = false, defaultValue = "false") boolean all,
            @RequestParam (required = false, defaultValue = "false") boolean refresh) {

        Notification[] Notifications = NotificationService.getNotifications( all, userId, deviceId, groupId, refresh);

        // If null, it means session expired (RestHandler returned null)
        if (Notifications == null)
            return ErrorSessionHandler.sessionExpired();

        return ResponseEntity.ok(Notifications);
    }
}
