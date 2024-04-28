package com.groupa3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.groupa3.service.LoginService;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * The security configuration
 */
@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private LoginService service;
        private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        
        /** 
         *  Configure the http security
         * @param http The http security
         * @throws Exception If the http security fails
         */
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf(csrf -> csrf.disable())
                    .httpBasic(withDefaults())
                    .authorizeRequests(requests -> requests
                            .antMatchers("/service/**").authenticated())
                    .authorizeRequests(requests -> requests
                            .antMatchers("/", "/assets/**", "/signup", "/registration/**").permitAll()
                            .anyRequest().authenticated())
                    .formLogin(login -> login
                            .loginPage("/login")
                            .usernameParameter("email")
                            .passwordParameter("password")
                            .permitAll()
                            .defaultSuccessUrl("/menu", true))
                    .logout(logout -> logout
                            .logoutUrl("/logout")
                            .invalidateHttpSession(true)
                            .clearAuthentication(true)
                            .permitAll()
                            .logoutSuccessUrl("/"));
        }

        
        /** 
         *  Configure the authentication manager builder
         * @param auth The authentication manager builder
         * @throws Exception If the authentication manager builder fails
         */
        @Autowired
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
                auth
                .userDetailsService(service)
                .passwordEncoder(passwordEncoder);
        }
}
