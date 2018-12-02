package products;

import enums.EnumBuilding;
import enums.EnumProduct;
import systemSale.Sale;
import utils.Address;

public class Building extends Product {
	protected String address;
	protected double area;
	protected EnumBuilding modality;
	
	public Building(String idSale, String id, EnumProduct type, EnumBuilding modality,
			double price, String description, String address, double area) {
		super(idSale, id, type, price, description);
		this.modality = modality;
		this.address = address;
		this.area = area;
	}
	
	public EnumBuilding getModality() {
		return modality;
	}

	public void setModality(EnumBuilding modality) {
		this.modality = modality;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBuilding() {
		StringBuilder sb = new StringBuilder();
		sb.append("IdSale: " + super.idSale).append("\n");
		sb.append("ID: " + super.id).append("\n");
		sb.append("ProductType: " + super.type).append("\n");
		sb.append("Modality: " + this.modality).append("\n");
		sb.append("Price" + super.price).append("\n");
		sb.append("Area" + this.area).append("\n");
		sb.append("Address" + this.address).append("\n");
		sb.append("Description" + super.description).append("\n");
		return sb.toString();
	}
}
