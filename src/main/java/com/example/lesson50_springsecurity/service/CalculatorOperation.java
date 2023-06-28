package com.example.lesson50_springsecurity.service;

import com.example.lesson50_springsecurity.entity.User;

public interface CalculatorOperation {
    void process();
    double getFinalResult();
    User getAuthor();
}

