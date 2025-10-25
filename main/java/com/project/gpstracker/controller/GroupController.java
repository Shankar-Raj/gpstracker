package com.project.gpstracker.controller;

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

        ResponseEntity<?> Groups = GroupService.getAllGroups();
        return ResponseEntity.ok(Groups);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<?> getGroupById(@PathVariable int Id) {

        ResponseEntity<?> Group = GroupService.getGroupById(Id);
        return ResponseEntity.ok(Group);
    }

    @GetMapping
    public ResponseEntity<?> getGroups(
            @RequestParam int userId,
            @RequestParam (required = false, defaultValue = "false") boolean all) {

        ResponseEntity<?> Groups = GroupService.getGroups( all, userId );
        return ResponseEntity.ok(Groups);
    }
}
