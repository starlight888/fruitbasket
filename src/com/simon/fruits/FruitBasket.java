package com.simon.fruits;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * @author simon
 *FruitBasket:
 *1. Read in file of fruits
 *2. Total the cost
 *3. Print out the cost
 */
public class FruitBasket {

	private List<Fruit> fruitsList = new LinkedList<>(); 
	private DecimalFormat df2dp = new DecimalFormat("0.00");
	
	/**
	 * 
	 * @param pathFruitsFile This is file containing list of fruits in csv file.
	 * 						 Format is fruit name,unit cost,quantity 
	 * 						 e.g.
	 * 						bananas,0.2,4
	 *						apples,0.15,10
	 *						oranges,0.3,5
	 * @throws IOException
	 */
	public boolean readFruitsList(String pathFruitsFile) throws IOException {
		
		/* try with resource to let Java take care of closing resources*/
		try (BufferedReader br = new BufferedReader(new FileReader(pathFruitsFile))) {
			
			boolean boolSuccess = true;
			
			String currLine = null; 
			String delims = ",";
			
			String fruitName;
			double fruitCost;
			int fruitQty;
			
			/* read first line in which is header */
			currLine = br.readLine(); // do nothing with it
			
			while ((currLine = br.readLine()) != null) {
				// check we have a line
				currLine = currLine.trim();
				if (!currLine.equals("")) {
					String[] fruitLineParts = currLine.split(delims);
					fruitName = fruitLineParts[0];
					try {
						fruitCost = Double.parseDouble(fruitLineParts[1]);
						fruitQty = Integer.parseInt(fruitLineParts[2]);
						Fruit fruit = new Fruit(fruitName, fruitCost, fruitQty);
						fruitsList.add(fruit);
					} catch (NumberFormatException nfex) {
						System.out.println("Failed to parse line: " + currLine);
						System.out.println("Please note format is: fruitname,unit cost,quantity");
						boolSuccess = false;
						break;
					}
				}
				
			}
			
			return boolSuccess;
		}
		
	}
	
	/**
	 * Calculate total cost of fruits held in list
	 * @return
	 */
	public double calculateTotalCosts() {
		double cost = 0.0;
		for (Fruit fruit:fruitsList) {
			cost += fruit.getQuantity()*fruit.getUnitCost();
		}
		return cost;
	}
	
	/**
	 * Show the total cost to 2 decimal places.
	 * @param totalCost
	 */
	public void showTotal(double totalCost) {
		System.out.println("Total cost of fruit basket=" + df2dp.format(totalCost) );
	}
	
	/**
	 * Start of program to create instance if FruitBasket and call its 
	 * methods to collate the list of fruits, calculate total and 
	 * output result.
	 * @param args
	 */
	public static void main(String[] args) {
		
		FruitBasket fbasket = new FruitBasket();
		String fruitsFilePath = "c:\\data\\fruits.csv";	//could be supplied as part of command line param.	
		try {
			if (fbasket.readFruitsList(fruitsFilePath)) {
				double totalCost = fbasket.calculateTotalCosts();
				fbasket.showTotal(totalCost);
			} else {
				System.out.println("Could not calculate total.");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot find " + fruitsFilePath + ".");
			System.out.println("This should be a csv file with format:");
			System.out.println("fruit name,unit cost,quantity");
		}
	}

}
