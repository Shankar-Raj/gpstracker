package com.project.gpstracker.service.ReportServices;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.reports.EventReport;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

@Service
public class EventReportServices {

    public EventReport[] getReport(Long deviceId, Long groupId, String from, String to) {

        String endpoint = "/reports/events" +
                "?deviceId=" + deviceId +
                "&groupId=" +groupId+
                "&from=" + from +
                "&to=" + to;

        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.sendRequest(endpoint, HttpMethod.GET, null, EventReport[].class);
    }
}
