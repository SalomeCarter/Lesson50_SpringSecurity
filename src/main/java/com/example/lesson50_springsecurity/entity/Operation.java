package com.example.lesson50_springsecurity.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "operations")
@Getter
@Setter
@ToString
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double num1;

    private Double num2;

    private Double result;

    @Enumerated(EnumType.STRING)
    private OperationType type;

    private LocalDateTime time;

    @ManyToOne
//    @Transient
    private User author;
}
