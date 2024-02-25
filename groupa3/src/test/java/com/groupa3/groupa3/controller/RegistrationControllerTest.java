package com.groupa3.groupa3.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.groupa3.groupa3.service.RegistrationService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RegistrationController.class)
public class RegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RegistrationService registrationService;

    @Test
    public void testRegisterUserAccount() throws Exception {
        // Assuming the registrationService.register() method is mocked to return true for valid data
        this.mockMvc.perform(post("/registration/register")
                .param("email", "test@example.com")
                .param("verifyemail", "test@example.com")
                .param("password", "ValidPass123!")
                .param("verifypassword", "ValidPass123!"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/registration?success"));
    }
}

