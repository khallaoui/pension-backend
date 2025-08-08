package com.pension.controller;

import com.pension.model.Allocataire;
import com.pension.repository.AllocataireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/allocataires")
@CrossOrigin(origins = "*")
public class AllocataireController {

    @Autowired
    private AllocataireRepository allocataireRepository;

    @GetMapping
    public List<Allocataire> getAllAllocataires() {
        return allocataireRepository.findAll();
    }
}
