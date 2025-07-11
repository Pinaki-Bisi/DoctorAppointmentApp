package com.example.clinic.appointmentscheduler.service;

import com.example.clinic.appointmentscheduler.entity.Doctor;
import com.example.clinic.appointmentscheduler.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
}
