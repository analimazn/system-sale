package products;

import enums.EnumProduct;
import systemSale.SystemSale;
import utils.Address;

public class Product {
	private SystemSale idSale;
	private String id;	
	private EnumProduct type;
	private double price;
	private String description;

	public Product(SystemSale idSale, String id, EnumProduct type, Address address, double price, String description) {
		this.idSale = idSale;
		this.id = id;
		this.type = type;
		this.price = price;
		this.description = description;
	}

	public SystemSale getIdSale() {
		return idSale;
	}

	public void setIdSale(SystemSale idSale) {
		this.idSale = idSale;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EnumProduct getVehicletype() {
		return type;
	}

	public void setVehicletype(EnumProduct type) {
		this.type = type;
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

	public String getProduct() {
		StringBuilder sb = new StringBuilder();
		sb.append("IDSale: "+this.idSale).append("\n");
		sb.append("ID: "+this.id).append("\n");
		sb.append("ProductType: "+this.type).append("\n");
		sb.append("Price"+this.price).append("\n");
		sb.append("Description"+this.description).append("\n");
		return sb.toString();
	}
}
