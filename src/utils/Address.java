package utils;

public class Address {
	
	private String street;
	private int number;
	private String city;
	private String state;
	private String zipCode;

	public Address (String street, int number, String city, String state, String zipCode) {
		 this.street = street ; 
		 this.number = number ; 
		 this.city = city ; 
		 this.state = state ; 
		 this.zipCode = zipCode ; 
	}
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getAddress() {
		StringBuilder sb = new StringBuilder();
		sb.append("Street: "+this.street).append("\n");
		sb.append("Number: "+this.number).append("\n");
		sb.append("City: "+this.city).append("\n");
		sb.append("State: "+this.state).append("\n");
		sb.append("Zip Code: "+this.zipCode);
		return sb.toString();
	}
}
