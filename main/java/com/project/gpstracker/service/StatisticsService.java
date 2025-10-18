package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.Statistics;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StatisticsService {

    public List<Statistics> getStatistics (String From, String To) {
        String endpoint = "/statistics" +
                "?from=" + From +
                "&to=" +To;

        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        Statistics[] statsArray = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Statistics[].class);

        if (statsArray == null)
            return null; // Pass null up so controller can detect session expiry

        return Arrays.asList(statsArray);

    }


}
