package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.Financial;
import models.modelEntities.ModelFinancial;

class ModelFinancialTest {

	Financial financial1;
	Financial financial2;
	Financial financial3;	
	
	@BeforeEach
	protected void setUp() throws Exception {
		financial1 = new Financial("2323", "111111111111111", "Bradesco");
		financial2 = new Financial("2424", "22222222222222", "Itau" );
		financial3 = new Financial("2424", "22222222222223", "Itau" );		
	}
	
	@Test
	public void addFinancial() {		
		ModelFinancial.addFinancial( financial1 );
		assertEquals(true, ModelFinancial.validateFinancial(financial1));
	}
	
	@Test
	public void removeFinancial() {			
		ModelFinancial.addFinancial( financial2 );
		ModelFinancial.removeFinancial(financial2.getId());		
		assertEquals(false, ModelFinancial.validateFinancial(financial2));		
	}

}
