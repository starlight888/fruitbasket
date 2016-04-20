package com.simon.fruits;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class FruitBasketCalculateTest {

	
	private FruitBasket fb;
	
	@Before
	public void setUp() throws Exception {
		fb = new FruitBasket();
		String fruitsFilePath = "c:\\data\\fruits.csv";
		
		try {
			fb.readFruitsList(fruitsFilePath);
		} catch (IOException e) {			
		}
	}

	@Test
	/* Based on data :
	 * fruit,unitcost,quantity
	 * bananas,0.2,4
     * apples,0.15,10
     * oranges,0.3,5
	 * 
	 */
	public void testCalculateTotalCost() {
		double cost = fb.calculateTotalCosts();
		assertEquals(3.8,cost,0.0);
	}

}
