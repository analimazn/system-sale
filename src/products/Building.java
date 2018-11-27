package products;

import enums.EnumBuilding;
import utils.Address;

public class Building {

	private int idSale;
	private int id;	
	private double area;
	private EnumBuilding buildingtype;
	private Address address;
	private double price;
	private String description;
	
	public Building (int idSale,int id, double area, EnumBuilding buildingtype, Address address, double price, String description ) {
		this.idSale = idSale;
		this.id = id;
		this.area = area;
		this.buildingtype = buildingtype;
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

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public EnumBuilding getBuildingtype() {
		return buildingtype;
	}

	public void setBuildingtype(EnumBuilding buildingtype) {
		this.buildingtype = buildingtype;
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

	public String getBuilding() {
		StringBuilder sb = new StringBuilder();
		sb.append("IDSale: "+this.idSale).append("\n");
		sb.append("ID: "+this.id).append("\n");
		sb.append("Area: " + this.area).append("\n");
		sb.append("Buildingtype: "+this.buildingtype).append("\n");
		sb.append("Address: "+this.address).append("\n");
		sb.append("Price: "+this.price).append("\n");
		sb.append("Description"+this.description).append("\n");
		return sb.toString();
	}
	
	
}