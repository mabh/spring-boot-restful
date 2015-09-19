/**
 * @author MABH
 * Simple user POJO for in-memory storage
 */
package app.domain;

public final class User {
	private String id;
	private String name;
	
	public User() {}
	
	public User(final String id, final String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
