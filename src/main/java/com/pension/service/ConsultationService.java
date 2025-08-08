package com.pension.service;

import com.pension.model.*;
import com.pension.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultationService {

    private final AdherentRepository adherentRepo;
    private final AffilieRepository affiliateRepo;
    private final RetireeRepository retireeRepo;
    private final SalaryRepository salaryRepo;
    private final AllocataireRepository allocataireRepo;

    @Autowired
    public ConsultationService(
        AdherentRepository a,
        AffilieRepository af,
        RetireeRepository r,
        SalaryRepository s,
        AllocataireRepository al) {
        
        this.adherentRepo = a;
        this.affiliateRepo = af;
        this.retireeRepo = r;
        this.salaryRepo = s;
        this.allocataireRepo = al;
    }

    public List<Adherent> getAllAdherents() {
        return adherentRepo.findAll();
    }

    public List<Affilie> getActiveOrBeneficiaries() {
        return affiliateRepo.findByActifTrueOrAyantDroitTrue();
    }

    public List<Retiree> getRetireesOrReimbursed() {
        return retireeRepo.findByRembourseTrue();
    }

    public List<Salary> getSalariesByAllocataire(Long allocataireId) {
        return salaryRepo.findByAllocataireIdAllocataire(allocataireId);
    }

    public Optional<Allocataire> getAllocataireStatus(Long id) {
        return allocataireRepo.findById(id);
    }
}
