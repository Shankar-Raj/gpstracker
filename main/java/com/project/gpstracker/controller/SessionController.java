package com.project.gpstracker.controller;

import com.project.gpstracker.model.Session;
import com.project.gpstracker.service.SessionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class SessionController {

    @GetMapping ("/login")
    public Session login() {
        return SessionService.login();

    }

    @GetMapping ("/logout")
    public String logout() {
        return SessionService.logout();

    }
}

