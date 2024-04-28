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

/**
 * Controller for user registration
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    
    
    /** 
     * @return UserDto The user registration dto
     */
    @ModelAttribute("userRegistrationDto")
    public UserDto userDto() {
        return new UserDto();
    }

    
    /** 
     * @param registrationDto The user registration dto
     * @param result The binding result
     * @return String The name of the view to display
     */
    @PostMapping("/register")
    public String registerUserAccount(@ModelAttribute("userRegistrationDto") UserDto registrationDto,
            BindingResult result) {

        if (result.hasErrors()) {
            return "signup";
        }

        String tempPhoneNumber = registrationDto.getTelephone();
        tempPhoneNumber = tempPhoneNumber.replaceAll("[^0-9]", "");
        registrationDto.setTelephone(tempPhoneNumber);

        if (!registrationService.register(registrationDto)) {
            return "signup";
        }
        return "redirect:/registrationSuccess";
    }

    
    /** 
     * @return String The name of the view to display
     */
    @GetMapping("/registrationSuccess")
    public String registrationSuccess() {
        return "menu";
    }
}
