package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.Position;
import com.project.gpstracker.model.Position;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PositionService {

    public List<Position> getAllPositions () {
        String endpoint = "/positions";
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        Position[] PositionArray = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Position[].class);

        if (PositionArray == null) {
            return null; // Pass null up so controller can detect session expiry
        }

        return Arrays.asList(PositionArray);

    }

    public Position getPositions (int deviceId, int Id, String From, String To) {
        String endpoint = "/positions" +
                "?deviceId=" + deviceId+
                "&from=" + From+
                "&to=" + To+
                "&id="+Id;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        Position Position = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Position.class);

        if (Position == null)
            return null; // Pass null up so controller can detect session expiry

        return Position;

    }


}
