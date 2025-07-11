package com.example.clinic.appointmentscheduler.controller;

import com.example.clinic.appointmentscheduler.dto.LoginRequest;
import com.example.clinic.appointmentscheduler.dto.SignupRequest;
import com.example.clinic.appointmentscheduler.dto.AuthResponse;
import com.example.clinic.appointmentscheduler.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody SignupRequest request) {
        return ResponseEntity.ok(authService.signup(request));
    }
}

