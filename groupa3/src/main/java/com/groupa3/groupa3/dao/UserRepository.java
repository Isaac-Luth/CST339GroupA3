package com.groupa3.groupa3.dao;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.groupa3.groupa3.dao.UserRepository;
import com.groupa3.groupa3.dto.UserDto;

@Repository
public class UserRepository implements UserRepositoryInterface {

    @Override
    public UserDto findByUsername(String username) {
        // Implement logic to find user by username in the database
        // This is just a dummy implementation
        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        userDto.setEmail("user@example.com");
        // Add more properties as needed
        return userDto;
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        // Implement logic to find user by id in the database
        // This is just a dummy implementation
        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setUsername("exampleUser");
        userDto.setEmail("user@example.com");
        // Add more properties as needed
        return Optional.of(userDto);
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public void delete(UserDto entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    public void deleteAll(Iterable<? extends UserDto> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public boolean existsById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }

    @Override
    public Iterable<UserDto> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Iterable<UserDto> findAllById(Iterable<Long> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
    }

    @Override
    public <S extends UserDto> S save(S entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public <S extends UserDto> Iterable<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

    @Override
    public UserDto findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean existsByUsername(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsByUsername'");
    }

    // Implement other methods defined in UserRepository interface
    // such as save(), delete(), findAll(), etc.
}