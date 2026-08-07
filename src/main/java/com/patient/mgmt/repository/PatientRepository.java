package com.patient.mgmt.repository;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.patient.mgmt.model.Patient;

@Repository
public class PatientRepository {
	
	private final Map<Long, Patient> patients = new ConcurrentHashMap<>();

    public Patient save(Patient patient) {
        patients.put(patient.id(), patient);
        return patient;
    }

    public Optional<Patient> findById(Long id) {
        return Optional.ofNullable(patients.get(id));
    }

    public Collection<Patient> findAll() {
        return patients.values();
    }

}
