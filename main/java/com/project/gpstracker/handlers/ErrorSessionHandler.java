package com.project.gpstracker.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Map;

public class ErrorSessionHandler {

    // For Session Expiry
    public static ResponseEntity<?> SessionExpired() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("Session error", "⚠️ Session expired. Please re-login at http://localhost:8080/login"));
    }

    // For Bad Requests
    public static ResponseEntity<?> BadRequest(HttpClientErrorException.BadRequest e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Bad Request error", "⚠️ "+e.getStatusCode()));
    }


    // For HTTP Error
    public static ResponseEntity<?> HttpError(HttpClientErrorException e) {
        return ResponseEntity.status(e.getStatusCode()).body(Map.of("HTTP error", "⚠️ "+e.getStatusCode()));
    }

    // For Internal Server Errors
    public static ResponseEntity<?> ResourceAccessException(Exception e) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(Map.of("Connection error", "⚠️ Unable to reach server: " + e.getMessage()));
    }

    // For Internal Server Errors
    public static ResponseEntity<?> InternalServerError(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(" Unexpected error", "⚠️ "+ e.getMessage()));
    }
}
