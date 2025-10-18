package com.project.gpstracker.handlers;

import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static com.project.gpstracker.service.SessionService.*;

public class RestHandler {

    private static final RestTemplate restTemplate = new RestTemplate();

    public static <T> T sendRequest(String endpoint, HttpMethod method, Object body, Class<T> responseType) {
        String url = getUrl() + endpoint;
        HttpEntity<Object> entity = new HttpEntity<>(body, createHeaders());

        try {
            ResponseEntity<T> response = restTemplate.exchange(url, method, entity, responseType);
            return response.getBody();

        } catch (HttpClientErrorException.Unauthorized e) {

            System.out.println("⚠️ Session expired. Please re-login (http://localhost:8080/login).");
            return null;
        }
    }
}
