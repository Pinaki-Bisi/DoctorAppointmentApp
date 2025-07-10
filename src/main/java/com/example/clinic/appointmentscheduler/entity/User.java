package com.example.clinic.appointmentscheduler.entity;

@Entity
public class User {

    @Id @GeneratedValue
    private Long id;

    private String username; // or email

    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
}

