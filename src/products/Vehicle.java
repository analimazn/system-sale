package products;

import enums.EnumVehicle;
import utils.Address;

public class Vehicle {
	
	private int idSale;
	private int id;	
	private EnumVehicle vehicletype;
	private Address address;
	private double price;
	private String description;

	public Vehicle(int idSale,int id, EnumVehicle vehicletype, Address address, double price, String description) {
		this.idSale = idSale;
		this.id = id;
		this.vehicletype = vehicletype;
		this.address = address;
		this.price = price;
		this.description = description;
	}

	public int getIdSale() {
		return idSale;
	}

	public void setIdSale(int idSale) {
		this.idSale = idSale;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EnumVehicle getVehicletype() {
		return vehicletype;
	}

	public void setVehicletype(EnumVehicle vehicletype) {
		this.vehicletype = vehicletype;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVehicle() {
		StringBuilder sb = new StringBuilder();
		sb.append("IDSale: "+this.idSale).append("\n");
		sb.append("ID: "+this.id).append("\n");
		sb.append("Vehicletype: "+this.vehicletype).append("\n");
		sb.append("Address: "+this.address.getAddress()).append("\n");
		sb.append("Price: "+this.price).append("\n");
		sb.append("Description: "+this.description).append("\n");
		return sb.toString();
	}
}
