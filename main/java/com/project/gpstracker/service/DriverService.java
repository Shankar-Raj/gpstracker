package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    public ResponseEntity<?> getDrivers () {
        String endpoint = "/drivers";
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.SendRequest(endpoint, HttpMethod.GET, null, Object[].class);

    }

    public ResponseEntity<?> getDriverById(Long id) {
        String endpoint = "/drivers/"+id;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.SendRequest(endpoint, HttpMethod.GET, null, Object.class);

    }

    public ResponseEntity<?> getDriver (boolean all, int userId, int deviceId, int groupId, boolean refresh) {
        String endpoint = "/drivers" +
                "?all=" + all +
                "&userId=" +userId+
                "&deviceId=" + deviceId+
                "&groupId=" + groupId+
                "&refresh=" + refresh;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.SendRequest(endpoint, HttpMethod.GET, null, Object[].class);

    }

}
