package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.Event;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    public Event getEvent(long id) {
        String endpoint = "/events/"+id;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Event.class);
    }
}
