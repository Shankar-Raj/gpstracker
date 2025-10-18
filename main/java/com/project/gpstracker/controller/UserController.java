package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.ErrorSessionHandler;
import com.project.gpstracker.model.User;
import com.project.gpstracker.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService UserService;

    public UserController(UserService UserService) {
        this.UserService = UserService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        List<User> Users = UserService.getUsers();

        // If null, it means session expired (RestHandler returned null)
        if (Users == null)
            return ErrorSessionHandler.sessionExpired();

        return ResponseEntity.ok(Users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id) {
        User Users = UserService.getUser(id);

        // If null, it means session expired (RestHandler returned null)
        if (Users == null)
            return ErrorSessionHandler.sessionExpired();

        return ResponseEntity.ok(Users);
    }

}
