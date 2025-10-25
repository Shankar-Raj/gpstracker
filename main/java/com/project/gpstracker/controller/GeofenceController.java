package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.ErrorSessionHandler;
import com.project.gpstracker.service.GeofenceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/geofences")
public class GeofenceController {

    @Autowired
    private GeofenceService GeofenceService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllGeofence() {

        ResponseEntity<?> Geofence = GeofenceService.getAllGeofence();
        return ResponseEntity.ok(Geofence);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGeofenceById(@PathVariable Long id) {

        ResponseEntity<?> Geofence = GeofenceService.getGeofenceById(id);
        return ResponseEntity.ok(Geofence);
        
    }

    @GetMapping("/{userId}/{deviceId}/{groupId}")
    public ResponseEntity<?> getGeofence(
            @PathVariable int userId,
            @PathVariable int deviceId,
            @PathVariable int groupId,
            @RequestParam (required = false, defaultValue = "false") boolean all,
            @RequestParam (required = false, defaultValue = "false") boolean refresh) {

        ResponseEntity<?> Geofence = GeofenceService.getGeofence( all, userId, deviceId, groupId, refresh);
        return ResponseEntity.ok(Geofence);
    }
}
