package models.modelProducts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import enums.EnumVehicle;
import products.Vehicle;

public class ModelVehicle {

	static List<Vehicle> list = new LinkedList<Vehicle>();

	public static Boolean validateVehicle(Vehicle objVehicle) {
		for(Vehicle vehicle : list) {
		   if(vehicle.getVehicle().equals(objVehicle.getVehicle())) {
			   System.out.println("Veiculo encontrado");
			   System.out.println(objVehicle.getVehicle());
			   return true;
		    }
		}
		System.out.println("Veiculo não encontrado");
		System.out.println(objVehicle.getVehicle());
		return false;
	}
	
	public static void addVehicle(Vehicle objVehicle) {
		if(!validateVehicle(objVehicle)) {
			list.add(objVehicle);
			System.out.println("Veículo cadastrado com sucesso");
			System.out.println(objVehicle.getVehicle());
		} else {
			System.out.println("Veículo já cadastrado");
		}
	}
	
	public static Vehicle findVehicle(int id) {
		list.stream()
			.filter(objVehicle -> {
				if(objVehicle.getId() == id) {
					return objVehicle != null;
				}
				return false;
			})
			.forEach(objVehicle -> {
				System.out.println("Veículo");
				System.out.println(objVehicle.getVehicle());
			});
		return null;
	}
	
	public static void getListVehicle() {
		if (list.size() > 0) {
			System.out.println("Todos os Veículos");
			for(Vehicle objVehicle: list) {
				System.out.println(objVehicle.getVehicle());
			}
		} else {
			System.out.println("Sem Veículos");
		}
	}
	
	public static void updateVehicle(Vehicle change) {
		for (Vehicle objVehicle : list) {
			if (validateVehicle(objVehicle) && objVehicle.getId() == change.getId()) {
				System.out.println("Atualizar Veículo");
				System.out.println(objVehicle.getVehicle());
				list.set(list.indexOf(objVehicle), change);
			}  else {
				System.out.println("Veículo não encontrado no sistema");
			}
		}
		System.out.println("Veículo atualizado");
		System.out.println(change.getVehicle());
	}
	
	public static void removeVehicle(int id) {
		for (Vehicle objVehicle : list) {
			if (validateVehicle(objVehicle) && objVehicle.getId() == id) {
				System.out.println("Remover objVehicle");
				System.out.println(objVehicle.getVehicle());
				list.remove(objVehicle);
			} 
		}		
	}
	
	public static List<Vehicle> getVehicleByType(String type) {
		List<Vehicle> vehicleList = new LinkedList();
		for(Vehicle objVehicle: list) {
			if(objVehicle.getVehicletype().equals(type)) 
				vehicleList.add(objVehicle);			
		}
		return vehicleList;
	}
	
	public static List<Vehicle> getVehicleByPriceRange(double minValue,double maxValue){
		List<Vehicle> vehicleList = new LinkedList();
		for(Vehicle objVehicle: list) {
			if((objVehicle.getPrice()>=minValue)&& (objVehicle.getPrice()<=maxValue)) {
				vehicleList.add(objVehicle);
			}
		}
		return vehicleList;
	}
	
	public static List<Vehicle> getVehicleByKeyWord(String keyWord) {
		List<Vehicle> vehicleList = new ArrayList<>();
		for(Vehicle vehicle:list) {
			if(vehicle.getVehicletype().equals(EnumVehicle.Motorcycle.toString()) ||
					vehicle.getVehicletype().equals(EnumVehicle.Car.toString())){
				if(((Vehicle)vehicle).getDescription().contains(keyWord))
					vehicleList.add(vehicle);
		}
		}
		return vehicleList;
	}
	
	
}
