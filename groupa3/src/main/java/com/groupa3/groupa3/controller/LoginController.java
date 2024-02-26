package com.groupa3.groupa3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupa3.groupa3.dto.UserLoginDto;
import com.groupa3.groupa3.service.LoginService;

@Controller
@RequestMapping("/trylogin")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ModelAttribute("userLoginDto")
    public UserLoginDto userLoginDto() {
        return new UserLoginDto();
    }

    @PostMapping("/doLogin")
    public String doLogin(@ModelAttribute("userLoginDto") UserLoginDto loginDto,
            BindingResult result) {

        if (!loginService.authenticate(loginDto.getEmail(), loginDto.getPassword())) {
            return "login";
        }

        return "redirect:/trylogin?success";
    }

    @GetMapping
    public String loginSuccess() {
        return "menu";
    }
}