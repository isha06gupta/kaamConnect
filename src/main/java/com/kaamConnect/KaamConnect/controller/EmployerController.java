package com.kaamConnect.KaamConnect.controller;

import com.kaamConnect.KaamConnect.model.Employer;
import com.kaamConnect.KaamConnect.Repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployerController {

    @Autowired
    private EmployerRepository employerRepository;

    @GetMapping
    public List<Employer> getAllEmployers() {
        return employerRepository.findAll();
    }

    @PostMapping
    public Employer createEmployer(@RequestBody Employer employer) {
        return employerRepository.save(employer);
    }
}
