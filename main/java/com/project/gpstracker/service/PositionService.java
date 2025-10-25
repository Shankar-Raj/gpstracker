package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PositionService {

    public ResponseEntity<?> getAllPositions () {
        String endpoint = "/positions";
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.SendRequest(endpoint, HttpMethod.GET, null, Object[].class);

    }

    public ResponseEntity<?> getPositions (int deviceId, int Id, String From, String To) {
        String endpoint = "/positions" +
                "?deviceId=" + deviceId+
                "&from=" + From+
                "&to=" + To+
                "&id="+Id;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.SendRequest(endpoint, HttpMethod.GET, null, Object[].class);

    }


}
