package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.ErrorSessionHandler;
import com.project.gpstracker.model.Position;
import com.project.gpstracker.service.PositionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/positions")
public class PositionController {

    private final PositionService PositionService;

    public PositionController(PositionService PositionService) {
        this.PositionService = PositionService;
    }

    @GetMapping("all")
    public ResponseEntity<?> getAllPositions() {

        Position[] Positions = PositionService.getAllPositions();

        // If null, it means session expired (RestHandler returned null)
        if (Positions == null)
            return ErrorSessionHandler.sessionExpired();

        return ResponseEntity.ok(Positions);
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

        Position[] Positions = PositionService.getPositions(deviceId, id, From, To);

        // If null, it means session expired (RestHandler returned null)
        if (Positions == null)
            return ErrorSessionHandler.sessionExpired();

        return ResponseEntity.ok(Positions);
    }


}
