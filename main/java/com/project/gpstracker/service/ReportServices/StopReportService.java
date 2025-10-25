package com.project.gpstracker.service.ReportServices;

import com.project.gpstracker.handlers.RestHandler;

import org.springframework.http.*;
import org.springframework.stereotype.Service;

@Service
public class StopReportService {

    public ResponseEntity<?> getReport(Long deviceId, Long groupId, String from, String to) {

        String endpoint = "/reports/stops" +
                "?deviceId=" + deviceId +
                "&groupId=" +groupId+
                "&from=" + from +
                "&to=" + to;

        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.SendRequest(endpoint, HttpMethod.GET, null, Object[].class);
    }
}
