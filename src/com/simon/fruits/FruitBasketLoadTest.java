package com.simon.fruits;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class FruitBasketLoadTest {

	@Test
	public void testReadFruitsList() {
		/* Positive testing */
		FruitBasket fb = new FruitBasket();
		String fruitsFilePath = "c:\\data\\fruits.csv";
		
		boolean bool_loadfile = false;
		try {
			bool_loadfile = fb.readFruitsList(fruitsFilePath);
		} catch (IOException e) {
			
		}
		assertEquals(true,bool_loadfile);
	}
	
	@Test
	public void testNoFruitsList() {
		/* Negative testing */
		FruitBasket fb = new FruitBasket();
		String fruitsFilePath = "c:\\data\\fruits-notavail.csv";
		
		boolean bool_loadfile = false;
		try {
			bool_loadfile = fb.readFruitsList(fruitsFilePath);
		} catch (IOException e) {
			
		}
		assertEquals(false,bool_loadfile);
	}

}
