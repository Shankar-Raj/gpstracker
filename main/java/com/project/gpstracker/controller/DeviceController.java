package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.CustomResponseHandler;
import com.project.gpstracker.service.DeviceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    private DeviceService DeviceService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllDevices() {
        return ResponseEntity.ok(CustomResponseHandler.of(DeviceService.getAllDevices()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDeviceById(@PathVariable Long id) {
        return ResponseEntity.ok(CustomResponseHandler.of(DeviceService.getDeviceById(id)));
    }

    @GetMapping("/{userId}/{Id}/{uniqueId}")
    public ResponseEntity<?> getDevice(
            @PathVariable int userId,
            @PathVariable int Id,
            @PathVariable int uniqueId,
            @RequestParam (required = false, defaultValue = "false") boolean all) {
        return ResponseEntity.ok(CustomResponseHandler.of(DeviceService.getDevice(all, userId, Id, uniqueId)));
    }
}
