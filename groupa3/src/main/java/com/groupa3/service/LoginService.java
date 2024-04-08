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

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    DataAccessObject service;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDto user = service.getUserByEmail(email);

        if (user == null) { throw new UsernameNotFoundException("Email Not Found"); }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        return new User(user.getEmail(), user.getPassword(), authorities);
    }

}