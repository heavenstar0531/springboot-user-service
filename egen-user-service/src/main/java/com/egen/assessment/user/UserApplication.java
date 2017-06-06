package com.egen.assessment.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for creating the User Service.
 *
 * @since 1.0.0
 * @author Gowrisankar
 */
@EnableAutoConfiguration
@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
}
