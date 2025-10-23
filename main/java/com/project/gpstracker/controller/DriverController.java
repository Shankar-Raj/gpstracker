package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.ErrorSessionHandler;
import com.project.gpstracker.model.Driver;
import com.project.gpstracker.service.DriverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    private final DriverService DriverService;

    public DriverController(DriverService DriverService) {
        this.DriverService = DriverService;
    }

    @GetMapping("all")
    public ResponseEntity<?> getAllDrivers() {

        Driver[] Drivers = DriverService.getDrivers();
        // If null, it means session expired (RestHandler returned null)
        if (Drivers == null)
            return ErrorSessionHandler.sessionExpired();

        return ResponseEntity.ok(Drivers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDriverById(@PathVariable Long id) {
         
        Driver Drivers = DriverService.getDriverById(id);

        // If null, it means session expired (RestHandler returned null)
        if (Drivers == null) {
            return ErrorSessionHandler.sessionExpired();
        }

        return ResponseEntity.ok(Drivers);
    }

    @GetMapping("/{userId}/{deviceId}/{groupId}")
    public ResponseEntity<?> getDriver(
            @PathVariable int userId,
            @PathVariable int deviceId,
            @PathVariable int groupId,
            @RequestParam (required = false, defaultValue = "false") boolean all,
            @RequestParam (required = false, defaultValue = "false") boolean refresh) {

        Driver[] Drivers = DriverService.getDriver( all, userId, deviceId, groupId, refresh);

        // If null, it means session expired (RestHandler returned null)
        if (Drivers == null)
            return ErrorSessionHandler.sessionExpired();

        return ResponseEntity.ok(Drivers);
        
    }
}
