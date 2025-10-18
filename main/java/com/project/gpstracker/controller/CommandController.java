package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.ErrorSessionHandler;
import com.project.gpstracker.model.Command;
import com.project.gpstracker.service.CommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/command")
public class CommandController {

    private final CommandService CommandService;

    public CommandController(CommandService CommandService) {
        this.CommandService = CommandService;
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllCommands () {
        
        List<Command> Commands = CommandService.getAllCommands();

        // If null, it means session expired (RestHandler returned null)
        if (Commands == null)
            return ErrorSessionHandler.sessionExpired();

        return ResponseEntity.ok(Commands);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCommandById(@PathVariable int id) {
        
        Command Commands = CommandService.getCommandById(id);

        // If null, it means session expired (RestHandler returned null)
        if (Commands == null) {
            return ErrorSessionHandler.sessionExpired();
        }

        return ResponseEntity.ok(Commands);
    }

    @GetMapping("/{userId}/{deviceId}/{groupId}")
    public ResponseEntity<?> getCommands(

            @PathVariable int userId,
            @PathVariable int deviceId,
            @PathVariable int groupId,
            @RequestParam (required = false, defaultValue = "true") boolean all,
            @RequestParam (required = false, defaultValue = "true") boolean refresh) {
        
        Command Commands = CommandService.getCommands( all, userId, deviceId, groupId, refresh);

        // If null, it means session expired (RestHandler returned null)
        if (Commands == null) {
            return ErrorSessionHandler.sessionExpired();
        }

        return ResponseEntity.ok(Commands);
    }
}
