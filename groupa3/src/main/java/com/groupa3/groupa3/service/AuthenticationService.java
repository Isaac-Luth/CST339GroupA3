package com.groupa3.groupa3.service;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationService implements AuthenticationServiceInterface{

    @Override
    public boolean authenticate(String username, String password) 
    {
        //Hardcoded authenication 
        return "admin".equals(username) && "password".equals(password);

    }
    
}
