package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.Calendar;
import com.project.gpstracker.model.Calendar;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class CalendarService {

    public List<Calendar> getCalendars() {

        String endpoint = "/calendars";

        // Parameters (Tag, RestMethod, Object Body, Response type
        Calendar[] CalendarArray = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Calendar[].class);

        if (CalendarArray == null) {
            return null; // Pass null up so controller can detect session expiry
        }

        return Arrays.asList(CalendarArray);

    }

    public Calendar getCalendarById( int id ) {

        String endpoint = "/calendars/"+id;

        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        Calendar Calendar = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Calendar.class);

        if (Calendar == null)
            return null; // Pass null up so controller can detect session expiry

        return Calendar;

    }

    public Calendar getCalendar (boolean all, int userId) {
        String endpoint = "/Calendars" +
                "?all=" + all +
                "&userId=" +userId;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        Calendar Calendar = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Calendar.class);

        if (Calendar == null)
            return null; // Pass null up so controller can detect session expiry

        return Calendar;
    }

}
