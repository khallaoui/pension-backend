package com.pension.controller;

import com.pension.repository.AdherentRepository;
import com.pension.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "http://localhost:9002")
public class DashboardController {
    
    @Autowired
    private AdherentRepository adherentRepository;
    
    @Autowired
    private OperationRepository operationRepository;
    
    @GetMapping("/stats")
    public Map<String, Object> getDashboardStats() {
        Map<String, Object> stats = new HashMap<>();
        
        // Total pensioners
        stats.put("totalPensioners", adherentRepository.count());
        
        // Pensioners by city - utiliser le nom correct
        stats.put("pensionersByCity", adherentRepository.countAdherentsByCity());
        
        // Pensioners by payment method - utiliser le nom correct
        stats.put("pensionersByPaymentMethod", adherentRepository.countAdherentsByPaymentMethod());
        
        // Recent operations count
        stats.put("totalOperations", operationRepository.count());
        
        return stats;
    }
}