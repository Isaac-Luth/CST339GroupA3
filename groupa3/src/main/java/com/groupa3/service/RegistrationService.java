package com.groupa3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.groupa3.dao.DataAccessObject;
import com.groupa3.dto.UserDto;
import com.groupa3.util.VerifyInputs;

/**
 * Service for registering a user
 */
@Service
public class RegistrationService {

    @Autowired
    private VerifyInputs verifyInputs;

    @Autowired
    private DataAccessObject dataAccessObject;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    
    /** 
     *  Register a user
     * @param registrationDto The user registration dto
     * @return boolean Whether the user was registered
     */
    public boolean register(UserDto registrationDto) {
        if (!verifyInputs.isValidEmail(registrationDto.getEmail()) ||
                !registrationDto.getEmail().equals(registrationDto.getVerifyemail())) {
            return false;
        }

        if (!verifyInputs.isValidPassword(registrationDto.getPassword()) ||
                !registrationDto.getPassword().equals(registrationDto.getVerifypassword())) {
            return false;
        }

        registrationDto.setPassword(passwordEncoder.encode(registrationDto.getPassword()));

        if (!dataAccessObject.createUser(registrationDto)) {
            return false;
        }

        // If all validations pass
        return true;
    }

}
