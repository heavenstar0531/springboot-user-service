package com.egen.assessment.user.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.egen.assessment.user.domain.User;
import com.egen.assessment.user.resource.UserResource;
import com.egen.assessment.user.resource.UserResourceJsonTest;
import com.egen.assessment.user.service.UserService;

/**
 * Controller for managing instances of {@link UserResource}.
 *
 * @since 1.0.0
 * @author Gowrisankar
 */
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * Creates a new user
	 * 
	 * Http Method: POST 
	 * Url: http://localhost:8081/usermanagement/users/
	 * Sample Payload: { "firstName":"Gowri", "middleName":"Sankar", "lastName":"Ponnusamy", "age":"22", "gender":"M", "phone":"4444455555", "zip":"98536"}
	 */	
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
    public UserResource createUser(final @RequestBody @Validated UserResource user) 
    {
		final User created = userService.create(user);
		UserResource userResource = new UserResource();
		userResource.setUserId(created.getUserId());
		userResource.setFirstName(created.getFirstName());
		userResource.setLastName(created.getLastName());
		userResource.setMiddleName(created.getMiddleName());		
		userResource.setAge(created.getAge());
		userResource.setGender(created.getGender());
		userResource.setPhone(created.getPhone());
		userResource.setZip(created.getZip());
		return userResource;
    }
	
	/**
	 * Gets all users
	 * 
	 * Http Method: GET 
	 * Url: http://localhost:8081/usermanagement/users/
	 */	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getAllUsers() 
    {
		return userService.getAllUsers();
    }
	
	/**
	 * Updates user if exists
	 * 
	 * Http Method: PUT 
	 * Url: http://localhost:8081/usermanagement/users/{userId}
	 * Sample Payload: { "firstName":"Gowri", "middleName":"Sankar", "lastName":"Ponnusamy", "age":"22", "gender":"M", "phone":"4444455555", "zip":"98536"}
	 */	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") UUID id, @RequestBody @Validated UserResource user) {         
		return userService.updateUser(id, user);   
    }
 
}
