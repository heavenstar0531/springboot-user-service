package com.egen.assessment.user.service;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.egen.assessment.user.domain.User;
import com.egen.assessment.user.domain.UserRepository;
import com.egen.assessment.user.resource.UserResource;

/**
 *
 *
 * @since 1.0.0
 * @author Gowrisankar
 */
public class UserServiceTest {

	// Instance to unit test.
	private final UserService _service = new UserService();
	// Mock user repository for testing.
	private UserRepository _mockRepository;

	@Before
	public void setUp() {
		_mockRepository = mock(UserRepository.class);
		ReflectionTestUtils.setField(_service, "userRepository", _mockRepository);
	}

	/**
	 * Test getAllUsers() end-point.
	 *
	 * Expected Result : It fetched list of users.
	 */
	@Test
	public void testGetAllUsers() {
		final List<User> mockList = mock(List.class);
		when(_mockRepository.findAll()).thenReturn(mockList);
		final List<User> retrieved = _service.getAllUsers();
		Assert.assertTrue(retrieved == mockList);
		verify(_mockRepository).findAll();
	}

	/**
	 * Test create() end-point.
	 *
	 * Expected Result : user should be created.
	 */
	@Test
	public void testCreate() {
		final User mockUser = mock(User.class);
		when(_mockRepository.findByFirstNameAndLastNameAndPhone(anyString(), anyString(), anyString()))
				.thenReturn(null);
		when(_mockRepository.saveAndFlush(mockUser)).thenReturn(mockUser);
		UUID userId = UUID.randomUUID();
		final UserResource resource = new UserResource();
		resource.setUserId(userId);
		resource.setFirstName("fname");
		resource.setMiddleName("mname");
		resource.setLastName("lname");
		resource.setAge("30");
		resource.setGender(User.Gender.M);
		resource.setPhone("4109726767");
		resource.setZip("08536");
		final User user = _service.create(resource);
		Assert.assertNotNull(mockUser == user);
		verify(_mockRepository, times(1)).findByFirstNameAndLastNameAndPhone(anyString(), anyString(), anyString());
		verify(_mockRepository, times(1)).saveAndFlush(any(User.class));
	}

	/**
	 * Test create() end-point.
	 *
	 * Expected Result : The end-point should throw {@link NullPointerException}
	 * if UserResource is null.
	 */
	@Test(expected = NullPointerException.class)
	public void testCreateNullUser() {
		_service.create(null);
	}

	/**
	 * Test update() end-point.
	 *
	 * Expected Result : user should be update.
	 */
	@Test
	public void testUpdate() {
		final User mockUser = mock(User.class);
		UUID userId = UUID.randomUUID();
		final UserResource resource = new UserResource();
		resource.setUserId(userId);
		resource.setFirstName("fname");
		resource.setMiddleName("mname");
		resource.setLastName("lname");
		resource.setAge("30");
		resource.setGender(User.Gender.M);
		resource.setPhone("4109726767");
		resource.setZip("08536");
		when(_mockRepository.findByUserId(userId)).thenReturn(mockUser);
		when(_mockRepository.save(mockUser)).thenReturn(mockUser);
		_service.updateUser(userId, resource);
		verify(_mockRepository).save(any(User.class));
	}
}
