package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.ErrorSessionHandler;
import com.project.gpstracker.model.Geofence;
import com.project.gpstracker.service.GeofenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/geofences")
public class GeofenceController {

    private final GeofenceService GeofenceService;

    public GeofenceController(GeofenceService GeofenceService) {
        this.GeofenceService = GeofenceService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllGeofence() {

        Geofence[] Geofence = GeofenceService.getAllGeofence();

        // If null, it means session expired (RestHandler returned null)
        if (Geofence == null)
            return ErrorSessionHandler.sessionExpired();

        return ResponseEntity.ok(Geofence);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGeofenceById(@PathVariable Long id) {
         
        Geofence Geofence = GeofenceService.getGeofenceById(id);

        // If null, it means session expired (RestHandler returned null)
        if (Geofence == null) {
            return ErrorSessionHandler.sessionExpired();
        }

        return ResponseEntity.ok(Geofence);
        
    }

    @GetMapping("/{userId}/{deviceId}/{groupId}")
    public ResponseEntity<?> getGeofence(
            @PathVariable int userId,
            @PathVariable int deviceId,
            @PathVariable int groupId,
            @RequestParam (required = false, defaultValue = "false") boolean all,
            @RequestParam (required = false, defaultValue = "false") boolean refresh) {

        Geofence[] Geofence = GeofenceService.getGeofence( all, userId, deviceId, groupId, refresh);

        // If null, it means session expired (RestHandler returned null)
        if (Geofence == null)
            return ErrorSessionHandler.sessionExpired();

        return ResponseEntity.ok(Geofence);
    }
}
