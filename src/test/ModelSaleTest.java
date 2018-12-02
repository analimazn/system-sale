package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.Financial;
import systemSale.Sale;
import models.modelSystemSale.ModelSale;
import systemSale.Sale;
import utils.Address;

class ModelSaleTest {

	Sale sale1;
	Sale sale2;
	
	@BeforeEach
	protected void setUp() throws Exception {
		sale1 = new Sale("01", "20-09-2010", "30-09-2010", new Address("rua dois", 40, "city1", "sp", "12222"), new Financial("001", "nada", "teste"));
		sale2 = new Sale("02", "20-09-2010", "30-09-2010", new Address("rua dois", 40, "city1", "sp", "12222"), new Financial("002", "nada", "teste"));
	}
	
	@Test
	public void addSale() {		
		ModelSale.addSale( sale1 );
		assertEquals(true, ModelSale.validateSale(sale1));
	}
	
	@Test
	public void removeSale() {			
		ModelSale.addSale( sale2 );
		ModelSale.removeSale(sale2.getId());		
		assertEquals(false, ModelSale.validateSale(sale2));		
	}
	

}
