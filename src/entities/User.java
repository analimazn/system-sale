package entities;

import enums.EnumUser;

public class User extends Cadaster{
	public EnumUser user;
	public String identifier;
	public String name;
	
	public User(EnumUser user, String username, String password, String identifier, String name) {
		super(username, password);
		this.identifier = identifier;
		this.name = name;
		this.user = user;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EnumUser getUser() {
		return user;
	}

	public void setUser(EnumUser user) {
		this.user = user;
	}
}
