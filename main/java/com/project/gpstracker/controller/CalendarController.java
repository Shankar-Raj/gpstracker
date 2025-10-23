package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.ErrorSessionHandler;
import com.project.gpstracker.model.Calendar;
import com.project.gpstracker.service.CalendarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calendars")
public class CalendarController {

    private final CalendarService CalendarService;

    public CalendarController(CalendarService CalendarService) {
        this.CalendarService = CalendarService;
    }
    
    @GetMapping("/all")
    public ResponseEntity<?> getCalendars() {
        Calendar[] Calendars = CalendarService.getCalendars();

        // If null, it means session expired (RestHandler returned null)
        if (Calendars == null)
            return ErrorSessionHandler.sessionExpired();

        return ResponseEntity.ok(Calendars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCalendar(@PathVariable int id ) {

        Calendar Calendars = CalendarService.getCalendarById(id);

        // If null, it means session expired (RestHandler returned null)
        if (Calendars == null) {
            return ErrorSessionHandler.sessionExpired();
        }

        return ResponseEntity.ok(Calendars);
    }

    @GetMapping
    public ResponseEntity<?> getCalendars(
            @RequestParam int userId,
            @RequestParam (required = false, defaultValue = "false") boolean all) {

        Calendar[] Calendars = CalendarService.getCalendar( all, userId);

        // If null, it means session expired (RestHandler returned null)
        if (Calendars == null) {
            return ErrorSessionHandler.sessionExpired();
        }

        return ResponseEntity.ok(Calendars);
        
    }
}
