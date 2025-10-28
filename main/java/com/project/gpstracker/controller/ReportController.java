package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.CustomResponse;
import com.project.gpstracker.service.ReportServices.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private RouteReportService routeReportService;

    @Autowired
    private TripReportService tripReportService;

    @Autowired
    private StopReportService stopReportService;

    @Autowired
    private EventReportServices eventReportServices;

    @Autowired
    private TripSummaryReportService tripSummaryReportService;


    @GetMapping("/route/{deviceId}/{groupId}")
    public ResponseEntity<?> getRouteReport(
            @PathVariable Long deviceId,
            @PathVariable Long groupId,
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to) {

        if (from == null || to == null) {
            LocalDate today = LocalDate.now();
            from = today.atStartOfDay().toString() + "Z";
            to = today.atTime(23, 59, 59).toString() + "Z";
        }

        return ResponseEntity.ok(CustomResponse.of(routeReportService.getReport(deviceId, groupId, from, to)));
    }

    @GetMapping("/trips/{deviceId}/{groupId}")
    public ResponseEntity<?> getTripReport(
            @PathVariable Long deviceId,
            @PathVariable Long groupId,
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to) {

        if (from == null || to == null) {
            LocalDate today = LocalDate.now();
            from = today.atStartOfDay().toString() + "Z";
            to = today.atTime(23, 59, 59).toString() + "Z";
        }

        return ResponseEntity.ok(CustomResponse.of(tripReportService.getReport(deviceId, groupId, from, to)));
    }

    @GetMapping("/stops/{deviceId}/{groupId}")
    public ResponseEntity<?> getStopsReport(
            @PathVariable Long deviceId,
            @PathVariable Long groupId,
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to) {

        if (from == null || to == null) {
            LocalDate today = LocalDate.now();
            from = today.atStartOfDay().toString() + "Z";
            to = today.atTime(23, 59, 59).toString() + "Z";
        }

        return ResponseEntity.ok(CustomResponse.of(stopReportService.getReport(deviceId, groupId, from, to)));
    }

    @GetMapping("/events/{deviceId}/{groupId}")
    public ResponseEntity<?> getEventReport(
            @PathVariable Long deviceId,
            @PathVariable Long groupId,
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to) {

        if (from == null || to == null) {
            LocalDate today = LocalDate.now();
            from = today.atStartOfDay().toString() + "Z";
            to = today.atTime(23, 59, 59).toString() + "Z";
        }

        return ResponseEntity.ok(CustomResponse.of(eventReportServices.getReport(deviceId, groupId, from, to)));
    }

    @GetMapping("/summary/{deviceId}/{groupId}")
    public ResponseEntity<?> getSummaryReport(
            @PathVariable Long deviceId,
            @PathVariable Long groupId,
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to) {

        if (from == null || to == null) {
            LocalDate today = LocalDate.now();
            from = today.atStartOfDay().toString() + "Z";
            to = today.atTime(23, 59, 59).toString() + "Z";
        }

        return ResponseEntity.ok(CustomResponse.of(tripSummaryReportService.getReport(deviceId, groupId, from, to)));
    }

}
