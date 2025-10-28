package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.CustomResponseHandler;
import com.project.gpstracker.service.SessionService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class SessionController {

    @GetMapping ("/login/{username}/{password}")
    public ResponseEntity<?> login(@PathVariable String username, @PathVariable String password ) {
        return ResponseEntity.ok(CustomResponseHandler.of(SessionService.login(username,password)));

    }

    @GetMapping ("/logout")
    public ResponseEntity<?> logout() {
        return ResponseEntity.ok(CustomResponseHandler.of(SessionService.logout()));
    }
}

