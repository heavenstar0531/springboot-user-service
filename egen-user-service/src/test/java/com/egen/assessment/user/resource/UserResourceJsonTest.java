package com.egen.assessment.user.resource;

import java.io.IOException;
import java.util.UUID;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.egen.assessment.user.UserApplicationTests;
import com.egen.assessment.user.UserApplicationConfiguration;
import com.egen.assessment.user.domain.User.Gender;

/**
 * Unit tests for serializing/deserializing {@link UserResource} to/from JSON.
 *
 * @since 1.0.0
 * @author Gowrisankar 
 */
@JsonTest
public class UserResourceJsonTest extends UserApplicationTests{

	/** Path to JSON resource for testing/validating. */
	private final String _userJsonResource = "/json/userResource.json";
	/** Spring Boot Test utility for testing JSON. */
	@Autowired
	private JacksonTester<UserResource> _json;

	@Test
	public void testSerialize()
		throws IOException {		
		// Create UserResource
		final UserResource resource =
			new UserResource();	
		resource.setUserId(UUID.fromString("770361d2-f7a8-4969-923d-839547757884"));
		resource.setFirstName("FirstName");
		resource.setMiddleName("MiddleName");
		resource.setLastName("LastName");
		resource.setAge("30");
		resource.setGender(Gender.M);
		resource.setPhone("4109726767");
		resource.setZip("08536");		
		// Serialize resource and verify matches existing JSON
		Assertions.assertThat(_json.write(resource))
				.isEqualToJson(_userJsonResource);
	}

	@Test
	public void testDeserialize()
		throws IOException {
		// Parse JSON into deserialized object
		final UserResource parsed =
			_json.read(_userJsonResource).getObject();
		// Validate fields match expected for UserResource properties		
		Assertions.assertThat(parsed.getUserId()).isEqualTo(UUID.fromString("770361d2-f7a8-4969-923d-839547757884"));
		Assertions.assertThat(parsed.getFirstName()).isEqualTo("FirstName");
		Assertions.assertThat(parsed.getMiddleName()).isEqualTo("MiddleName");
		Assertions.assertThat(parsed.getLastName()).isEqualTo("LastName");
		Assertions.assertThat(parsed.getAge()).isEqualTo("30");
		Assertions.assertThat(parsed.getGender()).isEqualTo(Gender.M);
		Assertions.assertThat(parsed.getPhone()).isEqualTo("4109726767");
		Assertions.assertThat(parsed.getZip()).isEqualTo("08536");
	}
}
