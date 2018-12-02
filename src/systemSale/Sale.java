package systemSale;

import java.util.LinkedList;
import java.util.List;

import products.Product;
import enums.EnumStatus;

public class Sale {
	private String id;
	private EnumStatus status;
	private String proposalDateBid;
	private String openingDateBid;
	private String address;
	private String financial;
	private List<Product> products = new LinkedList<Product>();
	private List<Bid> bids = new LinkedList<Bid>();

	public Sale(String id, String proposalDateBid, String openingDateBid, 
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
	
	public List<Bid> getBids() {
		return bids;
	}

	public void setClients(List<Bid> bids) {
		this.bids = bids;
	}

	public String getProposalDateBid() {
		return proposalDateBid;
	}

	public void setProposalDateBid(String proposalDateBid) {
		this.proposalDateBid = proposalDateBid;
	}

	public String getOpeningDateBid() {
		return openingDateBid;
	}

	public void setOpeningDateBid(String openingDateBid) {
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
		System.out.println("get all product\n");
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
		System.out.println("get product by type word\n");
		List<Product> searchByType = new LinkedList<Product>();
		for(Product obj: products) {
			if(obj.getType().toString().contains(word) || obj.getDescription().contains(word))
				searchByType.add(obj);
		}
		searchByType.forEach(prod -> System.out.println(prod.getProduct()));
		System.out.println(searchByType.size());
		return searchByType;
	}
	
	public List<Product> getProductByPriceRange(double minValue, double maxValue){
		System.out.println("get product by price range\n");
		List<Product> searchMinMax = new LinkedList<Product>();
		for(Product obj: products) {
			if((obj.getPrice() >= minValue) && (obj.getPrice() <= maxValue)) {
				searchMinMax.add(obj);
			}
		}
		return products;
	}
	
	public String getSale() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id: " + this.id).append("\n");
		sb.append("Status: " + this.status).append("\n");
		sb.append("Proposal String: " + this.proposalDateBid).append("\n");
		sb.append("Opening String: " + this.openingDateBid).append("\n");
		sb.append("Products: " + this.products).append("\n");
		sb.append("Address: " + this.address).append("\n");
		sb.append("Financial: " + this.financial).append("\n");
		return sb.toString();
	}
}

