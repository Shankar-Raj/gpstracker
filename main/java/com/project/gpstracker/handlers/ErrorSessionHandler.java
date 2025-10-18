package com.project.gpstracker.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class ErrorSessionHandler {

    // For Session Expiry
    public static ResponseEntity<Map<String, String>> sessionExpired() {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("error", "⚠️ Session expired. Please re-login at http://localhost:8080/login"));
    }

    // For General Unauthorized Access
    public static ResponseEntity<Map<String, String>> unauthorized(String message) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("error", message));
    }

    // For Bad Requests
    public static ResponseEntity<Map<String, String>> badRequest(String message) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("error", message));
    }

    // For Server Errors
    public static ResponseEntity<Map<String, String>> serverError(String message) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("error", message));
    }
}
