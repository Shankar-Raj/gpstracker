package com.project.gpstracker.controller;

import com.project.gpstracker.handlers.ErrorSessionHandler;
import com.project.gpstracker.model.ComputedAttribute;
import com.project.gpstracker.service.ComputedAttributeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/computed-attributes")
public class ComputedAttributeController {

    private final ComputedAttributeService ComputedAttributeService;

    public ComputedAttributeController(ComputedAttributeService ComputedAttributeService) {
        this.ComputedAttributeService = ComputedAttributeService;
    }

    @GetMapping("/all")
    public  ResponseEntity<?> getAllAttributes() {
        
        List<ComputedAttribute> ComputedAttributes = ComputedAttributeService.getAllAttributes();

        // If null, it means session expired (RestHandler returned null)
        if (ComputedAttributes == null) 
            return ErrorSessionHandler.sessionExpired();

        return ResponseEntity.ok(ComputedAttributes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAttributeById(@PathVariable Long id) {
        
        ComputedAttribute ComputedAttributes = ComputedAttributeService.getAttributeById(id);

        // If null, it means session expired (RestHandler returned null)
        if (ComputedAttributes == null) {
            return ErrorSessionHandler.sessionExpired();
        }

        return ResponseEntity.ok(ComputedAttributes);
    }

    @GetMapping("/{ComputedAttributeId}/{deviceId}/{groupId}")
    public ResponseEntity<?> getAttribute(

            @PathVariable int ComputedAttributeId,
            @PathVariable int deviceId,
            @PathVariable int groupId,
            @RequestParam (required = false, defaultValue = "true") boolean all,
            @RequestParam (required = false, defaultValue = "true") boolean refresh) {
        
        ComputedAttribute ComputedAttributes = ComputedAttributeService.getAttributes( all, ComputedAttributeId, deviceId, groupId, refresh);

        // If null, it means session expired (RestHandler returned null)
        if (ComputedAttributes == null) {
            return ErrorSessionHandler.sessionExpired();
        }

        return ResponseEntity.ok(ComputedAttributes);
    }
}
