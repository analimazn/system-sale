import enums.EnumProduct;
import enums.EnumStatus;
import enums.EnumUser;

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
		Financial finacial1 = new Financial("001", "33333", "teste");
		Sale sale1 = new Sale("01", "20-09-2010", "30-09-2010", address.getAddress(), finacial1.getFinancial(), EnumStatus.Open);
		Product prod1 = new Product(sale1.getId(), "001", EnumProduct.Apartment, 22.00, "testeprod");
		Product prod2 = new Product(sale1.getId(), "002", EnumProduct.Apartment, 22.00, "testeprod");
		Product prod3 = new Product(sale1.getId(), "003", EnumProduct.Apartment, 22.00, "teste");
		Product prod1change = new Product(sale1.getId(), "001", EnumProduct.BuildingSit, 22.00, "teste");

		prod1.setAddress(address.getAddress());
		sale1.addProduct(prod1);
		sale1.addProduct(prod2);
		sale1.addProduct(prod3);
		
		//sale1.findProduct("001");
		//sale1.updateProduct(prod1change);
		//sale1.removeProduct("002");
		sale1.getProductByTypeOrKeyWord("Apartament");
		//sale1.getProductByPriceRange(10.00, 30.00);
		//sale1.getProducts();

	}

}
