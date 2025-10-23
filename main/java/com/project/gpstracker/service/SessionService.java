package com.project.gpstracker.service;

import com.project.gpstracker.model.Session;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class SessionService {

    private static String URL = "http://118.91.235.67:8082/api";

    private static final RestTemplate restTemplate = new RestTemplate();
    private static String sessionCookie = null; // store JSESSIONID

    // Login once and store session cookie

    public static Session login(String username, String password) {

        String url = URL + "/session";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("email", username);
        formData.add("password", password);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(formData, headers);

        ResponseEntity<Session> response = restTemplate.postForEntity(url, request, Session.class);

        // Extract and store session cookie
        HttpHeaders responseHeaders = response.getHeaders();
        if (responseHeaders.containsKey(HttpHeaders.SET_COOKIE)) {
            sessionCookie = responseHeaders.getFirst(HttpHeaders.SET_COOKIE);
            System.out.println("✅ Logged in successfully. Session: " + sessionCookie);
        } else {
            throw new RuntimeException("⚠️ Login failed. No session cookie received.");
        }

        return response.getBody();
    }

    public static String logout() {

        String url = URL + "/session";

        // Create headers with stored cookie
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        if (sessionCookie != null) {
            headers.set("Cookie", sessionCookie);
        }

        // Build the request entity (without body for DELETE)
        HttpEntity<String> request = new HttpEntity<>(headers);

        // Perform DELETE call
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                request,
                String.class
        );

        // Clear stored session
        if (response.getStatusCode().is2xxSuccessful()) {
            sessionCookie = null;
            System.out.println("✅ Logged out successfully. Session cleared.");
        } else {
            System.out.println("⚠️ Logout failed.");
        }

        return response.getStatusCode().toString()+" ✅ Logged out successfully...";
    }


    // Create headers with stored session cookie

    public static HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (sessionCookie != null) {
            headers.set("Cookie", sessionCookie);
        }
        return headers;
    }

    public static void loginWithCookie( String token) {
    }

    public static String getUrl() { return URL; }
    public void setUrl(String URL) { SessionService.URL = URL; }
    public static String getSessionCookie() { return sessionCookie; }
}
