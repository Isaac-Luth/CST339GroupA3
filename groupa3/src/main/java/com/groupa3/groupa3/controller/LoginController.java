package com.groupa3.groupa3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupa3.groupa3.dao.DataAccessObject;
import com.groupa3.groupa3.dto.UserDto;

@Controller
@RequestMapping("/trylogin")
public class LoginController {

    @Autowired
    private DataAccessObject dataAccessObject;

    @ModelAttribute("userLoginDto")
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
    }
}