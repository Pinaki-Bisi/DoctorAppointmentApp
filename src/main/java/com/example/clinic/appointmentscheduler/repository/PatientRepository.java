package com.example.clinic.appointmentscheduler.repository;

import com.example.clinic.appointmentscheduler.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
