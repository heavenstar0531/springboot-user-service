package com.egen.assessment.user.service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egen.assessment.user.domain.User;
import com.egen.assessment.user.domain.UserRepository;
import com.egen.assessment.user.resource.UserResource;
import com.egen.assessment.user.resource.UserResourceJsonTest;

/**
 * Service for managing instances of {@link User}.
 *
 * @since 1.0.0
 * @author Gowrisankar
 */
@Service
public class UserService {

	/** {@code Logger} instance. */
	private final Logger _logger =
		LoggerFactory.getLogger(UserService.class);
	
	/** Repository for managing User entities. */
	@Autowired
	private UserRepository userRepository;

	/**
	 * Creates a new {@link User} from the specified {@code user} details.
	 * 
	 * @param {@link UserResourceJsonTest} to create
	 * @return newly created {@link User} entity
	 */
	@Transactional
	public User create(final UserResource user) {
		_logger.info("Create user service.....");				
		//check if user already exists by using first name, last name and phone number
		User existingUser = userRepository.findByFirstNameAndLastNameAndPhone(user.getFirstName(), user.getLastName(), user.getPhone());
		//if User does not exist create new User
		if (existingUser == null) {
			// Persist new User instance and return
			final User created = userRepository.saveAndFlush(prepareNewUserEntity(user));
			_logger.info("Created new User: {}", created);
			return created;
		}
		return existingUser;
	
	}
	
	/**
	 * Get list of {@link User}s.
	 * 
	 * @return list of {@link User}s
	 */
	@Transactional( readOnly = true )
	public List<User> getAllUsers() {
		_logger.info("Get all users service.....");		
		final List<User> users = userRepository.findAll();
		return users;
		
	
	}
	
	/**
	 * Update an {@link User}.
	 * 
	 * @param id
	 * @param {@link User}
	 * @return updated {@link User} entity
	 */
	@Transactional
	public ResponseEntity<User> updateUser(UUID id, UserResource user) {
		_logger.info("Update user service.....");		
		User currentUser = userRepository.findByUserId(id);
		if (currentUser==null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }		
		currentUser.setFirstName(user.getFirstName());
        currentUser.setMiddleName(user.getMiddleName());
        currentUser.setLastName(user.getLastName());
        currentUser.setAge(user.getAge());
        currentUser.setGender(user.getGender());
        currentUser.setPhone(user.getPhone());
        currentUser.setZip(user.getZip());
         
        userRepository.save(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	
	}

	/**
	 * Creates and returns a new {@link User} from the {@link UserResourceJsonTest} {@code User}
	 * 
	 * @param user
	 * @return a complete {@link User} entity ready to be saved
	 */
	private User prepareNewUserEntity(UserResource user) {
		User userEntity = new User();
		userEntity.setFirstName(user.getFirstName());
		userEntity.setLastName(user.getLastName());			
		userEntity.setMiddleName(user.getMiddleName());
		userEntity.setGender(user.getGender());
		userEntity.setAge(user.getAge());
		userEntity.setPhone(user.getPhone());
		userEntity.setZip(user.getZip());
		return userEntity;
	}

}
