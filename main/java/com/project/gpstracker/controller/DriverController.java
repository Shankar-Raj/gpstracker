package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.CustomResponse;
import com.project.gpstracker.service.DriverService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private DriverService DriverService;

    @GetMapping("all")
    public ResponseEntity<?> getAllDrivers() {
        return ResponseEntity.ok(CustomResponse.of(DriverService.getDrivers()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDriverById(@PathVariable Long id) {
        return ResponseEntity.ok(CustomResponse.of(DriverService.getDriverById(id)));
    }

    @GetMapping("/{userId}/{deviceId}/{groupId}")
    public ResponseEntity<?> getDriver(
            @PathVariable int userId,
            @PathVariable int deviceId,
            @PathVariable int groupId,
            @RequestParam (required = false, defaultValue = "false") boolean all,
            @RequestParam (required = false, defaultValue = "false") boolean refresh) {
        return ResponseEntity.ok(CustomResponse.of(DriverService.getDriver( all, userId, deviceId, groupId, refresh)));
        
    }
}
