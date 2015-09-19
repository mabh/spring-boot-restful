/**
 * @author MABH
 * User controller handling User entity related requests. This receives HTTP requests and delegates them for 
 * further processing
 */
package app.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.domain.User;
import app.exception.ResourceNotFoundException;
import app.repository.UserRepository;

@RestController
public class UserController {

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public User get(@PathVariable String id) throws ResourceNotFoundException {
		//get a user
		return UserRepository.getInstance().get(id);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public void create(@RequestBody User user) {
		//add a new User
		UserRepository.getInstance().put(user.getId(), user);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable String id,
					@RequestBody User user) {
		//update an existing user
		UserRepository.getInstance().put(id, user);
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		//test service
		return UserRepository.getInstance().contents();
	}
	
}
