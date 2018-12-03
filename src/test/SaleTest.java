package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.Financial;
import enums.EnumProduct;
import enums.EnumStatus;
import products.Product;
import systemSale.Sale;
import utils.Address;

class SaleTest {

	Product product1;
	Product product2;
	Sale sale1;
	Sale sale2;
	Financial finacial1;
	
	@BeforeEach
	protected void setUp() throws Exception {
		Address address = new Address("rua dois", 40, "city1", "sp", "12222");
		
		Financial finacial1 = new Financial("001", "33333", "Itau");
		
		sale1 = new Sale("01", LocalDate.of(2018, 12, 25),  LocalDate.of(2018, 12, 25), address.getAddress(), finacial1.getFinancial(), EnumStatus.Open);
		sale2 = new Sale("02",  LocalDate.of(2018, 12, 25),  LocalDate.of(2018, 12, 25), address.getAddress(), finacial1.getFinancial(), EnumStatus.Open);
		
		product1 =new Product(sale1.getId(), "001", EnumProduct.Apartment, 22.00, "testeprod");
		product2 = new Product(sale2.getId(), "002", EnumProduct.Apartment, 22.00, "testeprod");
		
		sale1.addProduct( product1 );
			}

	@Test
	public void addProduct() {			
		assertTrue(sale1.validateProduct(product1));
	}
		
	@Test
	public void getProductByTypeOrKeyWord() {		
		String keyword = "apartamento";
		assertTrue(sale1.getProductByTypeOrKeyWord(keyword).size() > 0 );		
	}
	
	@Test
	public void getProductByPriceRange() {		
		double minValue =  product1.getPrice() - 1;
		double maxValue = product1.getPrice() + 1;
		assertTrue(sale1.getProductByPriceRange(minValue, maxValue).size() > 0 );
		
		double minValue2 =  product1.getPrice();
		double maxValue2 = product1.getPrice() + 1;
		assertTrue(sale1.getProductByPriceRange(minValue2, maxValue2).size() > 0 );
		
		double minValue3 =  product1.getPrice() - 1;
		double maxValue3 = product1.getPrice();		
		assertTrue(sale1.getProductByPriceRange(minValue3, maxValue3).size() > 0 );
		
		double minValue4 =  product1.getPrice() + 1;
		double maxValue4 = product1.getPrice() + 2;
		assertFalse(sale1.getProductByPriceRange(minValue4, maxValue4).size() > 0 );
	}
	
	@Test
	public void removeProduct() {
		sale2.addProduct( product2 );
		sale2.removeProduct(product2.getId());
		assertFalse(sale2.validateProduct(product2));		
	}

}
