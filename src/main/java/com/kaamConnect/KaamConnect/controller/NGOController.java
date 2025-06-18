package com.kaamConnect.KaamConnect.controller;

import com.kaamConnect.KaamConnect.model.NGO;
import com.kaamConnect.KaamConnect.Repository.NGORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ngos")
@CrossOrigin
public class NGOController {

    @Autowired
    private NGORepository ngoRepository;

    @GetMapping
    public List<NGO> getAllNgos() {
        return ngoRepository.findAll();
    }

    @PostMapping
    public NGO createNgo(@RequestBody NGO ngo) {
        return ngoRepository.save(ngo);
    }
}
