package models.modelProducts;

import java.util.LinkedList;
import java.util.List;
import products.Product;

public class ModelProduct {

	static List<Product> list = new LinkedList<>();
	
	public static Boolean validateProduct(Product objProduct) {
		try {
			if(list.isEmpty() || !list.contains(objProduct)) {
				return false;
			} else  {
				return true;
			}
		} catch(java.lang.NullPointerException e) {
			System.out.println("Nao há nada na lista");
			return false;
		}
	}
	
	public static void addProduct(Product objProduct) {
		try {
			if (!validateProduct(objProduct)) {
				System.out.println("Cadastrar produto");
				System.out.println(objProduct.getIdSale());
				list.add(objProduct);
			} else  {
				System.out.println("Produto ja cadastrado");
			}
		} catch(java.lang.NullPointerException e) {
			System.out.println("Nao há nada na lista");
		}
	}
	
	public static Product findProduct(String id) {
		System.out.println("No find");
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
	
	public static List<Product> getListProduct() {
		if (list.size() > 0) {
			System.out.println("Todos os Produtos");
			for(Product objProduct: list) {
				System.out.println(objProduct.getProduct());
			}
		} else {
			System.out.println("Sem Produtos");
		}
		return list;
	}
	
	public static void updateProduct(Product change) {
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
	
	public static void removeProduct(String id) {
		for (Product objProduct : list) {
			if (validateProduct(objProduct) && objProduct.getId() == id) {
				System.out.println("Remover produto");
				System.out.println(objProduct.toString());
				list.remove(objProduct);
			} 
		}		
	}
	
	public static List<Product> getProductByTypeOrKeyWord(String word) {
		List<Product> products = new LinkedList<Product>();
		for(Product objProduct: list) {
			if(objProduct.getType().toString().contains(word) ||
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