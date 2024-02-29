package com.groupa3.groupa3.dao;

import org.springframework.data.repository.CrudRepository;

import com.groupa3.groupa3.dto.UserDto;

public interface UserRepository extends CrudRepository<UserDto, Long> {
    UserDto findByUsername(String username);

    UserDto findById(int id);

    boolean existsByUsername(String username);
}