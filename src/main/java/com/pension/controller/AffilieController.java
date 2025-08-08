package com.pension.controller;

import com.pension.model.Affilie;
import com.pension.repository.AffilieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/affilies")
@CrossOrigin(origins = "*")
public class AffilieController {

    @Autowired
    private AffilieRepository affilieRepository;

    @GetMapping
    public List<Affilie> getAllAffilies() {
        return affilieRepository.findAll();
    }
}
