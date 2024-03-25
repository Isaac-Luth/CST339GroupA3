package com.groupa3.groupa3.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.groupa3.groupa3.dto.TaskDto;
import com.groupa3.groupa3.dto.UserDto;

@Component
@Scope("singleton")
public class DataAccessObject {

    private final UserRepositoryInterface userRepository;
    private final TaskRepositoryInterface taskRepository;

    @Autowired
    public DataAccessObject(UserRepositoryInterface userRepository, TaskRepositoryInterface taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    public boolean createUser(UserDto userDto) {
        boolean userCreated = false;

        try {
            userRepository.save(userDto);
            userCreated = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userCreated;
    }

    public UserDto getUser(String username) {
        UserDto userDto = null;

        try {
            userDto = userRepository.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userDto;
    }

    public UserDto getUser(int id) {
        UserDto userDto = null;

        try {
            userDto = userRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userDto;
    }

    public boolean authenticateUser(UserDto userDto) {
        boolean authenticated = false;

        if (userDto == null || userDto.getEmail() == null || userDto.getPassword() == null) {
            return false;
        }

        try {
            UserDto user = userRepository.findByEmail(userDto.getEmail());
            if (user != null && user.getPassword().equals(userDto.getPassword())) {
                authenticated = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return authenticated;
    }

    public List<UserDto> getAllUsers() {
        List<UserDto> users = new ArrayList<>();

        try {
            userRepository.findAll().forEach(users::add);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    public boolean createTask(TaskDto taskDto) {
        boolean taskCreated = false;

        try {
            taskRepository.save(taskDto);
            taskCreated = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return taskCreated;
    }

    public List<TaskDto> getTasks() {
        List<TaskDto> tasks = new ArrayList<>();

        try {
            taskRepository.findAll().forEach(tasks::add);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tasks;
    }

    public TaskDto getTask(Long id) {
        TaskDto taskDto = null;

        try {
            taskDto = taskRepository.findById(id).get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return taskDto;
    }

    public boolean updateTask(TaskDto taskDto) {
        boolean taskUpdated = false;

        try {
            taskRepository.updateTask(taskDto);
            taskUpdated = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return taskUpdated;
    }

    public boolean deleteTask(Long id) {
        boolean taskDeleted = false;

        try {
            taskRepository.deleteById(id);
            taskDeleted = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return taskDeleted;
    }
}
