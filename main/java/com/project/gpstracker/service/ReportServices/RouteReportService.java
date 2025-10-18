package com.project.gpstracker.service.ReportServices;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.reports.RouteReport;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RouteReportService {

    public List<RouteReport> getReport(Long deviceId, Long groupId, String from, String to) {

        String endpoint = "/reports/route" +
                "?deviceId=" + deviceId +
                "&groupId=" +groupId+
                "&from=" + from +
                "&to=" + to;

        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)

        return List.of(RestHandler.sendRequest(endpoint, HttpMethod.GET, null, RouteReport[].class));
    }
}
