package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.ErrorSessionHandler;
import com.project.gpstracker.model.Group;
import com.project.gpstracker.model.Group;
import com.project.gpstracker.service.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    private final GroupService GroupService;

    public GroupController(GroupService GroupService) {
        this.GroupService = GroupService;
    }

    @GetMapping("all")
    public ResponseEntity<?> getAllGroups() {
         
        List<Group> Groups = GroupService.getAllGroups();

        // If null, it means session expired (RestHandler returned null)
        if (Groups == null)
            return ErrorSessionHandler.sessionExpired();

        return ResponseEntity.ok(Groups);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGroupById(@PathVariable Long id) {
         
        Group Groups = GroupService.getGroupById(id);

        // If null, it means session expired (RestHandler returned null)
        if (Groups == null) {
            return ErrorSessionHandler.sessionExpired();
        }

        return ResponseEntity.ok(Groups);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getGroups(
            @PathVariable int userId,
            @RequestParam (required = false, defaultValue = "true") boolean all) {
         
        Group Groups = GroupService.getGroups( all, userId );

        // If null, it means session expired (RestHandler returned null)
        if (Groups == null) {
            return ErrorSessionHandler.sessionExpired();
        }

        return ResponseEntity.ok(Groups);
    }
}
