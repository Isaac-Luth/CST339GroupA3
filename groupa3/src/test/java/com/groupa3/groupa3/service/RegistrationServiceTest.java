package com.groupa3.groupa3.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.groupa3.groupa3.dto.UserDto;
import com.groupa3.groupa3.util.VerifyInputs;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RegistrationServiceTest {

    @Autowired
    private RegistrationService registrationService;

    @MockBean
    private VerifyInputs verifyInputs;

    @Test
    public void testRegisterWithInvalidData() {
        UserDto registrationDto = new UserDto();
        // Populate registrationDto with invalid data

        when(verifyInputs.isValidEmail(anyString())).thenReturn(false);
        when(verifyInputs.isValidPassword(anyString())).thenReturn(false);

        assertFalse(registrationService.register(registrationDto));
    }
}
