package com.groupa3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupa3.dto.UserDto;
import com.groupa3.service.RegistrationService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    // Method to add an empty UserRegistrationDto to the model
    @ModelAttribute("userRegistrationDto")
    public UserDto userDto() {
        return new UserDto();
    }

    @PostMapping("/register")
    public String registerUserAccount(@ModelAttribute("userRegistrationDto") UserDto registrationDto,
            BindingResult result) {
        // Here, you can add your validation logic. If there are errors, return back to
        // the registration form view.
        if (result.hasErrors()) {
            return "signup"; // Assuming 'signup' is the name of your registration form view.
        }

        String tempPhoneNumber = registrationDto.getTelephone();
        tempPhoneNumber = tempPhoneNumber.replaceAll("[^0-9]", "");
        registrationDto.setTelephone(tempPhoneNumber);

        if (!registrationService.register(registrationDto)) {
            return "signup";
        }
        return "redirect:/registration?success";
    }

    @GetMapping
    public String registrationSuccess() {
        return "menu";
    }
}
