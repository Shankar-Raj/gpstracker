package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    public ResponseEntity<?> getAllGroups () {
        String endpoint = "/groups?all=true";
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.SendRequest(endpoint, HttpMethod.GET, null, Object[].class);

    }

    public ResponseEntity<?> getGroupById(int Id) {
        String endpoint = "/groups/"+Id;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.SendRequest(endpoint, HttpMethod.GET, null, Object.class);
    }

    public ResponseEntity<?> getGroups (boolean all, int userId) {
        String endpoint = "/groups" +
                "?all=" +all+
                "&userId=" +userId;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.SendRequest(endpoint, HttpMethod.GET, null, Object[].class);

    }

}
