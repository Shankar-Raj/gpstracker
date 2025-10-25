package com.project.gpstracker.controller;

import com.project.gpstracker.service.MaintenanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    private MaintenanceService MaintenanceService;

    @GetMapping("all")
    public ResponseEntity<?> getAllMaintenances() {

        ResponseEntity<?> Maintenances = MaintenanceService.getAllMaintenances();
        return ResponseEntity.ok(Maintenances);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMaintenanceById(@PathVariable Long id) {

        ResponseEntity<?> Maintenances = MaintenanceService.getMaintenanceById(id);
        return ResponseEntity.ok(Maintenances);
    }

    @GetMapping("/{userId}/{deviceId}/{groupId}")
    public ResponseEntity<?> getMaintenances(

            @PathVariable int userId,
            @PathVariable int deviceId,
            @PathVariable int groupId,
            @RequestParam (required = false, defaultValue = "false") boolean all,
            @RequestParam (required = false, defaultValue = "false") boolean refresh) {

        ResponseEntity<?> Maintenances = MaintenanceService.getMaintenances( all, userId, deviceId, groupId, refresh);
        return ResponseEntity.ok(Maintenances);
    }
}
