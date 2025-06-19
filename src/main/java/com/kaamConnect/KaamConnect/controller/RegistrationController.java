package com.kaamConnect.KaamConnect.controller;

import com.kaamConnect.KaamConnect.model.Employer;
import com.kaamConnect.KaamConnect.model.Worker;
import com.kaamConnect.KaamConnect.model.NGO;
import com.kaamConnect.KaamConnect.Repository.EmployerRepository;
import com.kaamConnect.KaamConnect.Repository.WorkerRepository;
import com.kaamConnect.KaamConnect.Repository.NGORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
@CrossOrigin
public class RegistrationController {

    @Autowired
    private EmployerRepository employerRepo;
    @Autowired
    private WorkerRepository workerRepo;
    @Autowired
    private NGORepository ngoRepo;

    @PostMapping("/employer")
    public String registerEmployer(@ModelAttribute Employer employer) {
        employerRepo.save(employer);
        return "Registration successful";
    }

    @PostMapping("/worker")
    public String registerWorker(@ModelAttribute Worker worker) {
        workerRepo.save(worker);
        return "Registration successful";
    }

    @PostMapping("/ngo")
    public String registerNGO(@ModelAttribute NGO ngo) {
        ngoRepo.save(ngo);
        return "Registration successful";
    }
}