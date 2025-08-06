package com.pension.controller;

import com.pension.repository.PensionerRepository;
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
    private PensionerRepository pensionerRepository;
    
    @Autowired
    private OperationRepository operationRepository;
    
    // GET /api/dashboard/stats - Get dashboard statistics
    @GetMapping("/stats")
    public Map<String, Object> getDashboardStats() {
        Map<String, Object> stats = new HashMap<>();
        
        // Total pensioners
        stats.put("totalPensioners", pensionerRepository.count());
        
        // Pensioners by city
        stats.put("pensionersByCity", pensionerRepository.countPensionersByCity());
        
        // Pensioners by payment method
        stats.put("pensionersByPaymentMethod", pensionerRepository.countPensionersByPaymentMethod());
        
        // Recent operations count
        stats.put("totalOperations", operationRepository.count());
        
        return stats;
    }
}