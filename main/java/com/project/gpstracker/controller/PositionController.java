package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.CustomResponseHandler;
import com.project.gpstracker.service.PositionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/positions")
public class PositionController {

    @Autowired
    private PositionService PositionService;

    @GetMapping("all")
    public ResponseEntity<?> getAllPositions() {
        return ResponseEntity.ok(CustomResponseHandler.of(PositionService.getAllPositions()));
    }

    @GetMapping("/{deviceId}/{id}")
    public ResponseEntity<?> getPositions(
            @PathVariable int deviceId,
            @PathVariable int id,
            @RequestParam(required = false) String From,
            @RequestParam(required = false) String To) {
        // If 'from' or 'to' not given, use current date defaults
        if (From == null || To == null) {
            LocalDate today = LocalDate.now();
            From = today.atStartOfDay().toString() + "Z"; // e.g. 2025-10-13T00:00:00Z
            To = today.atTime(23, 59, 59).toString() + "Z"; // e.g. 2025-10-13T23:59:59Z
        }
        return ResponseEntity.ok(CustomResponseHandler.of(PositionService.getPositions(deviceId, id, From, To)));
    }


}
