package com.pension.controller;

import com.pension.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {

    @Autowired
    private OperationService operationService;

    @GetMapping("/totalAmountByPensioner/{id}")
    public ResponseEntity<Double> getTotalAmountByPensioner(@PathVariable Long id) {
        double totalAmount = operationService.getTotalAmountByPensioner(id);
        return ResponseEntity.ok(totalAmount);
    }
}
