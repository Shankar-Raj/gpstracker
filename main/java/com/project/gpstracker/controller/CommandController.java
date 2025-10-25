package com.project.gpstracker.controller;

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

        ResponseEntity<?> Commands = CommandService.getAllCommands();
        return ResponseEntity.ok(Commands);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCommandById(@PathVariable int id) {

        ResponseEntity<?> Commands = CommandService.getCommandById(id);
        return ResponseEntity.ok(Commands);
    }

    @GetMapping("/{userId}/{deviceId}/{groupId}")
    public ResponseEntity<?> getCommands(

            @PathVariable int userId,
            @PathVariable int deviceId,
            @PathVariable int groupId,
            @RequestParam (required = false, defaultValue = "false") boolean all,
            @RequestParam (required = false, defaultValue = "false") boolean refresh) {

        ResponseEntity<?> Commands = CommandService.getCommands( all, userId, deviceId, groupId, refresh);
        return ResponseEntity.ok(Commands);
    }
}
