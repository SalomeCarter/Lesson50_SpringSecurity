package com.example.lesson50_springsecurity.service;

import com.example.lesson50_springsecurity.entity.Operation;
import com.example.lesson50_springsecurity.entity.User;
import com.example.lesson50_springsecurity.enums.Role;
import com.example.lesson50_springsecurity.repository.CalcRepository;
import com.example.lesson50_springsecurity.storage.OperationStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OperationService {
    @Autowired
    private CalcRepository calcRepository;

    private final OperationStorage operationStorage;

    public OperationService(OperationStorage operationStorage) {
        this.operationStorage = operationStorage;
    }

    public double calculate(CalculatorOperation operation) {
        operation.process();
        operationStorage.save(operation);
        return operation.getFinalResult();
    }


    public List<CalculatorOperation> findAllByUsername(String username) {
        return operationStorage.findAllByUsername(username);
    }
}