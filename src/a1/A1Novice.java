package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		//Creates a scanner object
		Scanner scan = new Scanner(System.in);

		//Finds the number of customers
		int numCustomers = scan.nextInt();
		
		//Creates arrays to hold customer data
		String[] fNames = new String[numCustomers];
		String[] lNames = new String[numCustomers];
		int[] numItems = new int[numCustomers];
		
		//Declares arrays to hold item data for each customer
		int[] itemQuantities;
		String[] itemNames;
		double[] itemPrices;
		
		//Creates an array to hold the output for all the customers
		String[] outputs = new String[numCustomers];
		
		// Goes through each customer
		for (int i = 0; i < numCustomers; i++)
		{
			//Initialize customer data
			fNames[i] = scan.next();
			lNames[i] = scan.next();
			numItems[i] = scan.nextInt();
			
			//Creates arrays to hold item data for each customer 
			itemQuantities = new int[numItems[i]];
			itemNames = new String[numItems[i]];
			itemPrices = new double[numItems[i]];
			
			//Goes through each item for the current customer
			for (int j = 0; j < numItems[i]; j++)
			{
				//Initializes item data for each customer
				itemQuantities[j] = scan.nextInt();
				itemNames[j] = scan.next();
				itemPrices[j] = scan.nextDouble();
			}
			
			//Combines current customer data with their calculated total price
			outputs[i] = fNames[i].substring(0, 1) + ". " + lNames[i] + ": " + 
							CustomerItems(numItems[i], itemQuantities, itemPrices);
		}
		
		//Prints the output to the console
		for(int i = 0; i < numCustomers; i++)
		{
			System.out.print(outputs[i]);
		}
		
		//Closes scanner object
		scan.close();
		
	}
	
	//Calculates the total price for a single customer
	public static String CustomerItems(int items, int[] quantities, double[] prices)
	{
		double totalPrice = 0;
		for (int i = 0; i < items; i++)
		{
			totalPrice += (quantities[i] * prices[i]);
		}
		return String.format("%.2f%n", totalPrice);
	}
}