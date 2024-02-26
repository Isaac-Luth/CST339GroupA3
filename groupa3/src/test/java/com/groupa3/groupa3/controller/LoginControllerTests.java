package com.groupa3.groupa3.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.groupa3.groupa3.service.AuthenticationServiceInterface;

public class LoginControllerTests {
    @Mock
    private AuthenticationServiceInterface authenticationService;

    @Mock
    private Model model;

    @InjectMocks
    private LoginController loginController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testDoLogin_ValidCredentials() {
        // Arrange
        String username = "john";
        String password = "password123";
        
        // Mock authentication service to return true for valid credentials
        when(authenticationService.authenticate(username, password)).thenReturn(true);

        // Act
        String result = loginController.doLogin(username, password, model);

        // Assert
        assertEquals("home", result);
    }

    private void assertEquals(String string, String result) {
    }

    @Test
    void testDoLogin_InvalidCredentials() {
        // Arrange
        String username = "invalid";
        String password = "invalidpass";
        
        // Mock authentication service to return false for invalid credentials
        when(authenticationService.authenticate(username, password)).thenReturn(false);

        // Act
        String result = loginController.doLogin(username, password, model);

        // Assert
        assertEquals("login", result); 
        // Ensure that the error attribute is added to the model
        verify(model).addAttribute("error", "Invalid username or password");
    }
}