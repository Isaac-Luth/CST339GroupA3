package com.groupa3.groupa3.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public boolean authenticate(String email, String password) {
        if (email.equals("admin@admin.com") && password.equals("admin")) {
            return true;
        }

        return false;
    }
}