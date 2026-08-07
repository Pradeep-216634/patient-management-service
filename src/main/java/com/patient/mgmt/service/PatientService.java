package com.patient.mgmt.service;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.patient.mgmt.model.Patient;
import com.patient.mgmt.repository.PatientRepository;

@Service
public class PatientService {
	
	private final PatientRepository repository;
    private final AtomicLong sequence = new AtomicLong();

    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    public Patient create(String name, int age) {
        Patient patient = new Patient(
                sequence.incrementAndGet(),
                name,
                age
        );

        return repository.save(patient);
    }

    public Patient findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Patient not found"));
    }

    public Collection<Patient> findAll() {
        return repository.findAll();
    }

}
