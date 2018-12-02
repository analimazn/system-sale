package products;

import enums.EnumProduct;

public class Product {
	protected String idSale;
	protected String id;	
	protected EnumProduct type;
	protected double price;
	protected String description;
	protected String address;

	public Product(String idSale, String id, EnumProduct type, double price, String description) {
		this.idSale = idSale;
		this.id = id;
		this.type = type;
		this.price = price;
		this.description = description;
	}

	public String getIdSale() {
		return idSale;
	}

	public void setIdSale(String idSale) {
		this.idSale = idSale;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public EnumProduct getType() {
		return type;
	}

	public void setType(EnumProduct type) {
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
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getProduct() {
		try {
			if(getAddress() == null) {
				StringBuilder sb = new StringBuilder();
				sb.append("IdSale: " + this.idSale).append("\n");
				sb.append("ID: " + this.id).append("\n");
				sb.append("ProductType: " + this.type).append("\n");
				sb.append("Price: " + this.price).append("\n");
				sb.append("Description: " + this.description).append("\n");
				return sb.toString();
			}
			StringBuilder sb = new StringBuilder();
			sb.append("IdSale: " + this.idSale).append("\n");
			sb.append("ID: " + this.id).append("\n");
			sb.append("ProductType: " + this.type).append("\n");
			sb.append("Price: " + this.price).append("\n");
			sb.append("Description: " + this.description).append("\n");
			sb.append("Address: " + this.address).append("\n");
			return sb.toString();
			
		} catch(java.lang.NullPointerException e) {
			return "";
		}
	}
}
