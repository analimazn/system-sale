package models.modelProducts;

import java.util.LinkedList;
import java.util.List;
import products.Product;

public class ModelProduct {

	static List<Product> list = new LinkedList<Product>();
	
	public static Boolean validateProduct(Product objProduct) {
		for(Product product : list) {
		   if(product.getProduct().equals(objProduct.getProduct())) {
			   System.out.println("Produto encontrado");
			   System.out.println(objProduct.getProduct());
			   return true;
		    }
		}
		System.out.println("Produto năo encontrado");
		System.out.println(objProduct.getProduct());
		return false;
	}
	
	public static void addProduct(Product objProduct) {
		if(!validateProduct(objProduct)) {
			list.add(objProduct);
			System.out.println("Produto cadastrado com sucesso");
			System.out.println(objProduct.getProduct());
		} else {
			System.out.println("Produto já cadastrado");
		}
	}
	
	public static Product findProduct(String id) {
		list.stream()
			.filter(objProduct -> {
				if(objProduct.getId() == id) {
					return objProduct != null;
				}
				return false;
			})
			.forEach(objProduct -> {
				System.out.println("Produto");
				System.out.println(objProduct.getProduct());
			});
		return null;
	}
	
	public static void getListProduct() {
		if (list.size() > 0) {
			System.out.println("Todos os Produtos");
			for(Product objProduct: list) {
				System.out.println(objProduct.getProduct());
			}
		} else {
			System.out.println("Sem Produtos");
		}
	}
	
	public static void updateProduct(Product change) {
		for (Product objProduct : list) {
			if (validateProduct(objProduct) && objProduct.getId() == change.getId()) {
				System.out.println("Atualizar Produto");
				System.out.println(objProduct.getProduct());
				list.set(list.indexOf(objProduct), change);
			}  else {
				System.out.println("Produto năo encontrado no sistema");
			}
		}
		System.out.println("Produto atualizado");
		System.out.println(change.getProduct());
	}
	
	public static void removeProduct(String id) {
		for (Product objProduct : list) {
			if (validateProduct(objProduct) && objProduct.getId() == id) {
				System.out.println("Remover produto");
				System.out.println(objProduct.getProduct());
				list.remove(objProduct);
			} 
		}		
	}
	
	public static List<Product> getProductByTypeOrKeyWord(String word) {
		List<Product> products = new LinkedList<Product>();
		for(Product objProduct: list) {
			if(objProduct.getVehicletype().toString().contains(word) ||
					objProduct.getDescription().contains(word))
				products.add(objProduct);			
		}
		return products;
	}
	
	public static List<Product> getProductByPriceRange(double minValue, double maxValue){
		List<Product> products = new LinkedList<Product>();
		for(Product objProduct: list) {
			if((objProduct.getPrice() >= minValue) && (objProduct.getPrice() <= maxValue)) {
				products.add(objProduct);
			}
		}
		return products;
	}
}