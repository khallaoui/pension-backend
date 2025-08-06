package com.pension.service;

import com.pension.model.Operation;
import com.pension.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperationService {

    @Autowired
    private OperationRepository operationRepository;

    public List<Operation> getAllOperations() {
        return operationRepository.findAll();
    }

    public Optional<Operation> getOperationById(Long id) {
        return operationRepository.findById(id);
    }

    public Operation createOperation(Operation operation) {
        return operationRepository.save(operation);
    }

    public Operation updateOperation(Long id, Operation operation) {
        operation.setId(id);
        return operationRepository.save(operation);
    }

    public void deleteOperation(Long id) {
        operationRepository.deleteById(id);
    }
    
    
    public List<Operation> getOperationsByPensionerId(Long pensionerId) {
        return operationRepository.findByPensionerId(pensionerId);
    }

    public double getTotalAmountByPensioner(Long pensionerId) {
        List<Operation> operations = operationRepository.findByPensionerId(pensionerId);
        return operations.stream()
                         .mapToDouble(op -> op.getAmount() != null ? op.getAmount().doubleValue() : 0.0)
                         .sum();
    }



}