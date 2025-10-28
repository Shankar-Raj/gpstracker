package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.CustomResponseHandler;
import com.project.gpstracker.service.ComputedAttributeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/computed-attributes")
public class ComputedAttributeController {

    @Autowired
    private ComputedAttributeService ComputedAttributeService;

    @GetMapping("/all")
    public  ResponseEntity<?> getAllAttributes() {
        return ResponseEntity.ok(CustomResponseHandler.of(ComputedAttributeService.getAllAttributes()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAttributeById(@PathVariable Long id) {
        return ResponseEntity.ok(CustomResponseHandler.of(ComputedAttributeService.getAttributeById(id)));
    }

    @GetMapping("/{ComputedAttributeId}/{deviceId}/{groupId}")
    public ResponseEntity<?> getAttribute(
            @PathVariable int ComputedAttributeId,
            @PathVariable int deviceId,
            @PathVariable int groupId,
            @RequestParam (required = false, defaultValue = "true") boolean all,
            @RequestParam (required = false, defaultValue = "true") boolean refresh) {
        return ResponseEntity.ok(CustomResponseHandler.of(ComputedAttributeService.getAttributes( all, ComputedAttributeId, deviceId, groupId, refresh)));
    }
}
