package com.project.gpstracker.controller;

import com.project.gpstracker.service.ServerInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/server-info")
public class ServerInfoController {

    @Autowired
    private ServerInfoService ServerInfoService;

    @GetMapping()
    public ResponseEntity<?> getServerDetails() {
        return ResponseEntity.ok(ServerInfoService.getServerDetails());
    }

}
