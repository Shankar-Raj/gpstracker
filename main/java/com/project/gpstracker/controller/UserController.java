package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.CustomResponse;
import com.project.gpstracker.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService UserService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(CustomResponse.of(UserService.getUsers()));
    }

    @GetMapping("/{Id}")
    public ResponseEntity<?> getUser(@PathVariable int Id) {
        return ResponseEntity.ok(CustomResponse.of(UserService.getUser(Id)));
    }

}
