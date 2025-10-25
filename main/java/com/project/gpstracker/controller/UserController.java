package com.project.gpstracker.controller;

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
        ResponseEntity<?> Users = UserService.getUsers();
        return ResponseEntity.ok(Users);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<?> getUser(@PathVariable int Id) {
        ResponseEntity<?> User = UserService.getUser(Id);
        return ResponseEntity.ok(User);
    }

}
