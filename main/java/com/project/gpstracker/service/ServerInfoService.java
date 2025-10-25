package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServerInfoService {

    public ResponseEntity<?> getServerDetails () {
        String endpoint = "/server";
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.SendRequest(endpoint, HttpMethod.GET, null, Object.class);

    }

}
