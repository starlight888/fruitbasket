package com.simon.fruits;

/**
 * Fruits class to hold what fruit, unit cost and quantity needed.
 * @author simon
 *
 */
public class Fruit {

	private String name;
	private double unitCost;
	private int quantity;

	public Fruit(String fruitName, double cost, int qty) {
		name = fruitName;
		unitCost = cost;
		quantity = qty;
	}
	
	public String getName() {
		return name;
	}

	public double getUnitCost() {
		return unitCost;
	}

	public int getQuantity() {
		return quantity;
	}
	
	
}
