package com.groupa3.groupa3.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTests {

    @Test
    public void testId() {
        User user = new User();
        user.setId(1L);
        assertEquals(1L, user.getId());
    }

    @Test
    public void testUsername() {
        User user = new User();
        user.setUsername("testUsername");
        assertEquals("testUsername", user.getUsername());
    }

    @Test
    public void testPassword() {
        User user = new User();
        user.setPassword("testPassword");
        assertEquals("testPassword", user.getPassword());
    }

    @Test
    public void testEmail() {
        User user = new User();
        user.setEmail("testEmail");
        assertEquals("testEmail", user.getEmail());
    }

    @Test
    public void testFirstName() {
        User user = new User();
        user.setFirstName("testFirstName");
        assertEquals("testFirstName", user.getFirstName());
    }

    @Test
    public void testLastName() {
        User user = new User();
        user.setLastName("testLastName");
        assertEquals("testLastName", user.getLastName());
    }

    @Test
    public void testPhoneNumber() {
        User user = new User();
        user.setPhoneNumber("testPhoneNumber");
        assertEquals("testPhoneNumber", user.getPhoneNumber());
    }

    @Test
    public void testToString() {
        User user = new User();
        user.setId(1L);
        user.setUsername("testUsername");
        user.setPassword("testPassword");
        user.setEmail("testEmail");
        user.setFirstName("testFirstName");
        user.setLastName("testLastName");
        user.setPhoneNumber("testPhoneNumber");

        String expected = "User{id=1, username='testUsername', password='testPassword', email='testEmail', firstName='testFirstName', lastName='testLastName', phoneNumber='testPhoneNumber'}";
        assertEquals(expected, user.toString());
    }
}