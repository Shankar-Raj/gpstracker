package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.Position;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class PositionService {

    public Position[] getAllPositions () {
        String endpoint = "/positions";
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Position[].class);

    }

    public Position[] getPositions (int deviceId, int Id, String From, String To) {
        String endpoint = "/positions" +
                "?deviceId=" + deviceId+
                "&from=" + From+
                "&to=" + To+
                "&id="+Id;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Position[].class);

    }


}
