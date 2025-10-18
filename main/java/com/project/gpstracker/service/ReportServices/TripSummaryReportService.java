package com.project.gpstracker.service.ReportServices;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.reports.TripSummaryReport;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripSummaryReportService {

    public List<TripSummaryReport> getReport(Long deviceId, Long groupId, String from, String to) {

        String endpoint = "/reports/summary" +
                "?deviceId=" + deviceId +
                "&groupId=" +groupId+
                "&from=" + from +
                "&to=" + to;

        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return List.of(RestHandler.sendRequest(endpoint, HttpMethod.GET, null, TripSummaryReport[].class));
    }
}
