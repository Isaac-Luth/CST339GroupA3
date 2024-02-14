package com.groupa3.groupa3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupa3.groupa3.dto.UserRegistrationDto;
import com.groupa3.groupa3.service.RegistrationService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    // Method to add an empty UserRegistrationDto to the model
    @ModelAttribute("userRegistrationDto")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @PostMapping("/register")
    public String registerUserAccount(@ModelAttribute("userRegistrationDto") UserRegistrationDto registrationDto, BindingResult result) {
        // Here, you can add your validation logic. If there are errors, return back to the registration form view.
        if (result.hasErrors()) {
            return "signup"; // Assuming 'signup' is the name of your registration form view.
        }

        registrationService.register(registrationDto);
        return "redirect:/registration?success";
    }
}

