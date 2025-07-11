package com.example.clinic.appointmentscheduler.repository;

import com.example.clinic.appointmentscheduler.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPatientId(Long patientId);
    List<Appointment> findByDoctorId(Long doctorId);
    Optional<Appointment> findByDoctorIdAndDateTime(Long doctorId, LocalDateTime dateTime);
}