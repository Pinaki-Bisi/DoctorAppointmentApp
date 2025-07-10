package com.example.clinic.appointmentscheduler.repository;

import com.example.clinic.appointmentscheduler.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);  // or findByEmail if needed
}
