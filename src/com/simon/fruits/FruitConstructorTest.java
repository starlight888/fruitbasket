package com.simon.fruits;

import static org.junit.Assert.*;

import org.junit.Test;

public class FruitConstructorTest {

	@Test
	public void testFruitConstructor() {
		
		/* Create a fruit with some data */
		Fruit fruitObj = new Fruit("Apples", 0.35, 12);
		assertEquals("Apples", fruitObj.getName());
		assertEquals(0.35, fruitObj.getUnitCost(),0.0);
		assertEquals(12, fruitObj.getQuantity());
	}

}
