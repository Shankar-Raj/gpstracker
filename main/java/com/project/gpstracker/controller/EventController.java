package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.ErrorSessionHandler;
import com.project.gpstracker.model.Event;
import com.project.gpstracker.model.Event;
import com.project.gpstracker.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    private final EventService EventService;

    public EventController(EventService EventService) {
        this.EventService = EventService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEvent(@PathVariable Long id) {
         
        Event Events = EventService.getEvent(id);

        // If null, it means session expired (RestHandler returned null)
        if (Events == null) {
            return ErrorSessionHandler.sessionExpired();
        }

        return ResponseEntity.ok(Events);
    }

}
