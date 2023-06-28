package com.example.lesson50_springsecurity.controller;

import com.example.lesson50_springsecurity.dto.LoginUserDto;
import com.example.lesson50_springsecurity.entity.User;
import com.example.lesson50_springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("newLogin", new LoginUserDto());
        return "login";
    }

    @GetMapping("/reg")
    public String reg(Model model) {
        model.addAttribute("newUser", new User());
        return "reg";
    }

    @PostMapping("/reg")
    public String reg(@ModelAttribute("newUser") @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "reg";
        }
        userService.add(user);
        return "redirect:/";
    }
}


