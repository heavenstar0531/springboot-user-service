package com.egen.assessment.user.domain;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.egen.assessment.user.UserApplicationTests;

/**
 * Unit tests for {@link UserRepository}.
 * 
 * @since 1.0.0
 * @author Gowrisankar
 */
public class UserRepositoryTest extends UserApplicationTests {
	
	/** Instance to unit test. */
	@Autowired
	private UserRepository _repository;


	@Test
	public void testGetUser() {
		// Attempt to retrieve single user by ID
		final User user = _repository.findByUserId(UUID.fromString("83a4143c-d298-46de-bd62-f1496cb05a74"));
		
		Assert.assertNotNull(user);
		Assert.assertEquals("83a4143c-d298-46de-bd62-f1496cb05a74", user.getUserId());
	}
	
	@Test
	public void testFindByFirstNameAndLastNameAndPhone() {
		final User user = _repository.findByFirstNameAndLastNameAndPhone("Gowrisankar","Ponnusamy","4109726767");
		
		Assert.assertNotNull(user);
		Assert.assertEquals("Gowrisankar", user.getFirstName());
		Assert.assertEquals("Ponnusamy", user.getLastName());
		Assert.assertEquals("4109726767", user.getPhone());
	}
	
}
