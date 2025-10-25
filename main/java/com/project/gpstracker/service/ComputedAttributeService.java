package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ComputedAttributeService {

    public ResponseEntity<?> getAllAttributes () {
        String endpoint = "/attributes/computed";
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.SendRequest(endpoint, HttpMethod.GET, null, Object[].class);
    }

    public ResponseEntity<?> getAttributeById(Long id) {
        String endpoint = "/attributes/computed/"+id;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.SendRequest(endpoint, HttpMethod.GET, null, Object.class);
    }

    public ResponseEntity<?> getAttributes (boolean all, int ComputedAttributeId, int deviceId, int groupId, boolean refresh) {
        String endpoint = "/attributes/computed" +
                "?all=" + all +
                "&ComputedAttributeId=" +ComputedAttributeId+
                "&deviceId=" + deviceId+
                "&groupId=" + groupId+
                "&refresh=" + refresh;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.SendRequest(endpoint, HttpMethod.GET, null, Object[].class);
    }


}
