import enums.EnumBuilding;
import enums.EnumProduct;
import enums.EnumUser;
import enums.EnumVehicle;

import java.util.LinkedList;
import java.util.List;

import entities.*;
import models.modelEntities.*;
import models.modelProducts.*;
import models.modelSystemSale.*;
import products.*;
import systemSale.Sale;
import utils.Address;

public class Main {

	public static void main(String[] args) {
		Address address = new Address("rua dois", 40, "city1", "sp", "12222");
		Financial finacial1 = new Financial("001", "nada", "teste");
		Sale sale1 = new Sale("01", "20-09-2010", "30-09-2010", address, finacial1);
		Building casa1 = new Building(sale1, "002", EnumProduct.Building, EnumBuilding.Apartment, 223.00, "teste", address, 44.00);
		Building casa2 = new Building(sale1, "002", EnumProduct.Building, EnumBuilding.Apartment, 223.00, "teste", address, 44.00);
		
		ModelProduct model1 = new ModelProduct();
		model1.addProduct(casa1);
		model1.addProduct(casa2);
		//sale1.setProducts(model1.getListProduct());
		//sale1.getProducts().forEach(prod -> System.out.println(prod.getDescription()));
		
		
	
		/*Users de teste
		User adminOne = new User("teste1", "@123", EnumUser.Admin, "00001", "Teste1", "00000000000000");
		User clientTwo = new User("teste2", "@123", EnumUser.Client, "00002", "Teste2", "11111111111111");
		User clientThree= new User("teste2", "@123", EnumUser.Client, "00002", "Teste2", "11111111111111");
		User clientUpdate = new User("teste4", "@123555", EnumUser.Client, "00002", "Teste4", "222222222222");

		//Validando métodos do User
		ModelUser.addUser(adminOne);
		ModelUser.addUser(clientTwo);
		ModelUser.addUser(clientThree);
		
		ModelUser.findUser(clientTwo.getId());
		ModelUser.updateUser(clientUpdate);
		ModelUser.removeUser(adminOne.getId());
		ModelUser.getListUser();*/
		
		/*Financial financial1 = new Financial("2323", "111111111111111", "Bradesco");
		Financial financial2 = new Financial("2424", "22222222222222", "Itau" );
		Financial financial3 = new Financial("2424", "22222222222222", "Itau" );
		Financial financialUp = new Financial("2424", "555555555555", "BB" );

		//Validando métodos do Financial
		ModelFinancial.addFinancial(financial1);
		ModelFinancial.addFinancial(financial2);
		ModelFinancial.addFinancial(financial3);
		
		ModelFinancial.findFinancial(financial1.getId());
		ModelFinancial.updateFinancial(financialUp);
		ModelFinancial.removeFinancial(financial1.getId());
		ModelFinancial.getListFinancial();*/

		
	}

}
