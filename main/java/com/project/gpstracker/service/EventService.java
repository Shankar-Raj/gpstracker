package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.Event;
import com.project.gpstracker.model.Event;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    public Event getEvent(long id) {
        String endpoint = "/events/"+id;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        Event Event = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Event.class);

        if (Event == null)
            return null; // Pass null up so controller can detect session expiry

        return Event;
    }
}
