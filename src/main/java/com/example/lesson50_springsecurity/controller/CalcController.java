package com.example.lesson50_springsecurity.controller;

import com.example.lesson50_springsecurity.dto.OperationDto;
import com.example.lesson50_springsecurity.entity.OperationType;
import com.example.lesson50_springsecurity.entity.User;
import com.example.lesson50_springsecurity.factory.OperationFactory;
import com.example.lesson50_springsecurity.service.CalculatorOperation;
import com.example.lesson50_springsecurity.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/operation")
public class CalcController {

    @Autowired
    private OperationService operationService;

    @Autowired
    private OperationFactory operationFactory;


    @GetMapping("/calc")
    public String calc(Model model) {
        model.addAttribute("newOperation", new OperationDto());
        return "calc";
    }

    @PostMapping("/calc")
    public String calc(@ModelAttribute("newOperation") @Valid OperationDto dto,
                       HttpSession session,
                       Model model) {

        OperationType opType = OperationType.valueOf(dto.getType().toUpperCase());
        User user = (User) session.getAttribute("user");
        CalculatorOperation operation = operationFactory.getInstance(dto.getNum1(), dto.getNum2(), opType, user);

        double result = operationService.calculate(operation);

        model.addAttribute("result", result);
        return "calc";
    }


    @GetMapping("/history")
    public String history(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<CalculatorOperation> operationList = operationService.findAllByUsername(user.getUsername());
        model.addAttribute("operationList", operationList);
        return "history";
    }
}
