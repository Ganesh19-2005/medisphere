package com.medisphere.medispherebackend.patient;

import com.medisphere.medispherebackend.exception.PatientNotFoundException;
import com.medisphere.medispherebackend.kafka.KafkaProducerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository repository;
    private final KafkaProducerService kafkaProducerService;

    public PatientService(PatientRepository repository,
                          KafkaProducerService kafkaProducerService) {
        this.repository = repository;
        this.kafkaProducerService = kafkaProducerService;
    }

    public List<Patient> getAllPatients() {
        return repository.findAll();
    }

    public Patient savePatient(Patient patient) {

        Patient savedPatient = repository.save(patient);

        kafkaProducerService.sendMessage(
                "New Patient Registered: " + savedPatient.getName());

        return savedPatient;
    }

    public Patient updatePatient(String id, Patient patient) {

        patient.setId(id);

        Patient updatedPatient = repository.save(patient);

        kafkaProducerService.sendMessage(
                "Patient Updated: " + updatedPatient.getName());

        return updatedPatient;
    }

    public void deletePatient(String id) {

        kafkaProducerService.sendMessage(
                "Patient Deleted: " + id);

        repository.deleteById(id);
    }

    public Patient getPatientById(String id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new PatientNotFoundException("Patient not found with id: " + id));
    }
}