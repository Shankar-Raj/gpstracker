package com.project.gpstracker.handlers;

import com.project.gpstracker.service.SessionService;

import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

public class RestHandler {

    private static final RestTemplate restTemplate = new RestTemplate();
    private static final Object LOCK = new Object(); // Lock for thread safety

    public static <T> ResponseEntity<?> SendRequest(String endpoint, HttpMethod method, Object body, Class<T> responseType) {

        String url = "http://118.91.235.67:8082/api" + endpoint;

        HttpEntity<?> entity;
        if (body instanceof HttpEntity<?>) {
            entity = (HttpEntity<?>) body;
        } else {
            entity = new HttpEntity<>(body, createHeaders(false));
        }

        try {
            System.out.println("➡️ Request: " + method + " " + endpoint);
            return restTemplate.exchange(url, method, entity, responseType);

        } catch (HttpClientErrorException.Unauthorized e) {
            System.err.println("⚠️ Session expired ");
            return ErrorSessionHandler.SessionExpired();

        } catch (HttpClientErrorException.BadRequest e) {
            // Optional: catch other 4xx errors
            System.err.println("⚠️ Bad request error: " + e.getStatusCode());
            return ErrorSessionHandler.BadRequest(e);

        } catch (HttpClientErrorException e) {
            // Optional: catch other 4xx errors
            System.err.println("⚠️ HTTP error: " + e.getStatusCode());
            return ErrorSessionHandler.HttpError(e);

        } catch (ResourceAccessException e) {
            System.err.println("🌐⚠️ Connection error: " + e.getMessage());
            return ErrorSessionHandler.ResourceAccessException(e);
        }
        catch (Exception e) {
            // For other unexpected errors
            System.err.println("⚠️ Unexpected error: " + e.getMessage());
            return ErrorSessionHandler.InternalServerError(e);
        }
    }

    // Create headers safely using the stored cookie
    public static HttpHeaders createHeaders(boolean urlEncoded) {
        HttpHeaders headers = new HttpHeaders();
        if (urlEncoded) {
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        } else {
            headers.setContentType(MediaType.APPLICATION_JSON);
        }
        synchronized (LOCK) {
            if (SessionService.getSessionCookie() != null) {
                headers.set("Cookie", SessionService.getSessionCookie());
            }
        }
        return headers;
    }

    public static Object getLock() {
        return LOCK;
    }

}
