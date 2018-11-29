package systemSale;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import entities.*;
import products.Product;
import utils.Address;
import enums.EnumStatus;

public class Sale {
	private String id;
	private EnumStatus status;
	private LocalDate proposalDateBid;
	private LocalDate openingDateBid;
	private Address address;
	private Financial financial;
	private List<Product> products = new LinkedList<Product>();
	private List<Bid> bids = new LinkedList<Bid>();

	public Sale(String id, LocalDate proposalDateBid, LocalDate openingDateBid, Address address, Financial financial) {
		this.id = id;
		this.proposalDateBid = proposalDateBid;
		this.openingDateBid = openingDateBid;
		this.address = address;
		this.financial = financial;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EnumStatus getStatus() {
		return status;
	}

	public void setStatus(EnumStatus status) {
		this.status = status;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Bid> getBids() {
		return bids;
	}

	public void setClients(List<Bid> bids) {
		this.bids = bids;
	}

	public LocalDate getProposalDateBid() {
		return proposalDateBid;
	}

	public void setProposalDateBid(LocalDate proposalDateBid) {
		this.proposalDateBid = proposalDateBid;
	}

	public LocalDate getOpeningDateBid() {
		return openingDateBid;
	}

	public void setOpeningDateBid(LocalDate openingDateBid) {
		this.openingDateBid = openingDateBid;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Financial getFinancial() {
		return financial;
	}

	public void setFinancial(Financial financial) {
		this.financial = financial;
	}
	
	public String getSale() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id: " + this.id).append("\n");
		sb.append("Status: " + this.status).append("\n");
		sb.append("Proposal Date: " + this.proposalDateBid).append("\n");
		sb.append("Opening Date: " + this.openingDateBid).append("\n");
		sb.append("Products: " + this.products).append("\n");
		sb.append("Address: " + this.address).append("\n");
		sb.append("Financial: " + this.financial).append("\n");
		return sb.toString();
	}
}

