package com.project.gpstracker.controller;

import com.project.gpstracker.service.CalendarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calendars")
public class CalendarController {

    @Autowired
    private CalendarService CalendarService;

    @GetMapping("/all")
    public ResponseEntity<?> getCalendars() {
        ResponseEntity<?> Calendars = CalendarService.getCalendars();
        return ResponseEntity.ok(Calendars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCalendar(@PathVariable int id ) {

        ResponseEntity<?> Calendars = CalendarService.getCalendarById(id);
        return ResponseEntity.ok(Calendars);
    }

    @GetMapping
    public ResponseEntity<?> getCalendars(
            @RequestParam int userId,
            @RequestParam (required = false, defaultValue = "false") boolean all) {

        ResponseEntity<?> Calendars = CalendarService.getCalendar( all, userId);
        return ResponseEntity.ok(Calendars);
        
    }
}
