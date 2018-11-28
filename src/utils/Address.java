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
	
	public String getAddress() {
		StringBuilder sb = new StringBuilder();
		sb.append("Street : "+this.street).append("\n");
		sb.append("Number: "+this.number).append("\n");
		sb.append("City: "+this.city).append("\n");
		sb.append("State: "+this.state).append("\n");
		sb.append("ZIP Code: "+this.zipCode);		
		return sb.toString();
	}
}
