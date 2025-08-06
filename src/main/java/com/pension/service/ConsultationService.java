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
    private final AffiliateRepository affiliateRepo;
    private final RetireeRepository retireeRepo;
    private final SalaryRepository salaryRepo;
    private final AllocataireRepository allocataireRepo;

    @Autowired
    public ConsultationService(
        AdherentRepository a,
        AffiliateRepository af,
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

    public List<Affiliate> getActiveOrBeneficiaries() {
        return affiliateRepo.findByActifTrueOrAyantDroitTrue();
    }

    public List<Retiree> getRetireesOrReimbursed() {
        return retireeRepo.findByRembourseTrue();
    }

    public List<Salary> getSalariesByAllocataire(Long allocataireId) {
        return salaryRepo.findByAllocataireId(allocataireId);
    }

    public Optional<Allocataire> getAllocataireStatus(Long id) {
        return allocataireRepo.findById(id);
    }
}
