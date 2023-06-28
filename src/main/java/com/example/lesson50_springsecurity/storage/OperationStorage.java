package com.example.lesson50_springsecurity.storage;

import com.example.lesson50_springsecurity.service.CalculatorOperation;

import java.util.List;

public interface OperationStorage {
    public void save(CalculatorOperation operation);

    public List<CalculatorOperation> findAll();
    List<CalculatorOperation> findAllByUsername(String username);
}