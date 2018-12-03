import enums.EnumProduct;
import enums.EnumStatus;
import enums.EnumUser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import entities.*;
import models.modelEntities.*;
import models.modelSystemSale.*;
import products.*;
import systemSale.Bid;
import systemSale.Sale;
import utils.Address;

public class Main {

	public static void main(String[] args) {
		Address address = new Address("rua dois", 40, "city1", "sp", "12222");
		Financial finacial1 = new Financial("001", "33333", "teste");
		Sale sale1 = new Sale("01", LocalDate.of(2018, 12, 25),  LocalDate.of(2018, 12, 25), address.getAddress(), finacial1.getFinancial(), EnumStatus.Open);
		Sale sale2 = new Sale("02",  LocalDate.of(2018, 12, 25),  LocalDate.of(2018, 12, 25), address.getAddress(), finacial1.getFinancial(), EnumStatus.Open);
		 
		Product prod1 = new Product(sale1.getId(), "001", EnumProduct.Apartment, 22.00, "testeprod");
		Product prod2 = new Product(sale1.getId(), "002", EnumProduct.Apartment, 22.00, "testeprod");
		Product prod3 = new Product(sale1.getId(), "003", EnumProduct.Apartment, 22.00, "teste");
		
		User user1 = new User("analimazn", "1234", EnumUser.Client, "003", "Ana", "3333");
		User user2 = new User("joao", "1234", EnumUser.Client, "004", "joao", "3333");
		ModelUser.addUser(user1);
		ModelUser.addUser(user2);

		prod1.setAddress(address.getAddress());
		sale1.addProduct(prod1);
		sale1.addProduct(prod2);
		sale1.addProduct(prod3);
		
		Bid bid1 = new Bid("001", prod1.getId(), 230.00, LocalDateTime.now(), sale1.getId(), user1.getId());
		Bid bid2 = new Bid("001", prod1.getId(), 260.00, LocalDateTime.now(), sale1.getId(), user1.getId());
		Bid bid3 = new Bid("001", prod1.getId(), 220.00, LocalDateTime.now(), sale1.getId(), user2.getId());
		sale1.addBid(bid1);
		sale1.addBid(bid2);
		sale1.addBid(bid3);
		//sale1.sortBid().forEach(bid -> System.out.println(bid.getBid()));
		//sale1.getProducts();
		
		//ModelSale.addSale(sale1);
		//ModelSale.addSale(sale2);
		//ModelSale.getListSale();
		


		
		//sale1.findProduct("001");
		//sale1.updateProduct(prod1change);
		//sale1.removeProduct("002");
		//sale1.getProductByTypeOrKeyWord("Apartament").forEach(prod -> System.out.println(prod.getProduct()));
		//sale1.getProductByPriceRange(10.00, 30.00).forEach(prod -> System.out.println(prod.getProduct()));;
		//sale1.getProducts();
		
		ModelSale.addSale(sale1);
		ModelSale.addSale(sale2);
		ModelSale.getWin(sale1).keySet().forEach(keys -> System.out.println("WIN \n" + keys.getUser()));
		ModelSale.getWin(sale1).values().forEach(values -> System.out.println("PRODUCT \n" + values.getProduct()));
		

		//ModelSale.getListSale();

	}

}
