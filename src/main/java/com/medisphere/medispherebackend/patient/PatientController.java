package com.medisphere.medispherebackend.patient;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

    private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return service.getAllPatients();
    }

    @PostMapping
    public Patient savePatient(@Valid @RequestBody Patient patient) {
        return service.savePatient(patient);
    }
    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable String id,
                                 @Valid @RequestBody Patient patient)  {
        return service.updatePatient(id, patient);
    }
    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable String id) {
        service.deletePatient(id);
        return "Patient deleted successfully";
    }
}