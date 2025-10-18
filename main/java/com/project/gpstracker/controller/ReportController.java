package com.project.gpstracker.controller;

import com.project.gpstracker.model.reports.*;
import com.project.gpstracker.service.ReportServices.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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
    public List<RouteReport> getRouteReport(
            @PathVariable Long deviceId,
            @PathVariable Long groupId,
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to) {

        if (from == null || to == null) {
            LocalDate today = LocalDate.now();
            from = today.atStartOfDay().toString() + "Z";
            to = today.atTime(23, 59, 59).toString() + "Z";
        }

        return routeReportService.getReport(deviceId, groupId, from, to);
    }

    @GetMapping("/trips/{deviceId}/{groupId}")
    public List<TripReport> getTripReport(
            @PathVariable Long deviceId,
            @PathVariable Long groupId,
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to) {

        if (from == null || to == null) {
            LocalDate today = LocalDate.now();
            from = today.atStartOfDay().toString() + "Z";
            to = today.atTime(23, 59, 59).toString() + "Z";
        }

        return tripReportService.getReport(deviceId, groupId, from, to);
    }

    @GetMapping("/stops/{deviceId}/{groupId}")
    public List<StopReport> getStopsReport(
            @PathVariable Long deviceId,
            @PathVariable Long groupId,
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to) {

        if (from == null || to == null) {
            LocalDate today = LocalDate.now();
            from = today.atStartOfDay().toString() + "Z";
            to = today.atTime(23, 59, 59).toString() + "Z";
        }

        return stopReportService.getReport(deviceId, groupId, from, to);
    }

    @GetMapping("/events/{deviceId}/{groupId}")
    public List<EventReport> getEventReport(
            @PathVariable Long deviceId,
            @PathVariable Long groupId,
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to) {

        if (from == null || to == null) {
            LocalDate today = LocalDate.now();
            from = today.atStartOfDay().toString() + "Z";
            to = today.atTime(23, 59, 59).toString() + "Z";
        }

        return eventReportServices.getReport(deviceId, groupId, from, to);
    }

    @GetMapping("/summary/{deviceId}/{groupId}")
    public List<TripSummaryReport> getSummaryReport(
            @PathVariable Long deviceId,
            @PathVariable Long groupId,
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to) {

        if (from == null || to == null) {
            LocalDate today = LocalDate.now();
            from = today.atStartOfDay().toString() + "Z";
            to = today.atTime(23, 59, 59).toString() + "Z";
        }

        return tripSummaryReportService.getReport(deviceId, groupId, from, to);
    }

}
