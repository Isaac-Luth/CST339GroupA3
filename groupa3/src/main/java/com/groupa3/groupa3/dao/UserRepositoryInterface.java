package com.groupa3.groupa3.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.groupa3.groupa3.dto.UserDto;

@Repository
public interface UserRepositoryInterface extends CrudRepository<UserDto, Long> {
    UserDto findByUsername(String username);

    UserDto findById(int id);

    boolean existsByUsername(String username);
}