package com.pension.controller;

import com.pension.model.Adherent;
import com.pension.service.AdherentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/pensioners")
@CrossOrigin(origins = "http://localhost:9002")
public class AdherentController {

    @Autowired
    private AdherentService adherentService;

    @GetMapping
    public List<Adherent> getAllPensioners() {
        return adherentService.getAllAdherents();  // utilise getAllAdherents ici
    }

    @GetMapping("/{id}")
    public ResponseEntity<Adherent> getPensionerById(@PathVariable Long id) {
        Optional<Adherent> pensioner = adherentService.getAdherentById(id);
        return pensioner.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Adherent createPensioner(@RequestBody Adherent pensioner) {
        return adherentService.createAdherent(pensioner);
    }

    @PutMapping("/{id}")
    public Adherent updatePensioner(@PathVariable Long id, @RequestBody Adherent pensioner) {
        return adherentService.updateAdherent(id, pensioner);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePensioner(@PathVariable Long id) {
        adherentService.deleteAdherent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/city/{city}")
    public List<Adherent> getPensionersByCity(@PathVariable String city) {
        return adherentService.getAdherentsByCity(city);
    }
}
