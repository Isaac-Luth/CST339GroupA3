package com.groupa3.groupa3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories(basePackages = "com.groupa3.groupa3.dao")
public class Groupa3Application {

	public static void main(String[] args) {
		SpringApplication.run(Groupa3Application.class, args);
	}

}
