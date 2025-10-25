package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    public ResponseEntity<?> getAllDevices() {
        String endpoint = "/devices";
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.SendRequest(endpoint, HttpMethod.GET, null, Object[].class);
    }

    public ResponseEntity<?> getDeviceById(long id) {
        String endpoint = "/devics/"+id;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.SendRequest(endpoint, HttpMethod.GET, null, Object.class);
    }

    public ResponseEntity<?> getDevice(boolean all, int userId, int Id, int uniqueId) {
        String endpoint = "/devices" +
                "?all=" + all +
                "&userId=" +userId+
                "&deviceId=" + Id+
                "&uniqueId=" + uniqueId;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.SendRequest(endpoint, HttpMethod.GET, null, Object[].class);
    }
}
