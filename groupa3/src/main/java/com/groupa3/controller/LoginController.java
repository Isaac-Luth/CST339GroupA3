package com.groupa3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

    @GetMapping("/login")
    public String display(Model model) {
        model.addAttribute("title", "Login Form");
        return "login";
    }
    

    /* @ModelAttribute("userLoginDto")
    public UserDto userLoginDto() {
        return new UserDto();
    }

    @PostMapping("/doLogin")
    public String doLogin(@ModelAttribute("userLoginDto") UserDto loginDto,
            BindingResult result) {

        if (result.hasErrors()) {
            return "login";
        }

        if (!dataAccessObject.authenticateUser(loginDto)) {
            return "login";
        }

        return "redirect:/trylogin?success";
    }

    @GetMapping
    public String loginSuccess() {
        return "menu";
    } */
}