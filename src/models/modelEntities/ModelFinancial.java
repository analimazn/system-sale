package models.modelEntities;

import java.util.List;
import java.util.LinkedList;
import entities.Financial;
import entities.User;

public class ModelFinancial {
	static List<Financial> list = new LinkedList<Financial>();

	public static Boolean validateFinancial(Financial objFinancial) {
		for(Financial financial : list) {
		   if(financial.getFinancial().equals(objFinancial.getFinancial())) {
			   System.out.println("Instituição Financeira encontrada");
			   return true;
		    }
		}
		System.out.println("Instituição Financeira não encontrada");
		return false;
	}
	
	public static void addFinancial(Financial objFinancial) {
		if(!validateFinancial(objFinancial)) {
			list.add(objFinancial);
			System.out.println("Instituição Financeira cadastrada com sucesso");
		} else {
			System.out.println("Instituição Financeira não cadastrada");
		}
	}
	
	public static Financial findFinancial(String id) {
		list.stream()
			.filter(objFinancial -> {
				if(objFinancial.getId() == id) {
					return objFinancial != null;
				}
				return false;
			})
			.forEach(objFinancial -> {
				System.out.println("Instituição Financeira");
				System.out.println(objFinancial.getFinancial());
			});
		return null;
	}
	
	public static List<Financial> getListFinancial() {
		if (list.size() > 0) {
			return list;
		} 
		System.out.println("Sem Instituições Financeiras");
		return list;
	}
	
	public static void updateFinancial(Financial change) {
		for (Financial objFinancial : list) {
			if (validateFinancial(objFinancial) && objFinancial.getId()
					.equals(change.getId())) {
				System.out.println("Atualizar Instituição Financeira");
				System.out.println(objFinancial.getFinancial());
				list.set(list.indexOf(objFinancial), change);
			}  else {
				System.out.println("Instituição Financeira não encontrada no sistema");
			}
		}
		System.out.println("Instituição Financeira atualizada");
		System.out.println(change.getFinancial());
	}
	
	public static void removeFinancial(String id) {
		for (Financial objFinancial : list) {
			if (validateFinancial(objFinancial) && objFinancial.getId().equals(id)) {
				System.out.println("Remover Instituição Financeira");
				System.out.println(objFinancial.getFinancial());
				list.remove(objFinancial);
			} 
		}		
	}
	
}


