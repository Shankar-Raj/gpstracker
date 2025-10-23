package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.ErrorSessionHandler;
import com.project.gpstracker.model.Group;
import com.project.gpstracker.service.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groups")
public class GroupController {

    private final GroupService GroupService;

    public GroupController(GroupService GroupService) {
        this.GroupService = GroupService;
    }

    @GetMapping("all")
    public ResponseEntity<?> getAllGroups() {

        Group[] Groups = GroupService.getAllGroups();

        // If null, it means session expired (RestHandler returned null)
        if (Groups == null)
            return ErrorSessionHandler.sessionExpired();

        return ResponseEntity.ok(Groups);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<?> getGroupById(@PathVariable int Id) {

        Group Group = GroupService.getGroupById(Id);

        // If null, it means session expired (RestHandler returned null)
        if (Group == null) {
            return ErrorSessionHandler.sessionExpired();
        }

        return ResponseEntity.ok(Group);
    }

    @GetMapping
    public ResponseEntity<?> getGroups(
            @RequestParam int userId,
            @RequestParam (required = false, defaultValue = "false") boolean all) {

        Group[] Groups = GroupService.getGroups( all, userId );

        // If null, it means session expired (RestHandler returned null)
        if (Groups == null) {
            return ErrorSessionHandler.sessionExpired();
        }

        return ResponseEntity.ok(Groups);
    }
}
