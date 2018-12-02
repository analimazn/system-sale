package products;

import enums.EnumProduct;
import systemSale.Sale;

public class Product {
	protected Sale idSale;
	protected String id;	
	protected EnumProduct type;
	protected double price;
	protected String description;

	public Product(Sale idSale, String id, EnumProduct type, double price, String description) {
		this.idSale = idSale;
		this.type = type;
		this.price = price;
		this.description = description;
	}

	public Sale getIdSale() {
		return idSale;
	}

	public void setIdSale(Sale idSale) {
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
}
