package systemSale;

import java.time.LocalDateTime;
import java.time.LocalTime;
import products.Product;

public class Bid {
	private String id;
	private String product;
	private double value;
	private LocalDateTime time;
	private String sale;
	private String client;
	
	public Bid(String id, String product, double value, LocalDateTime time, String sale, String client) {
		this.id = id;
		this.product = product;
		this.value = value;
		this.time = time;
		this.sale = sale;
		this.client = client;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getSale() {
		return sale;
	}

	public void setSale(String sale) {
		this.sale = sale;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}
	
	public String getBid() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id: " + this.id).append("\n");
		sb.append("Product: " + this.product).append("\n");
		sb.append("Value: " + this.value).append("\n");
		sb.append("Time: " + this.time).append("\n");
		sb.append("Client: " + this.client).append("\n");
		sb.append("Sale: " + this.sale).append("\n");
		return sb.toString();
	}
}
