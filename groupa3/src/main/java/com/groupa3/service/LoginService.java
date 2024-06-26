package com.groupa3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.groupa3.dao.DataAccessObject;
import com.groupa3.dto.UserDto;

/**
 * Service for logging in a user
 */
@Service
public class LoginService implements UserDetailsService {

    @Autowired
    DataAccessObject service;

    
    /** 
     *  Get the user with the given email
     * @param email The email of the user to get
     * @return UserDetails The user with the given email
     * @throws UsernameNotFoundException If the user is not found
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDto user = service.getUserByEmail(email);

        if (user.getEmail() == null || user.getPassword() == null) { throw new UsernameNotFoundException(email); }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("USER"));

        return new User(user.getEmail(), user.getPassword(), authorities);
    }

}