package com.egen.assessment.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Abstract base class to define the Spring Boot application context for unit
 * tests which require access to the Spring beans.
 *
 * @since 1.0.0
 * @author Gowrisankar
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserApplication.class)
@ActiveProfiles("test")
@WebAppConfiguration
public class UserApplicationTests {

	@Test
	public void contextLoads() {
	}

}
