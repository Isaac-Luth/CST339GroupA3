package com.groupa3.groupa3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupa3.groupa3.dto.UserRegistrationDto;
import com.groupa3.groupa3.util.VerifyInputs;

@Service
public class RegistrationService {

    @Autowired
    private VerifyInputs verifyInputs;

    public boolean register(UserRegistrationDto registrationDto) {
        if (!verifyInputs.isValidEmail(registrationDto.getEmail()) || 
            !registrationDto.getEmail().equals(registrationDto.getVerifyemail())) {
            // Handle email validation failure
            return false;
        }
        
        if (!verifyInputs.isValidPassword(registrationDto.getPassword()) || 
            !registrationDto.getPassword().equals(registrationDto.getVerifypassword())) {
            // Handle password validation failure
            return false;
        }
        
        // Additional validation logic can be added here
    
        // If all validations pass
        return true;
    }
    
}
