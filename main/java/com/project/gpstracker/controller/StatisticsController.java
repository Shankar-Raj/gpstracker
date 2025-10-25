package com.project.gpstracker.controller;

import com.project.gpstracker.service.StatisticsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private  StatisticsService StatisticsService;

    @GetMapping()
    public ResponseEntity<?> getStatistics(
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to) {

        // Default date range (today)
        if (from == null || to == null) {
            LocalDate today = LocalDate.now();
            from = today.atStartOfDay().toString() + "Z";
            to = today.atTime(23, 59, 59).toString() + "Z";
        }

        ResponseEntity<?> stats = StatisticsService.getStatistics(from, to);
        return ResponseEntity.ok(stats);
    }
}
