package com.groupa3.groupa3.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.groupa3.groupa3.dto.TaskDto;
import com.groupa3.groupa3.dto.UserRegistrationDto;
import com.groupa3.groupa3.dto.UserLoginDto;
import com.groupa3.groupa3.dto.UserDto;

@Component
@Scope("singleton")
public class DataAccessObject {
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public DataAccessObject(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    public boolean createUser(UserRegistrationDto userDto) {
        boolean userCreated = false;

        return userCreated;
    }

    public UserDto getUser(String username) {
        UserDto userDto = null;

        return userDto;
    }

    public UserDto getUser(int id) {
        UserDto userDto = null;

        return userDto;
    }

    public boolean authenticateUser(UserLoginDto userDto) {
        boolean authenticated = false;

        return authenticated;
    }

    public List<UserDto> getAllUsers() {
        List<UserDto> users = new ArrayList<>();

        return users;
    }

    public boolean createTask(TaskDto taskDto) {
        boolean taskCreated = false;

        return taskCreated;
    }
}
