package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.CustomResponse;
import com.project.gpstracker.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService EventService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getEvent(@PathVariable Long id) {
        return ResponseEntity.ok(CustomResponse.of(EventService.getEvent(id)));
    }

}
