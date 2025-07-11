package com.example.clinic.appointmentscheduler.service;

import com.example.clinic.appointmentscheduler.dto.AppointmentDto;
import com.example.clinic.appointmentscheduler.entity.Appointment;
import com.example.clinic.appointmentscheduler.entity.Doctor;
import com.example.clinic.appointmentscheduler.entity.Patient;
import com.example.clinic.appointmentscheduler.repository.AppointmentRepository;
import com.example.clinic.appointmentscheduler.repository.DoctorRepository;
import com.example.clinic.appointmentscheduler.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public Appointment createAppointment(AppointmentDto dto) {
        Doctor doctor = doctorRepository.findById(dto.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        boolean isAvailable = appointmentRepository
                .findByDoctorIdAndDateTime(doctor.getId(), dto.getDateTime())
                .isEmpty();

        if (!isAvailable) throw new RuntimeException("Doctor not available at this time");

        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setDateTime(dto.getDateTime());
        appointment.setStatus("PENDING");

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAppointmentsForPatient(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    public List<Appointment> getAppointmentsForDoctor(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    public Appointment cancelAppointment(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        appointment.setStatus("CANCELLED");
        return appointmentRepository.save(appointment);
    }
}
