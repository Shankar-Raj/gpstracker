package com.project.gpstracker.handlers;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public record CustomResponseHandler(Map<String, String> headers, Object body, String status) {

    // Static factory method — create a formatted CustomResponseHandler directly
    public static CustomResponseHandler of(ResponseEntity<?> responseEntity) {

        // Pick only specific headers
        Map<String, String> selectedHeaders = new HashMap<>();
        selectedHeaders.put("Date", responseEntity.getHeaders().getFirst("Date"));
        selectedHeaders.put("Content-Length", responseEntity.getHeaders().getFirst("Content-Length"));

        // Format status like "200 OK"
        String statusFormatted = responseEntity.getStatusCode().toString();

        // Return new combined response
        return new CustomResponseHandler(selectedHeaders, responseEntity.getBody(), statusFormatted);
    }
}
