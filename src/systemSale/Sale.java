package systemSale;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import products.Product;
import enums.EnumStatus;

public class Sale {
	private String id;
	private EnumStatus status;
	private LocalDate proposalDateBid;
	private LocalDate openingDateBid;
	private String address;
	private String financial;
	private List<Product> products = new LinkedList<Product>();
	private List<Bid> bids = new LinkedList<Bid>();

	public Sale(String id, LocalDate proposalDateBid, LocalDate openingDateBid, 
			String address, String financial, EnumStatus status) {
		this.id = id;
		this.proposalDateBid = proposalDateBid;
		this.openingDateBid = openingDateBid;
		this.address = address;
		this.financial = financial;
		this.status = status;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFinancial() {
		return financial;
	}

	public void setFinancial(String financial) {
		this.financial = financial;
	}
	
	public List<Product> getProducts() {
		System.out.println("get all products\n");
		if (!products.isEmpty()) {
			System.out.println("Todos os Produtos");
			for(Product obj: products) {
				System.out.println(obj.getProduct());
			}
		} else {
			System.out.println("Sem Produtos");
		}
		return products;
	}

	public Boolean validateProduct(Product obj) {
		try {
			if(products.isEmpty()) {
				return false;
			} else {
				for(Product prod : products) {
					if(prod.getId().equals(obj.getId())) {
						return true;
					} return false;
				}
				return null;
			}
		} catch(java.lang.NullPointerException e) {
			System.out.println("Nao há nada na lista");
			return false;
		}
	}
	
	public void addProduct(Product obj) {
		try {
			if (!validateProduct(obj)) {
				System.out.println("Cadastrar produto");
				products.add(obj);
			} else  {
				System.out.println("Produto ja cadastrado");
			}
		} catch(java.lang.NullPointerException e) {
			System.out.println("Nao há nada na lista");
		}
	}
	
	public Product findProduct(String id) {
		System.out.println("find product\n");
		products.stream()
			.filter(obj -> {
				if(obj.getId() == id) {
					return obj != null;
				}
				return false;
			})
			.forEach(obj -> {
				System.out.println("Produto");
				System.out.println(obj.getProduct());
			});
		return null;
	}
	
	public Product updateProduct(Product change) {
		System.out.println("update product\n");
		for (Product obj : products) {
			if (obj.getId() == change.getId()) {
				System.out.println("Atualizar Produto");
				System.out.println(obj.getProduct());
				products.set(products.indexOf(obj), change);
				System.out.println("Produto atualizado");
				System.out.println(change.getProduct());
				return obj;
			}  else {
				System.out.println("Produto năo encontrado no sistema");
				return change;
			}
		}
		return change;
	}
	
	public Boolean removeProduct(String id) {
		for (Product obj : products) {
			if (obj.getId().equals(id)) {
				System.out.println("Remover produto");
				System.out.println(obj.getProduct());
				products.remove(obj);
				return true;
			}
		}
		return false;
	}
	
	public List<Product> getProductByTypeOrKeyWord(String word) {
		List<Product> found = new LinkedList<Product>();
		for(Product obj: products) {
			if(obj.getType().toString().contains(word) || 
					obj.getDescription().contains(word))
				System.out.println("");
				found.add(obj);
		}
		return found;
	}
	
	public List<Product> getProductByPriceRange(double minValue, double maxValue){
		System.out.println("get product by price range\n");
		List<Product> searchMinMax = new LinkedList<Product>();
		for(Product obj: products) {
			if((obj.getPrice() >= minValue) && (obj.getPrice() <= maxValue))
				System.out.println("");
				searchMinMax.add(obj);
		}
		return searchMinMax;
	}
	
	public Boolean validateBid(Bid obj) {
		try {
			if(products.isEmpty()) {
				return false;
			} else {
				for(Product prod : products) {
					if(prod.getId().equals(obj.getProduct()) && obj.getValue() > prod.getPrice()) {
						prod.setPrice(obj.getValue());
						return true;
					} return false;
				}
				return null;
			}			
		} catch(java.lang.NullPointerException e) {
			System.out.println("Nao há nada na lista");
			return false;
		}
	}
	
	public Boolean addBid(Bid obj) {
		if(validateBid(obj)) {
			System.out.println("Lance computado com sucesso");
			bids.add(obj);
			
			bids.forEach(bid -> System.out.println(bid.getBid()));
			return true;
		}
		System.out.println(bids);
		System.out.println("Lance inválido");
		return null;
		
	}
	
	public String getSale() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id: " + this.id).append("\n");
		sb.append("Status: " + this.status).append("\n");
		sb.append("Proposal String: " + this.proposalDateBid).append("\n");
		sb.append("Opening String: " + this.openingDateBid).append("\n");
		sb.append("Products\n" + this.products).append("\n");
		sb.append("Address\n" + this.address).append("\n");
		sb.append("Financial\n" + this.financial);
		return sb.toString();
	}
}

