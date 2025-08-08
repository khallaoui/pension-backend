package com.pension.service;

import com.pension.model.Adherent;
import com.pension.repository.AdherentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdherentService {

    @Autowired
    private AdherentRepository AdherentRepository;

    // Get all Adherents
    public List<Adherent> getAllAdherents() {
        return AdherentRepository.findAll();
    }

    public Optional<Adherent> getAdherentById(Long id) {
        // Add logging here too
        System.out.println("Searching for Adherent with ID: " + id);
        return AdherentRepository.findById(id);
    }

    // Create new Adherent
    public Adherent createAdherent(Adherent Adherent) {
        return AdherentRepository.save(Adherent);
    }

    // Update Adherent
    public Adherent updateAdherent(Long id, Adherent Adherent) {
        Adherent.setId(id);
        return AdherentRepository.save(Adherent);
    }

    // Delete Adherent
    public void deleteAdherent(Long id) {
        AdherentRepository.deleteById(id);
    }

    // Get Adherents by city
    public List<Adherent> getAdherentsByCity(String city) {
        return AdherentRepository.findByCity(city);
    }
    
    public Map<String, Long> getAdherentsGroupedByCity() {
        List<Object[]> results = AdherentRepository.findAdherentsGroupedByCity();
        return results.stream()
            .collect(Collectors.toMap(
                row -> (String) row[0],
                row -> ((Number) row[1]).longValue()  // <-- convertit en long de manière sûre
            ));
    }



}