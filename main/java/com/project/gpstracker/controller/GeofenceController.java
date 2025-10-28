package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.CustomResponse;
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
        return ResponseEntity.ok(CustomResponse.of(GeofenceService.getAllGeofence()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGeofenceById(@PathVariable Long id) {
        return ResponseEntity.ok(CustomResponse.of(GeofenceService.getGeofenceById(id)));
        
    }

    @GetMapping("/{userId}/{deviceId}/{groupId}")
    public ResponseEntity<?> getGeofence(
            @PathVariable int userId,
            @PathVariable int deviceId,
            @PathVariable int groupId,
            @RequestParam (required = false, defaultValue = "false") boolean all,
            @RequestParam (required = false, defaultValue = "false") boolean refresh) {
        return ResponseEntity.ok(CustomResponse.of(GeofenceService.getGeofence( all, userId, deviceId, groupId, refresh)));
    }
}
