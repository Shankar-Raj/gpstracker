package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.ErrorSessionHandler;
import com.project.gpstracker.model.Statistics;
import com.project.gpstracker.service.StatisticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    private final StatisticsService StatisticsService;

    public StatisticsController(StatisticsService StatisticsService) {
        this.StatisticsService = StatisticsService;
    }

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

        Statistics[] stats = StatisticsService.getStatistics(from, to);

        // If null, it means session expired (RestHandler returned null)
        if (stats == null)
            return ErrorSessionHandler.sessionExpired();

        return ResponseEntity.ok(stats);
    }
}
