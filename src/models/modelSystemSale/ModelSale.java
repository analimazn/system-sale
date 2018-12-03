package models.modelSystemSale;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import systemSale.Sale;
import enums.EnumStatus;

public class ModelSale {
	static List<Sale> list = new LinkedList<Sale>();
	
	public static Boolean validateSale(Sale obj) {
		for(Sale sale : list) {
		   if(sale.getId().equals(obj.getId())) {
			   System.out.println("Leilão encontrado");
			   return true;
		    }
		}
		System.out.println("Leilão não encontrado");
		return false;
	}
	
	public static void addSale(Sale obj) {
		if(!validateSale(obj)) {
			list.add(obj);
			System.out.println("Leilão cadastrado com sucesso");
			System.out.println(obj.getSale());
		} else {
			System.out.println("Leilão já cadastrado");
		}
	}
	
	public static Sale findSale(String id) {
		list.stream()
			.filter(obj -> {
				if(obj.getId() == id) {
					return obj != null;
				}
				return false;
			})
			.forEach(obj -> {
				System.out.println("Leilão");
				System.out.println(obj.getSale());
			});
		return null;
	}
	
	public static void getListSale() {
		if (list.size() > 0) {
			System.out.println("Todos os leilões");
			for(Sale obj: list) {
				System.out.println(obj.getSale());
			}
		} else {
			System.out.println("Sem Leilões");
		}
	}
	
	public static void updateSale(Sale change) {
		for (Sale obj : list) {
			if (obj.getId() == change.getId()) {
				System.out.println("Atualizar Leilão");
				System.out.println(obj.getSale());
				list.set(list.indexOf(obj), change);
			}
		}
		System.out.println("Leilão atualizado");
		System.out.println(change.getSale());
	}
	
	public static void removeSale(String id) {
		for (Sale obj : list) {
			if (obj.getId() == id) {
				System.out.println("Remover Leilão");
				System.out.println(obj.getSale());
				list.remove(obj);
			} 
		}		
	}
	
	public static String getStatus(Sale sale) {		
	LocalDate now = LocalDate.now();
		
		if((now.isAfter(sale.getOpeningDateBid()))&&(now.isBefore(sale.getProposalDateBid()))) {
			return EnumStatus.Occurring.toString();
		}
		if(now.isAfter(sale.getProposalDateBid())) {
			return EnumStatus.Finalized.toString();
		}
		else
			return EnumStatus.Open.toString();
	}
	
	public static void exportFile(List<Sale> list) throws IOException {
		PrintWriter writer = new PrintWriter(new FileWriter(".files/sale_" +LocalDate.now().toString()+".det"  ));
		for (Sale salesObj: list) {
			writer.println(salesObj.toString());
			writer.println("--------------------------------------");
		}
	}
			

	
}
