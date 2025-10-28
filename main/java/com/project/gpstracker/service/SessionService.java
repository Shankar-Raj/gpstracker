package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
public class SessionService {

    private static final String endpoint = "/session";
    private static volatile String sessionCookie = null; // Thread-safe shared variable

    // Login once and store session cookie
    public static ResponseEntity<?> login(String username, String password) {

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("email", username);
        formData.add("password", password);

        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<>(formData, RestHandler.createHeaders(true));

        ResponseEntity<?> response = RestHandler.SendRequest(endpoint, HttpMethod.POST, body, Object.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            synchronized (RestHandler.getLock()) { // Ensures only one thread modifies sessionCookie at a time
                sessionCookie = response.getHeaders().getFirst(HttpHeaders.SET_COOKIE);
            }
            System.out.println("✅ Logged in successfully");
        }

        return response;
    }

    // Logout and clear cookie safely
    public static ResponseEntity<?> logout() {

        HttpEntity<Object> body = new HttpEntity<>(RestHandler.createHeaders(true));

        ResponseEntity<?> response = RestHandler.SendRequest(endpoint, HttpMethod.DELETE, body, Object.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            synchronized (RestHandler.getLock()) { // Thread-safe clearing
                sessionCookie = null;
            }
            System.out.println("✅ Logged out successfully. Session cleared.");
        }

        return response;
    }

    // Thread-safe getter for cookie (if needed)
    public static String getSessionCookie() {
        synchronized (RestHandler.getLock()) {
            return sessionCookie;
        }
    }

}
