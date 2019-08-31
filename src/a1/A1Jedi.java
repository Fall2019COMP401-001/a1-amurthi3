package a1;

import java.util.Scanner;

public class A1Jedi {

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
		int[] totalItemsBought = new int[numStoreItems];
		
		//Declares arrays to hold data about items bought by a customer
		int[] itemQuantities;
		String[] itemsBought;
		int[] numCustomersBought = new int[numStoreItems];
		
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
			
			/*Creates and initializes an array with the number of each item in the store
				a customer bought*/
			int[] customerItemsBought = findItemsBought(itemQuantities, itemsBought, itemNames);
			
			/*Adds the number of each item a customer bought to the total number of
				items bought and increments the number of customers who bought each item*/
			for(int j = 0; j < totalItemsBought.length; j++)
			{
				if (customerItemsBought[j] > 0)
				{
					totalItemsBought[j] += customerItemsBought[j];
					numCustomersBought[j] ++;
				}
			}
		}
		
		//Prints the number of each type of item bought and the number of customers buying it
		for(int i = 0; i < numStoreItems; i++)
		{
			if(totalItemsBought[i] > 0)
			{
				System.out.println(numCustomersBought[i] + " customers bought " + 
									totalItemsBought[i] + " " + itemNames[i]);
			}
			else
			{
				System.out.println("No customers bought " + itemNames[i]);
			}
		}
		
		scan.close();
	}
	
	//Finds the number of each type of item in the store a customer bought
	public static int[] findItemsBought(int[] itemQuantities, String[] itemsBought,
										String[] itemNames)
	{
		int[] customerBuys = new int[itemNames.length];
		for (int i = 0; i < itemNames.length; i++)
		{
			for (int j = 0; j < itemsBought.length; j++)
			{
				if (itemNames[i].equals(itemsBought[j]))
				{
					customerBuys[i] += itemQuantities[j];
				}
			}
		}
		return customerBuys;
	}
}
