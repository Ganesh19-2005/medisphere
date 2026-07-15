package com.medisphere.medispherebackend.consent;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consents")
@CrossOrigin(origins = "http://localhost:4200")
public class ConsentController {

    private final ConsentRepository repository;

    public ConsentController(ConsentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Consent> getAllConsents() {
        return repository.findAll();
    }

    @PostMapping
    public Consent addConsent(@RequestBody Consent consent) {
        return repository.save(consent);
    }
}