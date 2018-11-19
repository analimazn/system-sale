package entities;

import enums.EnumUser;

public class Client extends User{
	public EnumUser user;
	public String identifier;
	public String name;
	
	public Client(EnumUser user, String username, String password, String identifier, String name) {
		super(username, password);
		this.identifier = identifier;
		this.name = name;
		this.user = user;
	}

	public String getCnpjCpf() {
		return identifier;
	}

	public void setCnpjCpf(String cnpjCpf) {
		this.identifier = cnpjCpf;
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
