package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.Financial;
import enums.EnumStatus;
import systemSale.Sale;
import models.modelSystemSale.ModelSale;
import utils.Address;

class ModelSaleTest {

	Sale sale1;
	Sale sale2;
	Financial finacial1;
	
	@BeforeEach
	protected void setUp() throws Exception {
		Address address = new Address("rua dois", 40, "city1", "sp", "12222");
		
		finacial1 = new Financial("001", "33333", "Itau");
		
		sale1 = new Sale("01", LocalDate.of(2018, 12, 25),  LocalDate.of(2018, 12, 25), address.getAddress(), finacial1.getFinancial(), EnumStatus.Open);
		sale2 = new Sale("02",  LocalDate.of(2018, 12, 25),  LocalDate.of(2018, 12, 25), address.getAddress(), finacial1.getFinancial(), EnumStatus.Open);
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
