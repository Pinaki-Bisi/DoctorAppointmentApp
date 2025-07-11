package com.example.clinic.appointmentscheduler.repository;

import com.example.clinic.appointmentscheduler.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
