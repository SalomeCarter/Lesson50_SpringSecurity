package com.example.lesson50_springsecurity.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class OperationDto {
    private double num1;
    private double num2;
    private String type;

}
