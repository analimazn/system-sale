package test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import org.hamcrest.core.AllOf;
import org.junit.Test;

import junit.framework.TestCase;

public class ModelProductTest  extends TestCase{

@Test
	public void getVehicleByPriceRange() {	
		double minValue = 10.0;
		double maxValue = 15.0;
		double price = 12.0;
		
		 assertTrue("Error: value exceeds maximum value", price > maxValue );
		 assertTrue("Error: value exceeds minimum value", price < minValue );
		 
//		 assertThat(price, AllOf(greatThan(minValue), lessThan(maxValue) ) );				
	}
	
	@Test
	public void getVehicleByKeyWord() {
		
	}
}
