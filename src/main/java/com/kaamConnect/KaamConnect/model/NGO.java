package com.kaamConnect.KaamConnect.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class NGO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ngoName;
    private String registrationNumber;
    private String contactPerson;
    private String email;
    private String contactNumber;
    private String address;
    private String focusArea;
}