package systemSale;

import java.time.LocalTime;
import entities.User;
import products.*;


public class Bid {
	private User client;
	private Product product;
	private String id;
	private double value;
	private LocalTime time;
	
	public Bid(String id, double value, LocalTime time) {
		this.id = id;
		this.value = value;
		this.time = time;
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
}
