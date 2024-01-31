package com.groupa3.groupa3;

/**
 * This class provides a method to verify the strength and validity of passwords.
 * It ensures that passwords meet certain security criteria, such as minimum length,
 * and the inclusion of uppercase and lowercase letters, numbers, and special characters.
 */
public class PasswordVerifier 
{
    /**
     * Verifies if the given password meets the specified security criteria.
     * 
     * @param password The password string to be verified.
     * @return A string message indicating whether the password is valid or detailing the reason for invalidity.
     */
    public String verifyPassword(String password) 
    {
        // Check if the password is at least 8 characters long
        if (password.length() < 8) 
        {
            return "Password too short. Must be at least 8 characters.";
        }
        // Check if the password contains an uppercase letter
        if (!password.matches(".*[A-Z].*")) 
        {
            return "Password must contain an uppercase letter.";
        }
        // Check if the password contains a lowercase letter
        if (!password.matches(".*[a-z].*")) 
        {
            return "Password must contain a lowercase letter.";
        }
        // Check if the password contains a digit
        if (!password.matches(".*\\d.*")) 
        {
            return "Password must contain a digit.";
        }
        // Check if the password contains a special character
        if (!password.matches(".*[!@#$%^&*].*")) 
        {
            return "Password must contain a special character (!@#$%^&*).";
        }
        // If all checks pass, the password is valid
        return "Valid password";
    }
}
