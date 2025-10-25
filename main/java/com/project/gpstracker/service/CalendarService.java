package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;

import org.springframework.http.*;
import org.springframework.stereotype.Service;


@Service
public class CalendarService {

    public ResponseEntity<?> getCalendars() {
        String endpoint = "/calendars";
        // Parameters (Tag, RestMethod, Object Body, Response type
        return RestHandler.SendRequest(endpoint, HttpMethod.GET, null, Object[].class);

    }

    public ResponseEntity<?> getCalendarById( int id ) {
        String endpoint = "/calendars/"+id;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.SendRequest(endpoint, HttpMethod.GET, null, Object.class);

    }

    public ResponseEntity<?> getCalendar (boolean all, int userId) {
        String endpoint = "/calendars" +
                "?all=" + all +
                "&userId=" +userId;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.SendRequest(endpoint, HttpMethod.GET, null, Object[].class);
    }

}
