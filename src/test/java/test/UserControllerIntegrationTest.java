/**
 * Integration Test for the REST service
 */
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import app.Application;
import app.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class UserControllerIntegrationTest {

	private final RestTemplate restTemplate = new RestTemplate();
	
	@Test
	public void postTest() {
		User john = new User("12321", "John");
		restTemplate.postForObject("http://localhost:8888/user", john, User.class);
		User apiResponse = restTemplate.getForObject("http://localhost:8888/user/12321", User.class);
		assertEquals(apiResponse.getName(), "John");
	}
	
	@Test
	public void putTest() {
		User john = new User("12321", "John");
		restTemplate.postForObject("http://localhost:8888/user", john, User.class);
		User johnty = new User(john.getId(), "Johnty");
		restTemplate.put("http://localhost:8888/user/" + john.getId(), johnty);
		User apiResponse = restTemplate.getForObject("http://localhost:8888/user/" + john.getId(), User.class);
		assertEquals(apiResponse.getName(), "Johnty");
	}
}
