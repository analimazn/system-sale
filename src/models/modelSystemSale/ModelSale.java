package models.modelSystemSale;

import java.util.LinkedList;
import java.util.List;
import systemSale.Sale;

public class ModelSale {
	static List<Sale> list = new LinkedList<Sale>();
	
	public static Boolean validateSale(Sale objSale) {
		for(Sale sale : list) {
		   if(sale.getSale().equals(objSale.getSale())) {
			   System.out.println("Leilão encontrado");
			   System.out.println(objSale.getSale());
			   return true;
		    }
		}
		System.out.println("Leilão năo encontrado");
		System.out.println(objSale.getSale());
		return false;
	}
	
	public static void addSale(Sale objSale) {
		if(!validateSale(objSale)) {
			list.add(objSale);
			System.out.println("Leilão cadastrado com sucesso");
			System.out.println(objSale.getSale());
		} else {
			System.out.println("Leilão já cadastrado");
		}
	}
	
	public Sale findSale(String id) {
		list.stream()
			.filter(objSale -> {
				if(objSale.getId() == id) {
					return objSale != null;
				}
				return false;
			})
			.forEach(objSale -> {
				System.out.println("Leilão");
				System.out.println(objSale.getSale());
			});
		return null;
	}
	
	public void getListSale() {
		if (list.size() > 0) {
			System.out.println("Todos os leilões");
			for(Sale objSale: list) {
				System.out.println(objSale.getSale());
			}
		} else {
			System.out.println("Sem Leilões");
		}
	}
	
	public void updateSale(Sale change) {
		for (Sale objSale : list) {
			if (objSale.getId() == change.getId()) {
				System.out.println("Atualizar Produto");
				System.out.println(objSale.getSale());
				list.set(list.indexOf(objSale), change);
			}
		}
		System.out.println("Leilão atualizado");
		System.out.println(change.getSale());
	}
	
	public static void removeSale(String id) {
		for (Sale objSale : list) {
			if (objSale.getId() == id) {
				System.out.println("Remover produto");
				System.out.println(objSale.getSale());
				list.remove(objSale);
			} 
		}		
	}
	
	
}
