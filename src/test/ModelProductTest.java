package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import entities.Financial;
import enums.EnumProduct;
import models.modelProducts.ModelProduct;
import products.Product;
import systemSale.Sale;
import utils.Address;

class ModelProductTest {
	
	Product product1;
	Product product2;
	
	@BeforeEach
	protected void setUp() throws Exception {
		product1 = new Product(new Sale("0001",  LocalDate.of(2015, 3,5) , LocalDate.of(2015, 3,7), 
				new Address("Rua Emílio Marelo", 182, "São Paulo", "São Paulo", "12241200"), 
				new Financial("0001", "123456789101213", "Moura Finanças")),
				"0001", EnumProduct.Apartment, 
				new Address("Rua Emílio Marelo", 182, "São Paulo", "São Paulo", "12241200"), 198396, "apartamento a 3 minutes from Carrefour and 5 minutes from Vale Sul Shopping mall");
		product2 = new Product(new Sale("0001",  LocalDate.of(2015, 3,5) , LocalDate.of(2015, 3,7), 
				new Address("Rua Emílio Marelo", 182, "São Paulo", "São Paulo", "12241200"), 
				new Financial("0001", "123456789101213", "Moura FInanças")),
				"0002", EnumProduct.Apartment, 
				new Address("Rua Emílio Marelo", 182, "São Paulo", "São Paulo", "12241200"), 198396, "apartamento a 3 minutes from Carrefour and 5 minutes from Vale Sul Shopping mal");
		ModelProduct.addProduct( product1 );
			}

	@Test
	public void addProduct() {			
		assertTrue(ModelProduct.validateProduct(product1));
	}
		
	@Test
	public void getProductByTypeOrKeyWord() {		
		String keyword = "apartamento";
		assertTrue(ModelProduct.getProductByTypeOrKeyWord(keyword).size() > 0 );		
	}
	
	@Test
	public void getProductByPriceRange() {		
		double minValue =  product1.getPrice() - 1;
		double maxValue = product1.getPrice() + 1;
		assertTrue(ModelProduct.getProductByPriceRange(minValue, maxValue).size() > 0 );
		
		double minValue2 =  product1.getPrice();
		double maxValue2 = product1.getPrice() + 1;
		assertTrue(ModelProduct.getProductByPriceRange(minValue2, maxValue2).size() > 0 );
		
		double minValue3 =  product1.getPrice() - 1;
		double maxValue3 = product1.getPrice();		
		assertTrue(ModelProduct.getProductByPriceRange(minValue3, maxValue3).size() > 0 );
	}
	
	@Test
	public void removeProduct() {
		ModelProduct.addProduct( product2 );
		ModelProduct.removeProduct(product2.getId());
		assertFalse(ModelProduct.validateProduct(product2));		
	}

}
