package com.egen.assessment.user.domain;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing {@link User} entities using Spring Data.
 *
 * @since 1.0.0
 * @author Gowrisankar
 */
public interface UserRepository extends JpaRepository<User, UUID>{	
	User findByFirstNameAndLastNameAndPhone(String firstname, String lastname, String phone);	
	User findByUserId(UUID id);	
}  
