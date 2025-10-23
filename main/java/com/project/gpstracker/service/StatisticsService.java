package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.Statistics;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    public Statistics[] getStatistics (String From, String To) {
        String endpoint = "/statistics" +
                "?from=" + From +
                "&to=" +To;

        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Statistics[].class);

    }


}
