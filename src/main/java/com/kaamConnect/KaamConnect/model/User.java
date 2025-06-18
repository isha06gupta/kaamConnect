package com.kaamConnect.KaamConnect.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password; // Store hashed!
    private String role; // WORKER, EMPLOYER, NGO, ADMIN, etc.
}