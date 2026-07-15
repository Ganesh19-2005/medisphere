package com.medisphere.medispherebackend.vitals;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface VitalRepository extends MongoRepository<Vital, String> {
}