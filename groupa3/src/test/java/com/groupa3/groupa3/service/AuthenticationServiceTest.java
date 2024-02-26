package com.groupa3.groupa3.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AuthenticationServiceTest {
    @Test
    void testAuthenticate_ValidCredentials() {
        // Arrange
        LoginService authenticationService = new LoginService();

        // Act
        boolean isAuthenticated = authenticationService.authenticate("admin@admin.com", "admin");

        // Assert
        assertTrue(isAuthenticated, "Authentication should succeed with valid credentials");
    }

    @Test
    void testAuthenticate_InvalidCredentials() {
        // Arrange
        LoginService authenticationService = new LoginService();

        // Act
        boolean isAuthenticated = authenticationService.authenticate("user", "wrongpass");

        // Assert
        assertFalse(isAuthenticated, "Authentication should fail with invalid credentials");
    }
}