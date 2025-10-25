package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    public ResponseEntity<?> getStatistics (String From, String To) {
        String endpoint = "/statistics" +
                "?from=" + From +
                "&to=" +To;

        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.SendRequest(endpoint, HttpMethod.GET, null, Object[].class);

    }


}
