package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.ErrorSessionHandler;
import com.project.gpstracker.model.ServerInfo;
import com.project.gpstracker.service.ServerInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/server-info")
public class ServerInfoController {

    private final ServerInfoService ServerInfoService;

    public ServerInfoController(ServerInfoService ServerInfoService) {
        this.ServerInfoService = ServerInfoService;
    }

    @GetMapping()
    public ResponseEntity<?> getServerDetails() {
        
        ServerInfo ServerInfos = ServerInfoService.getServerDetails();

        // If null, it means session expired (RestHandler returned null)
        if (ServerInfos == null)
            return ErrorSessionHandler.sessionExpired();

        return ResponseEntity.ok(ServerInfos);
    }

}
