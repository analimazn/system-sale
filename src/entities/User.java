package entities;

import enums.EnumUser;

public class User extends Cadaster{
	private EnumUser usertype;
	private String id;
	private String name;
	private String cnpjCpf;
	
	public User(String username, String password, EnumUser usertype, String id, String name, String cnpjCpf) {
		super(username, password);
		this.usertype = usertype;
		this.id = id;
		this.name = name;
		this.cnpjCpf = cnpjCpf;
	}

	public String getCnpjCpf() {
		return cnpjCpf;
	}

	public void setCnpjCpf(String cnpjCpf) {
		this.cnpjCpf = cnpjCpf;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EnumUser getUserType() {
		return usertype;
	}

	public void setUserType(EnumUser usertype) {
		this.usertype = usertype;
	}
	
	public String getUser() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name: "+this.name).append("\n");
		sb.append("CNPJ/CPF: "+this.cnpjCpf).append("\n");
		sb.append("Usertype: "+this.usertype).append("\n");
		sb.append("Username: "+super.getUsername()).append("\n");
		return sb.toString();
	}
}
