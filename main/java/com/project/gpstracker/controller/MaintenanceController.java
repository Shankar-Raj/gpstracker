package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.CustomResponseHandler;
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
        return ResponseEntity.ok(CustomResponseHandler.of(MaintenanceService.getAllMaintenances()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMaintenanceById(@PathVariable Long id) {
        return ResponseEntity.ok(CustomResponseHandler.of(MaintenanceService.getMaintenanceById(id)));
    }

    @GetMapping("/{userId}/{deviceId}/{groupId}")
    public ResponseEntity<?> getMaintenances(
            @PathVariable int userId,
            @PathVariable int deviceId,
            @PathVariable int groupId,
            @RequestParam (required = false, defaultValue = "false") boolean all,
            @RequestParam (required = false, defaultValue = "false") boolean refresh) {
        return ResponseEntity.ok(CustomResponseHandler.of(MaintenanceService.getMaintenances( all, userId, deviceId, groupId, refresh)));
    }
}
