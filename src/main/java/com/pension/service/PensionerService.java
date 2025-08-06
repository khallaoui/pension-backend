package com.pension.service;

import com.pension.model.Pensioner;
import com.pension.repository.PensionerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PensionerService {

    @Autowired
    private PensionerRepository pensionerRepository;

    // Get all pensioners
    public List<Pensioner> getAllPensioners() {
        return pensionerRepository.findAll();
    }

    // Get pensioner by ID
    public Optional<Pensioner> getPensionerById(Long id) {
        return pensionerRepository.findById(id);
    }

    // Create new pensioner
    public Pensioner createPensioner(Pensioner pensioner) {
        return pensionerRepository.save(pensioner);
    }

    // Update pensioner
    public Pensioner updatePensioner(Long id, Pensioner pensioner) {
        pensioner.setId(id);
        return pensionerRepository.save(pensioner);
    }

    // Delete pensioner
    public void deletePensioner(Long id) {
        pensionerRepository.deleteById(id);
    }

    // Get pensioners by city
    public List<Pensioner> getPensionersByCity(String city) {
        return pensionerRepository.findByCity(city);
    }
    
    public Map<String, Long> getPensionersGroupedByCity() {
        List<Object[]> results = pensionerRepository.findPensionersGroupedByCity();
        return results.stream()
            .collect(Collectors.toMap(
                row -> (String) row[0],
                row -> (Long) row[1]
            ));
    }


}