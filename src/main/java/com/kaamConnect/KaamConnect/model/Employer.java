package com.kaamConnect.KaamConnect.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String organizationName;
    private String contactPerson;
    private String email;
    private String jobPosition;
    private String requiredSkill;
    private String jobLocation;
}