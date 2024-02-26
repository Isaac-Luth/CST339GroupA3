package com.groupa3.groupa3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupa3.groupa3.service.AuthenticationServiceInterface;


@Controller
@RequestMapping("/login")
public class LoginController {
    
    private final AuthenticationServiceInterface authenticationService;

    @Autowired
    public LoginController(AuthenticationServiceInterface authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/doLogin")
    public String doLogin(@RequestParam String username, @RequestParam String password, Model model) {
        if (authenticationService.authenticate(username, password)) {
            // Authentication successful, proceed with further actions
            return "home";
        } else {
            // Authentication failed, display error message
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}