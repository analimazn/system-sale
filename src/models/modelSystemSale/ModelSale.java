package models.modelSystemSale;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import entities.User;
import systemSale.Bid;
import systemSale.Sale;
import enums.EnumStatus;
import models.modelEntities.ModelUser;
import products.Product;

public class ModelSale {
	static List<Sale> list = new LinkedList<Sale>();
	//static Map<Sale, User> wins = new HashMap<Sale, User>();
	
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
		} else {
			System.out.println("Leilão ja cadastrado");
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
	
	public static List<Sale> getListSale() {
		if (list.size() > 0) {
			return list;
		} 
		System.out.println("Sem Leilões");
		return list;
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
	
	public static Map<User, Product> getWin(Sale sale) {
		Map<String, String> winId = new HashMap<String, String>();
		Map<User, Product> win = new HashMap<User, Product>();
		
		for(Product prod: sale.getProducts()) {
			String user = null;
			for(Bid bid: sale.sortBid()) {
				if((prod.getIdSale() == bid.getSale()) &&
						(prod.getId() == bid.getProduct()) && 
						(prod.getPrice() == bid.getValue())) {
					user = bid.getClient();
				}
			}
			winId.put(user, prod.getId());
		}
		List<String> listWin = new ArrayList<String>(winId.values());
		
		User userWin = null;
		Product productArremated = null;
		
		for(User user : ModelUser.getListUser()) {
			for (Product prod : sale.getProducts()) {
				if (user.getId().equals(listWin.get(0))) {
					userWin = user;
				}
				if (prod.getId().equals(listWin.get(1))) {
					productArremated = prod;
				}
			}
		}
		win.put(userWin, productArremated);
		return win;
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
			PrintWriter writer = new PrintWriter(new FileWriter("src/files/sale_" +LocalDate.now().toString()+".det"  ));
			for (Sale salesObj: list) {
				writer.println(salesObj.getSale());
				writer.println("--------------------------------------");				
				
			}
			writer.close();
	}
}