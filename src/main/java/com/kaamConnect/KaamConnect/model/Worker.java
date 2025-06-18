package com.kaamConnect.KaamConnect.model;    
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private Integer age;
    private String skillType;
    private String mobileNumber;
    private String address;
    private Integer experienceYears;
}