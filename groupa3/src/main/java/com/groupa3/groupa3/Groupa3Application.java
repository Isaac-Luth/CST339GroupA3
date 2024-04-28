package com.groupa3.groupa3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

/**
 * The main class for the application
 */
@SpringBootApplication
@EnableJdbcRepositories("com.groupa3.dao")
@ComponentScan({ "com.groupa3" })
public class Groupa3Application {

	
	/** 
	 *  The main method to run the application
	 * @param args The arguments to pass to the application
	 */
	public static void main(String[] args) {
		SpringApplication.run(Groupa3Application.class, args);
	}

}
