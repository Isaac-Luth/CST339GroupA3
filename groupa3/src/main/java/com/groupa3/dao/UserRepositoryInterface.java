package com.groupa3.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.groupa3.dto.UserDto;

/**
 * Interface for the user repository
 */
@Repository
public interface UserRepositoryInterface extends CrudRepository<UserDto, Long> {
    /**
     * Find a user by username
     * @param username The username of the user to find
     * @return UserDto The user with the given username
     */
    UserDto findByUsername(String username);

    /**
     * Find a user by email
     * @param email The email of the user to find
     * @return UserDto The user with the given email
     */
    UserDto findByEmail(String email);

    /**
     * Find a user by id
     * @param id The id of the user to find
     * @return UserDto The user with the given id
     */
    UserDto findById(int id);

    /**
     * Check if a user exists by username
     * @param username The username to check
     * @return boolean True if the user exists, false otherwise
     */
    boolean existsByUsername(String username);
}