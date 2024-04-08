package com.groupa3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.groupa3.service.LoginService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private LoginService service;
        private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                .authorizeRequests()
                    .antMatchers("/", "/assets/**", "/service/**", "/signup", "/registration/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .permitAll()
                    .defaultSuccessUrl("/menu", true)
                    .and()
                .logout()
                    .logoutUrl("/logout")
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .permitAll()
                    .logoutSuccessUrl("/");
        }

        @Autowired
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
                auth
                .userDetailsService(service)
                .passwordEncoder(passwordEncoder);
        }
}
