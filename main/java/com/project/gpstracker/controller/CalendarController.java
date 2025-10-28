package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.CustomResponseHandler;
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
        return ResponseEntity.ok(CustomResponseHandler.of(CalendarService.getCalendars()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCalendar(@PathVariable int id ) {
        return ResponseEntity.ok(CustomResponseHandler.of(CalendarService.getCalendarById(id)));
    }

    @GetMapping
    public ResponseEntity<?> getCalendars(
            @RequestParam int userId,
            @RequestParam (required = false, defaultValue = "false") boolean all) {
        return ResponseEntity.ok(CustomResponseHandler.of(CalendarService.getCalendar( all, userId)));
        
    }
}
