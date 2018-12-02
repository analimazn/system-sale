package test;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import org.hamcrest.core.AllOf;
import org.junit.Test;

import entities.Financial;
import enums.EnumProduct;
import junit.framework.TestCase;
import models.modelProducts.ModelProduct;
import products.Product;
import systemSale.Sale;
import utils.Address;

public class ModelProductTest  extends TestCase{
	Product product;
	ModelProduct modelproduct;

	@Test
	public void addProduct() {
		product = new Product(new Sale("0001",  LocalDate.of(2015, 3,5) , LocalDate.of(2015, 3,7), 
				new Financial("0001", "123456789101213", "Moura FInan�as")),
				"0001", EnumProduct.Building, 
				198396, "3 minutes from Carrefour and 5 minutes from Shopping Vale Sul");
		
		ModelProduct.addProduct( product );		
		//assertEquals(true, modelproduct.validateProduct(product));
	}
	
	@Test
	public void removeProduct() {	
		product = new Product(new Sale("0001",  LocalDate.of(2015, 3,5) , LocalDate.of(2015, 3,7), 
				new Address("Rua Em�lio Marelo", 182, "S�o Paulo", "S�o Paulo", "12241200"), 
				new Financial("0001", "123456789101213", "Moura FInan�as")),
				"0001", EnumProduct.Apartment, 
				new Address("Rua Em�lio Marelo", 182, "S�o Paulo", "S�o Paulo", "12241200"), 198396, "3 minutes from Carrefour and 5 minutes from Shopping Vale Sul");
		
		
		ModelProduct.addProduct( product );
		modelproduct.removeProduct("00002");		
//		/assertEquals(false, modelproduct.validateProduct(product));		
	}
	
	
@Test
	public void getProductByPriceRange() {	
		double minValue = 10.0;
		double maxValue = 15.0;
	
	//	 assertThat(price, (greaterThan(minValue), lessThan(maxValue) ) );				
	}
	
	@Test
	public void getProductByTypeOrKeyWord() {
		
	}
}
