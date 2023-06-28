package com.example.lesson50_springsecurity.repository;

import com.example.lesson50_springsecurity.entity.Operation;
import com.example.lesson50_springsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalcRepository extends JpaRepository<Operation, Long> {

}
