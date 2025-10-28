package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.CustomResponseHandler;
import com.project.gpstracker.service.GroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupService GroupService;

    @GetMapping("all")
    public ResponseEntity<?> getAllGroups() {
        return ResponseEntity.ok(CustomResponseHandler.of(GroupService.getAllGroups()));
    }

    @GetMapping("/{Id}")
    public ResponseEntity<?> getGroupById(@PathVariable int Id) {
        return ResponseEntity.ok(CustomResponseHandler.of(GroupService.getGroupById(Id)));
    }

    @GetMapping
    public ResponseEntity<?> getGroups(
            @RequestParam int userId,
            @RequestParam (required = false, defaultValue = "false") boolean all) {
        return ResponseEntity.ok(CustomResponseHandler.of(GroupService.getGroups(all, userId)));
    }
}
