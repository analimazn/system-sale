package models.modelProducts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import products.Building;

public class ModelBuilding {
	

	static List<Building> list = new LinkedList<Building>();

	public static Boolean validateBuilding(Building objBuilding) {
		for(Building building : list) {
		   if(building.getBuilding().equals(objBuilding.getBuilding())) {
			   System.out.println("Imóvel encontrado");
			   System.out.println(objBuilding.getBuilding());
			   return true;
		    }
		}
		System.out.println("Imóvel não encontrado");
		System.out.println(objBuilding.getBuilding());
		return false;
	}
	
	public static void addBuilding(Building objBuilding) {
		if(!validateBuilding(objBuilding)) {
			list.add(objBuilding);
			System.out.println("Imóvel cadastrado com sucesso");
			System.out.println(objBuilding.getBuilding());
		} else {
			System.out.println("Imóvel já cadastrado");
		}
	}
	
	public static Building findBuilding(int id) {
		list.stream()
			.filter(objBuilding -> {
				if(objBuilding.getId() == id) {
					return objBuilding != null;
				}
				return false;
			})
			.forEach(objBuilding -> {
				System.out.println("Imóvel");
				System.out.println(objBuilding.getBuilding());
			});
		return null;
	}
	
	public static void getListBuilding() {
		if (list.size() > 0) {
			System.out.println("Todos os Imóvels");
			for(Building objBuilding: list) {
				System.out.println(objBuilding.getBuilding());
			}
		} else {
			System.out.println("Sem Imóvels");
		}
	}
	
	public static void updateBuilding(Building change) {
		for (Building objBuilding : list) {
			if (validateBuilding(objBuilding) && objBuilding.getId() == change.getId()) {
				System.out.println("Atualizar Imóvel");
				System.out.println(objBuilding.getBuilding());
				list.set(list.indexOf(objBuilding), change);
			}  else {
				System.out.println("Imóvel não encontrado no sistema");
			}
		}
		System.out.println("Imóvel atualizado");
		System.out.println(change.getBuilding());
	}
	
	public static void removeBuilding(int id) {
		for (Building objBuilding : list) {
			if (validateBuilding(objBuilding) && objBuilding.getId() == id) {
				System.out.println("Remover objBuilding");
				System.out.println(objBuilding.getBuilding());
				list.remove(objBuilding);
			} 
		}		
	}
	
	public static List<Building> getBuildingByPriceRange(double minValue,double maxValue){
		List<Building> buildingList = new LinkedList();
		for(Building objBuilding: list) {
			if((objBuilding.getPrice()>=minValue)&& (objBuilding.getPrice()<=maxValue)) {
				buildingList.add(objBuilding);
			}
		}
		return buildingList;
	}
	
	public static List<Building> getBuildingByKeyWord(String keyWord) {
		List<Building> buildingList = new ArrayList<>();
		for(Building building:list) {
			if(building.getDescription().contains(keyWord))
					buildingList.add(building);
		}
		return buildingList;
	}
}