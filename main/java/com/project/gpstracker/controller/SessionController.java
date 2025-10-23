package com.project.gpstracker.controller;

import com.project.gpstracker.model.Session;
import com.project.gpstracker.service.SessionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class SessionController {

    @GetMapping ("/login/{username}/{password}")
    public Session login(@PathVariable String username, @PathVariable String password ) {
        return SessionService.login(username,password);

    }

    @GetMapping ("/logout")
    public String logout() {
        return SessionService.logout();

    }
}

