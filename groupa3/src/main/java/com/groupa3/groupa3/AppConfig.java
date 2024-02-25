package com.groupa3.groupa3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.groupa3.groupa3.service.AuthenticationService;
import com.groupa3.groupa3.service.AuthenticationServiceInterface;

@Configuration
public class AppConfig {
    @Bean
    public AuthenticationServiceInterface authenticationServiceInterface() {
        return new AuthenticationService();
    }
}