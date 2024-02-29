package com.groupa3.groupa3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import com.groupa3.groupa3.dao.TaskRepositoryInterface;
import com.groupa3.groupa3.dao.UserRepositoryInterface;
import com.groupa3.groupa3.dao.TaskRepository;
import com.groupa3.groupa3.dao.UserRepository;

@Configuration
public class AppConfig {

    @Bean
    public UserRepositoryInterface userDataRepository() {
        // You need to provide the implementation for UserRepository.
        // This could be an implementation class or you can instantiate it here.
        return new UserRepository(); // Example: replace UserRepositoryImpl with your implementation
    }

    @Bean
    public TaskRepositoryInterface taskDataRepository() {
        // Similarly, provide the implementation for TaskRepository.
        // Replace TaskRepositoryImpl with your implementation.
        return new TaskRepository(); // Example: replace TaskRepositoryImpl with your implementation
    }

}