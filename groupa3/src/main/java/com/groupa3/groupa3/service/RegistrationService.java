package com.groupa3.groupa3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupa3.groupa3.dao.DataAccessObject;
import com.groupa3.groupa3.dto.UserDto;
import com.groupa3.groupa3.util.VerifyInputs;

@Service
public class RegistrationService {

    @Autowired
    private VerifyInputs verifyInputs;

    @Autowired
    private DataAccessObject dataAccessObject;

    public boolean register(UserDto registrationDto) {
        if (!verifyInputs.isValidEmail(registrationDto.getEmail()) ||
                !registrationDto.getEmail().equals(registrationDto.getVerifyemail())) {
            System.out.println("Email validation failed");
            return false;
        }

        if (!verifyInputs.isValidPassword(registrationDto.getPassword()) ||
                !registrationDto.getPassword().equals(registrationDto.getVerifypassword())) {
            System.out.println("Password validation failed");
            return false;
        }

        if (!dataAccessObject.createUser(registrationDto)) {
            System.out.println("User creation failed");
            return false;
        }

        // If all validations pass
        return true;
    }

}
