package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.CustomResponse;
import com.project.gpstracker.service.SessionService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class SessionController {

    @GetMapping ("/login/{username}/{password}")
    public ResponseEntity<?> login(@PathVariable String username, @PathVariable String password ) {
        return ResponseEntity.ok(CustomResponse.of(SessionService.login(username,password)));

    }

    @GetMapping ("/logout")
    public ResponseEntity<?> logout() {
        return ResponseEntity.ok(CustomResponse.of(SessionService.logout()));
    }
}

