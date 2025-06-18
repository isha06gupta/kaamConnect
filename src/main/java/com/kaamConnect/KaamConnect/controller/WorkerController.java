package com.kaamConnect.KaamConnect.controller;

import com.kaamConnect.KaamConnect.model.Worker;
import com.kaamConnect.KaamConnect.Repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workers")
@CrossOrigin // Allow React/Vue/Angular or your frontend
public class WorkerController {

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping
    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }

    @PostMapping
    public Worker createWorker(@RequestBody Worker worker) {
        return workerRepository.save(worker);
    }
}