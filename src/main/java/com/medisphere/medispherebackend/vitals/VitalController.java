package com.medisphere.medispherebackend.vitals;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vitals")
@CrossOrigin(origins = "http://localhost:4200")
public class VitalController {

    private final VitalRepository repository;

    public VitalController(VitalRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Vital> getAllVitals() {
        return repository.findAll();
    }

    @PostMapping
    public Vital addVital(@RequestBody Vital vital) {
        return repository.save(vital);
    }
}