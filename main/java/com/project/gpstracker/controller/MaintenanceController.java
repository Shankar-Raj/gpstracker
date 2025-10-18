package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.ErrorSessionHandler;
import com.project.gpstracker.model.Maintenance;
import com.project.gpstracker.model.Maintenance;
import com.project.gpstracker.service.MaintenanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

    private final MaintenanceService MaintenanceService;

    public MaintenanceController(MaintenanceService MaintenanceService) {
        this.MaintenanceService = MaintenanceService;
    }

    @GetMapping("all")
    public ResponseEntity<?> getAllMaintenances() {
         
        List<Maintenance> Maintenances = MaintenanceService.getAllMaintenances();

        // If null, it means session expired (RestHandler returned null)
        if (Maintenances == null)
            return ErrorSessionHandler.sessionExpired();

        return ResponseEntity.ok(Maintenances);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMaintenanceById(@PathVariable Long id) {
         
        Maintenance Maintenances = MaintenanceService.getMaintenanceById(id);

        // If null, it means session expired (RestHandler returned null)
        if (Maintenances == null) {
            return ErrorSessionHandler.sessionExpired();
        }

        return ResponseEntity.ok(Maintenances);
    }

    @GetMapping("/{userId}/{deviceId}/{groupId}")
    public ResponseEntity<?> getMaintenances(

            @PathVariable int userId,
            @PathVariable int deviceId,
            @PathVariable int groupId,
            @RequestParam (required = false, defaultValue = "true") boolean all,
            @RequestParam (required = false, defaultValue = "true") boolean refresh) {
        
        Maintenance Maintenances = MaintenanceService.getMaintenances( all, userId, deviceId, groupId, refresh);

        // If null, it means session expired (RestHandler returned null)
        if (Maintenances == null) {
            return ErrorSessionHandler.sessionExpired();
        }

        return ResponseEntity.ok(Maintenances);
    }
}
