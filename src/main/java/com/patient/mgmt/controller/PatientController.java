package com.patient.mgmt.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patient.mgmt.model.Patient;
import com.patient.mgmt.service.PatientService;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {
	
	private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    @PostMapping
    public Patient create(@RequestBody Map<String, Object> request) {
        return service.create(
                (String) request.get("name"),
                (Integer) request.get("age")
        );
    }

    @GetMapping("/{id}")
    public Patient findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public Collection<Patient> findAll() {
        return service.findAll();
    }

}
