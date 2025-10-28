package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.CustomResponseHandler;
import com.project.gpstracker.service.CommandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commands")
public class CommandController {

    @Autowired
    private CommandService CommandService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllCommands () {
        return ResponseEntity.ok(CustomResponseHandler.of(CommandService.getAllCommands()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCommandById(@PathVariable int id) {
        return ResponseEntity.ok(CustomResponseHandler.of(CommandService.getCommandById(id)));
    }

    @GetMapping("/{userId}/{deviceId}/{groupId}")
    public ResponseEntity<?> getCommands(
            @PathVariable int userId,
            @PathVariable int deviceId,
            @PathVariable int groupId,
            @RequestParam (required = false, defaultValue = "false") boolean all,
            @RequestParam (required = false, defaultValue = "false") boolean refresh) {
        return ResponseEntity.ok(CustomResponseHandler.of(CommandService.getCommands( all, userId, deviceId, groupId, refresh)));
    }
}
