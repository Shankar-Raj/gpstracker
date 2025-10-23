package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.Calendar;
import org.springframework.http.*;
import org.springframework.stereotype.Service;


@Service
public class CalendarService {

    public Calendar[] getCalendars() {
        String endpoint = "/calendars";
        // Parameters (Tag, RestMethod, Object Body, Response type
        return RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Calendar[].class);

    }

    public Calendar getCalendarById( int id ) {
        String endpoint = "/calendars/"+id;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Calendar.class);

    }

    public Calendar[] getCalendar (boolean all, int userId) {
        String endpoint = "/calendars" +
                "?all=" + all +
                "&userId=" +userId;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Calendar[].class);
    }

}
