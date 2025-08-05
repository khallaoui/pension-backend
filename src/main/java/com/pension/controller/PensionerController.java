package com.pension.controller;

import com.pension.model.Pensioner;
import com.pension.service.PensionerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pensioners")
@CrossOrigin(origins = "http://localhost:3000") // Allow Next.js frontend
public class PensionerController {
    
    @Autowired
    private PensionerService pensionerService;
    
    // GET /api/pensioners - Get all pensioners
    @GetMapping
    public List<Pensioner> getAllPensioners() {
        return pensionerService.getAllPensioners();
    }
    
    // GET /api/pensioners/{id} - Get pensioner by ID
    @GetMapping("/{id}")
    public ResponseEntity<Pensioner> getPensionerById(@PathVariable Long id) {
        return pensionerService.getPensionerById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    // POST /api/pensioners - Create new pensioner
    @PostMapping
    public Pensioner createPensioner(@RequestBody Pensioner pensioner) {
        return pensionerService.createPensioner(pensioner);
    }
    
    // PUT /api/pensioners/{id} - Update pensioner
    @PutMapping("/{id}")
    public Pensioner updatePensioner(@PathVariable Long id, @RequestBody Pensioner pensioner) {
        return pensionerService.updatePensioner(id, pensioner);
    }
    
    // DELETE /api/pensioners/{id} - Delete pensioner
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePensioner(@PathVariable Long id) {
        pensionerService.deletePensioner(id);
        return ResponseEntity.ok().build();
    }
    
    // GET /api/pensioners/city/{city} - Get pensioners by city
    @GetMapping("/city/{city}")
    public List<Pensioner> getPensionersByCity(@PathVariable String city) {
        return pensionerService.getPensionersByCity(city);
    }
}