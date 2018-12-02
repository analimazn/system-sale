package models.modelProducts;

import java.util.LinkedList;
import java.util.List;
import products.Product;

public class ModelProduct {

	List<Product> list = new LinkedList<Product>();
	
	public Boolean validateProduct(String idProduct) {
		try {
			if(list.isEmpty()) {
				return false;
			} else  {
				for(Product product : list) {
					if(product.getId().equals(idProduct)) {
						System.out.println("Produto encontrado");
						return true;
					}
					return false;
				}
				return null;
			}
		} catch(java.lang.NullPointerException e) {
			System.out.println("Nao há nada na lista");
			return false;
		}
		
	}
	
	public Product addProduct(Product objProduct) {
		try {
			if(list.isEmpty()) {
				System.out.println("Lista Vazia");
				list.add(objProduct);
				return objProduct;
			} else  {
				System.out.println(list);
				System.out.println(list.isEmpty());
				for(Product product : list) {
					if(product.getId().equals(objProduct.getId())) {
						System.out.println("Produto já cadastrado");
						return null;
					}
					list.add(list.indexOf(objProduct), objProduct);
					return objProduct;
				}
				return null;
			}
		} catch(java.lang.NullPointerException e) {
			System.out.println("Nao há nada na lista");
			return null;
		}
	}
	
	public Product findProduct(String id) {
		list.stream()
			.filter(objProduct -> {
				if(objProduct.getId() == id) {
					return objProduct != null;
				}
				return false;
			})
			.forEach(objProduct -> {
				System.out.println("Produto");
				System.out.println(objProduct.toString());
			});
		return null;
	}
	
	public List<Product> getListProduct() {
		if (list.size() > 0) {
			System.out.println("Todos os Produtos");
			for(Product objProduct: list) {
				System.out.println(objProduct.toString());
			}
		} else {
			System.out.println("Sem Produtos");
		}
		return list;
	}
	
	public void updateProduct(Product change) {
		for (Product objProduct : list) {
			if (validateProduct(objProduct) && objProduct.getId() == change.getId()) {
				System.out.println("Atualizar Produto");
				System.out.println(objProduct.toString());
				list.set(list.indexOf(objProduct), change);
			}  else {
				System.out.println("Produto năo encontrado no sistema");
			}
		}
		System.out.println("Produto atualizado");
		System.out.println(change.toString());
	}
	
	public void removeProduct(String id) {
		for (Product objProduct : list) {
			if (validateProduct(objProduct) && objProduct.getId() == id) {
				System.out.println("Remover produto");
				System.out.println(objProduct.toString());
				list.remove(objProduct);
			} 
		}		
	}
	
	public List<Product> getProductByTypeOrKeyWord(String word) {
		List<Product> products = new LinkedList<Product>();
		for(Product objProduct: list) {
			if(objProduct.getType().toString().contains(word) ||
					objProduct.getDescription().contains(word))
				products.add(objProduct);			
		}
		return products;
	}
	
	public List<Product> getProductByPriceRange(double minValue, double maxValue){
		List<Product> products = new LinkedList<Product>();
		for(Product objProduct: list) {
			if((objProduct.getPrice() >= minValue) && (objProduct.getPrice() <= maxValue)) {
				products.add(objProduct);
			}
		}
		return products;
	}
}