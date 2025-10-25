package com.project.gpstracker.handlers;

import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import static com.project.gpstracker.service.SessionService.*;

public class RestHandler {

    private static final RestTemplate restTemplate = new RestTemplate();

    public static <T> ResponseEntity<?> SendRequest(String endpoint, HttpMethod method, Object body, Class<T> responseType) {
        String url = getUrl() + endpoint;
        HttpEntity<Object> entity = new HttpEntity<>(body, createHeaders());

        try {
            System.err.println("➡️ Request: " + method + " " + url);
            return restTemplate.exchange(url, method, entity, responseType);

        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("⚠️ Session expired ");
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
            System.err.println("🌐 Connection error: " + e.getMessage());
            return ErrorSessionHandler.ResourceAccessException(e);
        }
        catch (Exception e) {
            // For other unexpected errors
            System.err.println("⚠️ Unexpected error: " + e.getMessage());
            return ErrorSessionHandler.InternalServerError(e);
        }
    }

}
