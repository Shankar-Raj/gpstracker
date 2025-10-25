package com.project.gpstracker.controller;

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

        ResponseEntity<?> ComputedAttributes = ComputedAttributeService.getAllAttributes();
        return ResponseEntity.ok(ComputedAttributes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAttributeById(@PathVariable Long id) {

        ResponseEntity<?> ComputedAttributes = ComputedAttributeService.getAttributeById(id);
        return ResponseEntity.ok(ComputedAttributes);
    }

    @GetMapping("/{ComputedAttributeId}/{deviceId}/{groupId}")
    public ResponseEntity<?> getAttribute(

            @PathVariable int ComputedAttributeId,
            @PathVariable int deviceId,
            @PathVariable int groupId,
            @RequestParam (required = false, defaultValue = "true") boolean all,
            @RequestParam (required = false, defaultValue = "true") boolean refresh) {

        ResponseEntity<?> ComputedAttributes = ComputedAttributeService.getAttributes( all, ComputedAttributeId, deviceId, groupId, refresh);
        return ResponseEntity.ok(ComputedAttributes);
    }
}
