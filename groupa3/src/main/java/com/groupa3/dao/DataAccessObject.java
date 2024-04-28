package com.groupa3.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.groupa3.dto.TaskDto;
import com.groupa3.dto.UserDto;


/**
 * Data access object for the application
 */
@Component
@Scope("singleton")
public class DataAccessObject {

    private final UserRepositoryInterface userRepository;
    private final TaskRepositoryInterface taskRepository;

    /**
     * Constructor for the data access object
     * @param userRepository The user repository
     * @param taskRepository The task repository
     */
    public DataAccessObject(UserRepositoryInterface userRepository, TaskRepositoryInterface taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    
    /** 
     * @param userDto The user to register
     * @return boolean Whether the user was registered
     */
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

    
    /** 
     * @param username The username of the user to get
     * @return UserDto The user with the given username
     */
    public UserDto getUser(String username) {
        UserDto userDto = null;

        try {
            userDto = userRepository.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userDto;
    }

    
    /** 
     * @param id The id of the user to get
     * @return UserDto The user with the given id
     */
    public UserDto getUser(int id) {
        UserDto userDto = null;

        try {
            userDto = userRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userDto;
    }

    
    /** 
     * @param email The email of the user to get
     * @return UserDto The user with the given email
     */
    public UserDto getUserByEmail(String email)
    {
        UserDto userDto = null;

        try {
            userDto = userRepository.findByEmail(email);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return userDto;
    }

    
    /** 
     * @param userDto The user to authenticate
     * @return boolean Whether the user was authenticated
     */
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

    
    /** 
     * @return List UserDto  A list of all users
     */
    public List<UserDto> getAllUsers() {
        List<UserDto> users = new ArrayList<>();

        try {
            userRepository.findAll().forEach(users::add);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    
    /** 
     * @param taskDto The task to create
     * @return boolean Whether the task was created
     */
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

    
    /** 
     * @return List TaskDto  A list of all tasks
     */
    public List<TaskDto> getTasks() {
        List<TaskDto> tasks = new ArrayList<>();

        try {
            taskRepository.findAll().forEach(tasks::add);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tasks;
    }

    
    /** 
     * @param id The id of the task to get
     * @return TaskDto The task with the given id
     */
    public TaskDto getTask(Long id) {
        TaskDto taskDto = null;

        try {
            taskDto = taskRepository.findById(id).get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (taskDto == null)
        {
            return null;
        }

        if (taskDto.getId() == 0)
        {
            return null;
        }

        return taskDto;
    }

    
    /** 
     * @param taskDto The task to update
     * @return boolean Whether the task was updated
     */
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

    
    /** 
     * @param id The id of the task to delete
     * @return boolean Whether the task was deleted
     */
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
