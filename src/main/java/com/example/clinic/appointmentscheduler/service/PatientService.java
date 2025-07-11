package com.example.clinic.appointmentscheduler.service;

import com.example.clinic.appointmentscheduler.entity.Patient;
import com.example.clinic.appointmentscheduler.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }
}

