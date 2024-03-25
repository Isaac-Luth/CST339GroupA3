package com.groupa3.groupa3;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.groupa3.groupa3.dao.TaskRepositoryInterface;
import com.groupa3.groupa3.dao.UserRepositoryInterface;
import com.groupa3.groupa3.dao.TaskRepository;
import com.groupa3.groupa3.dao.UserRepository;

@Configuration
public class AppConfig {

    /*
    @Bean
    public UserRepositoryInterface userDataRepository(@Autowired DataSource dataSource) {
        return new UserRepository(dataSource);
    }

    
    @Bean
    public TaskRepositoryInterface taskDataRepository(@Autowired DataSource dataSource) {
        return new TaskRepository(dataSource);
    }*/

}