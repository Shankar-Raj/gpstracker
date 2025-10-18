package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.ErrorSessionHandler;
import com.project.gpstracker.model.Device;
import com.project.gpstracker.service.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/device")
public class DeviceController {

    private final DeviceService DeviceService;

    public DeviceController(DeviceService DeviceService) {
        this.DeviceService = DeviceService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllDevices() {
        
        List<Device> Devices = DeviceService.getAllDevices();

        // If null, it means session expired (RestHandler returned null)
        if (Devices == null)
            return ErrorSessionHandler.sessionExpired();

        return ResponseEntity.ok(Devices);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDeviceById(@PathVariable Long id) {
        
        Device Devices = DeviceService.getDeviceById(id);

        // If null, it means session expired (RestHandler returned null)
        if (Devices == null) {
            return ErrorSessionHandler.sessionExpired();
        }

        return ResponseEntity.ok(Devices);
    }

    @GetMapping("/{userId}/{Id}/{uniqueId}")
    public ResponseEntity<?> getDevice(
            @PathVariable int userId,
            @PathVariable int Id,
            @PathVariable int uniqueId,
            @RequestParam (required = false, defaultValue = "true") boolean all) {
        
        Device Devices = DeviceService.getDevice(all, userId, Id, uniqueId);

        // If null, it means session expired (RestHandler returned null)
        if (Devices == null) {
            return ErrorSessionHandler.sessionExpired();
        }

        return ResponseEntity.ok(Devices);
    }
}
