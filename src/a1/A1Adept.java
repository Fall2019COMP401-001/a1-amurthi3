package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		//Creates a new scanner object
		Scanner scan = new Scanner(System.in);

		//Finds the number of items in the store
		int numStoreItems = scan.nextInt();
		
		//Creates arrays to hold data about all items in the store
		String[] itemNames = new String[numStoreItems];
		double[] itemPrices = new double[numStoreItems];
		
		//Goes through each item in the store and initializes arrays with their data
		for(int i = 0; i < numStoreItems; i++)
		{
			itemNames[i] = scan.next();
			itemPrices[i] = scan.nextDouble();
		}
		
		//Finds the number of customers
		int numCustomers = scan.nextInt();
		
		//Creates arrays to hold data about all customers
		String[] fNames = new String[numCustomers];
		String[] lNames = new String[numCustomers];
		int[] numsItems = new int[numCustomers];
		double[] customerAmounts = new double[numCustomers];
		
		//Declares arrays to hold data about items bought by a customer
		int[] itemQuantities;
		String[] itemsBought;
		
		//Goes through each customer
		for(int i = 0; i < numCustomers; i++)
		{
			//Initializes arrays holding customer data
			fNames[i] = scan.next();
			lNames[i] = scan.next();
			numsItems[i] = scan.nextInt();
			
			//Creates arrays holding item data for each customer
			itemQuantities = new int[numsItems[i]];
			itemsBought = new String[numsItems[i]];
			
			//Initializes arrays holding item data for each customer
			for(int j = 0; j < numsItems[i]; j++)
			{
				itemQuantities[j] = scan.nextInt();
				itemsBought[j] = scan.next();
				
			}
			
			//Initializes the array holding the total amount spent by each customer
			customerAmounts[i] = findAmount(itemNames, itemPrices,itemQuantities, itemsBought);
		}
		
		//Finds the biggest, smallest, and average amount spent
		int biggestPos = findBiggest(customerAmounts);
		int smallestPos = findSmallest(customerAmounts);
		System.out.println("Biggest: " + fNames[biggestPos] + " " + lNames[biggestPos]
					+ " (" + String.format("%.2f", customerAmounts[biggestPos]) + ")");
		System.out.println("Smallest: " + fNames[smallestPos] + " " + lNames[smallestPos]
					+ " (" + String.format("%.2f", customerAmounts[smallestPos]) + ")");
		System.out.println("Average: " + String.format("%.2f", findAverage(customerAmounts)));
		
		scan.close();
	}
	
	//Finds the total amount spent by a customer
	public static double findAmount(String[] storeItems, double[] storePrices,
							int[] customerQuantities, String[] customerTypes)
	{
		double totalPrice = 0;
		for(int i = 0; i < customerTypes.length; i++)
		{
			for(int j = 0; j < storeItems.length; j++)
			{
				if (customerTypes[i].equals(storeItems[j]))
				{
					totalPrice += (storePrices[j] * customerQuantities[i]);
				}
			}
		}
		return totalPrice;
	}
	
	//Finds the customer who spent the most
	public static int findBiggest(double customerAmounts[])
	{
		int biggestPos = 0;
		for (int i = 0; i < customerAmounts.length; i++)
		{
			if (customerAmounts[i] > customerAmounts[biggestPos])
			{
				biggestPos = i;
			}
		}
		return biggestPos;
	}
	
	//Finds the customer who spent the least
	public static int findSmallest(double customerAmounts[])
	{
		int smallestPos = 0;
		for (int i = 0; i < customerAmounts.length; i++)
		{
			if (customerAmounts[i] < customerAmounts[smallestPos])
			{
				smallestPos = i;
			}
		}
		return smallestPos;
	}
	
	//Finds the average amount spent by all customers
	public static double findAverage(double customerAmounts[])
	{
		double customerSum = 0;
		for (int i = 0; i < customerAmounts.length; i++)
		{
			customerSum += customerAmounts[i];
		}
		return customerSum / customerAmounts.length;
	}
}