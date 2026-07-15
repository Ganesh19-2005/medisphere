package com.medisphere.medispherebackend.fhir;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FhirSyncController {

    @GetMapping("/api/fhir/sync")
    public Map<String, String> sync() {

        Map<String, String> response = new HashMap<>();

        response.put("status", "SUCCESS");
        response.put("message", "FHIR Synchronization Completed");

        return response;
    }
}