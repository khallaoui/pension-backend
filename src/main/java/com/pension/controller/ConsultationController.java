package com.pension.controller;

import com.pension.model.*;
import com.pension.service.ConsultationService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/consultations")
@CrossOrigin(origins = "http://localhost:3000") // adapt your frontend origin
public class ConsultationController {

    private final ConsultationService consultationService;

    @Autowired
    public ConsultationController(ConsultationService service) {
        this.consultationService = service;
    }

    // Consultation générale : All adherents
    @GetMapping("/adherents")
    public List<Adherent> getAllAdherents() {
        return consultationService.getAllAdherents();
    }

    // Consultation des affiliés actifs ou ayant droit
    @GetMapping("/affiliates/active-or-beneficiaries")
    public List<Affiliate> getActiveOrBeneficiaries() {
        return consultationService.getActiveOrBeneficiaries();
    }

    // Consultation des retraités ou remboursés
    @GetMapping("/retirees/reimbursed")
    public List<Retiree> getRetireesOrReimbursed() {
        return consultationService.getRetireesOrReimbursed();
    }

    // Consultation des salaires (by allocataire id)
    @GetMapping("/salaries/allocataire/{id}")
    public List<Salary> getSalariesByAllocataire(@PathVariable Long id) {
        return consultationService.getSalariesByAllocataire(id);
    }

    // Consultation de la situation de l’allocataire
    @GetMapping("/allocataires/{id}/status")
    public ResponseEntity<Allocataire> getAllocataireStatus(@PathVariable Long id) {
        return consultationService.getAllocataireStatus(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
