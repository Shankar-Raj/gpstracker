package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CommandService {

    public ResponseEntity<?> getAllCommands () {
        String endpoint = "/commands";
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.SendRequest(endpoint, HttpMethod.GET, null, Object[].class);

    }

    public ResponseEntity<?> getCommandById(int id) {
        String endpoint = "/commands/"+id;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.SendRequest(endpoint, HttpMethod.GET, null, Object.class);

    }

    public ResponseEntity<?> getCommands (boolean all, int userId, int CommandId, int groupId, boolean refresh) {
        String endpoint = "/commands" +
                "?all=" + all +
                "&userId=" +userId+
                "&groupId=" + groupId+
                "&refresh=" + refresh;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.SendRequest(endpoint, HttpMethod.GET, null, Object[].class);

    }


}
