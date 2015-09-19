package repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import app.domain.User;
import app.exception.ResourceNotFoundException;

/**
 * @author MABH
 * This is an singleton inmemory store (Map) of user id vs user information (for simplicity user's name (String)
 * This serves as a backend for a User service
 */
public final class UserRepository {
	private final Map<String, User> container = new ConcurrentHashMap<>();
	private final static UserRepository instance = new UserRepository();
	private UserRepository() {}
	
	public static UserRepository getInstance() {
		return instance;
	}
	
	public User get(final String id) throws ResourceNotFoundException {
		if(!container.containsKey(id)) {
			throw new ResourceNotFoundException("Supplied id " + id + " is not present in the store.");
		}
		return container.get(id);
	}
	
	public String contents() {
		return container.toString();
	}
	
	public void put(final String id, final User user) {
		try {
			container.put(id, user);
		} catch(Throwable t) {
			throw t;
		}
	}
}
