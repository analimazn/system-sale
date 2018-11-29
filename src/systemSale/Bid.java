package systemSale;

import java.time.LocalTime;
import entities.User;
import products.Product;
import systemSale.Sale;

public class Bid {
	private String id;
	private double value;
	private LocalTime time;
	private Sale sale;
	private User client;
	
	public Bid(String id,  double value, LocalTime time, Sale sale, Product product,  User client) {
		this.id = id;
		this.value = value;
		this.time = time;
		this.sale = sale;
		this.client = client;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	
	public String getBid() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id: " + this.id).append("\n");
		sb.append("Value: " + this.value).append("\n");
		sb.append("Time: " + this.time).append("\n");
		sb.append("Client: " + this.client).append("\n");
		sb.append("Sale: " + this.sale).append("\n");
		return sb.toString();
	}
}
