package edu.seminolestate.managepurchases;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Scanner;

import edu.seminolestate.manageparts.Part;
import edu.seminolestate.manageparts.PurchasedPart;
/*
 * Nick Wetherington	
 * 6/29/2021
 * The purpose of this assignment is to use exceptions, objects, and text file input and file output. 
 * The application will allow the user to enter data about purchases and store that data in a text file
 */
public class ManagePurchases {
	/*
	 * The data must be written to a relative file location using 
	 * the file name purchases.txt. Make this file name a class 
	 * constant and use the constant in your code wherever 
	 * necessary (instead of purchases.txt). 
	 */
	private static final String FILE_NAME = "purchases.txt";
	//Create an ArrayList to store Purchase objects.
	private static ArrayList<Purchases> purchases;
	
	private static Scanner keyboard = new Scanner(System.in);
	private static final int ADD_PURCHASE = 1;
	private static final int DISPLAY_ALL_PURCHASES = 2;
	private static final int EXIT = 3;
	
	public static void main(String[] args) {
		purchases = new ArrayList<Purchases>();		
		File file = new File(FILE_NAME);
		
		if (file.exists()) {
			/*read each piece of data for an object, create the Purchase object,
			 *  and store the Purchase object into the ArrayList.
			 *  If the file doesn't exist just continue with an empty ArrayList.
			 */
		}
		/*
		 * When the application first starts check to see if the 
		 * purchases.txt file exists. If it does, read each piece of 
		 * data for an object, create the Purchase object, 
		 * and store the Purchase object into the ArrayList. If 
		 * the file doesn't exist just continue with an empty ArrayList.
		 */
		
		int response;
		do {
			response = menu();
			switch (response){
			default:
				System.out.println("Invalid value. Enter a value 1-3");
			
			case ADD_PURCHASE:
				System.out.println("Enter a product name:");
				String productName = keyboard.next();
				System.out.println("Enter a store name:");
				String storeName = keyboard.next();
				System.out.println("Enter a date (like 6/23/2016)");
				String purchaseDate = keyboard.next();
				System.out.println("Enter a cost:");
				double cost = keyboard.nextDouble();
				
				 if ( purchases.size() >0 )
					{
						for (int i=0; i < purchases.size(); i++)
						{
							Purchases purchase = purchases.get(i);
							Purchases pp = new Purchases(productName, storeName, 
									purchaseDate, cost);
							purchases.add(pp);
							}
					}
					
					
				/*
				 * When the user chooses menu option 1, prompt for a product 
				 * name, a store name, purchase date, and a cost. Edit these 
				 * values such that: 
				 * 		the product name cannot have a length less than one; 
				 * 		the store name cannot have a length less than one; 
				 * 		the purchase date cannot be null; 
				 * 		the cost cannot be less than zero. 
				 * Edits are done in the 'get' methods called from this method. 
				 * Values are not returned until valid.
				 * If the data is valid, create a Purchase object and store 
				 * it in the ArrayList.
				 */
				
				
				
				break;
				
			case DISPLAY_ALL_PURCHASES:
				
				if (purchases.isEmpty())
					System.out.println("There are no purchases");
				else {
					for (int i=0; i < purchases.size(); i++)
					{
						System.out.println(purchases.get(i).toString());
					}
				}
				/*
				 * When the user chooses menu option 2, display all the Purchase 
				 * objects in the ArrayList using the toString method of the 
				 * Purchase class.
				 */
									
				break;
			case EXIT:
				/*
				 * When the user chooses menu option 3, check to see if the 
				 * ArrayList has any Purchase objects in it. If it does, write 
				 * the data from each object to a text file. Then display the 
				 * message "Thank you for using the Purchase Tracker" 
				 * and end the application.
				 */
				if (purchases.size() > 0) {
					writeFileFromArrayList();
				}

				System.out.println("Thanks for using the purchases manager.");
			}
		} while (response != EXIT);	
	}
	
	/*
	 * Remember to write the Purchase data as text data to the file. 
	 * I recommend the following to write the data.
	 *  For each Purchase object in the ArrayList, 
	 *  	- call the get method for the product name and write this as 
	 *  		a line to the file; 
	 *  	- call the get method for store name and write this as a line 
	 *  		to the file; 
	 *  	- call the get method for the purchase date, convert it to a 
	 *  		string and write this as a line to the file; 
	 *  	- call the get method for the cost, convert this to a String, and 
	 *  		write this as a line to the file. 
	 *  In this design, each object will create four lines of text data in 
	 *  the output file.
	 */
	public static void writeFileFromArrayList() {
		
	}
	
	/*
	 * To read the file I recommend the following. Each set of four 
	 * lines in the file are required to create a Purchase object. 
	 * As long as the file has more data to read, 
	 * 		- read a line and consider this the product name; 
	 * 		- read the next line and consider this the store name; 
	 * 		- read the next line and consider this the purchase date; 
	 *              convert this string version of the purchase date 
	 *              to a LocalDate object; 
	 *     	- read the next line and consider this the cost; convert 
	 *     			this String to a double. 
	 * Use these four pieces of data to instantiate a Purchase object. 
	 * Put the Purchase object into the ArrayList. 
	 * Continue processing the next four lines of data from the file, if any.
	 */
	public static void loadArrayListFromFile(){

		
	}
	
	/*
	 * Display a menu that has choices for: 
	 * 1 - Add a purchase; 2 - Display all purchases; 3 - Exit. 
	 * Display an error message and repeat the menu if some other 
	 * value is entered. Catch an exception if letters instead of 
	 * numbers are entered.
	 */
	public static int menu(){
		int userResponse = 0;
		do {
			System.out.println("Enter your choice:");
			System.out.println("1. Add a purchase");
			System.out.println("2. List purchases");
			System.out.println("3. Exit");
			userResponse = keyboard.nextInt();
		}
		while (userResponse < 1 || userResponse >3);
		/*
		 * Redisplay the menu if an invalid value (not 1 through 3) is 
		 * entered and continue the application.
		 */
			return userResponse;
	}
	
	/*
	 * This method gets a line of text from user and converts it to 
	 * a LocalDate object. The LocalDate object is then returned to 
	 * whatever method asked for it. This method will keep looping and 
	 * asking for a valid date until it gets one!
	 */
	public static LocalDate getDate(){
		
	}
	
	/*
	 * This method gets a line of text from user (a String object). The only 
	 * edits are for null or empty input. Null can't be generated from keyboard 
	 * input (hard code a test) but an empty string can be generated by just 
	 * hitting the ENTER key w/o entering any data. This method will keep looping 
	 * and asking for a valid String until it gets one!
	 */
	public static  String getString(String prompt)throws IllegalPurchaseArgumentException {
		
		//is this how this is supposed to go??
		try {
			method2();
			}
			catch (IllegalPurchaseArgumentException ex) {
			throw new IllegalPurchaseArgumentException("New info from method1", ex);
		
			}
	
	/*
	 * This method gets a line of text from user (a String object) and 
	 * converts it to a double. The only edits are numeric characters must 
	 * be entered and the converted value must be > 0. This method will keep 
	 * looping and asking for a valid double until it gets one!
	 */
	public static double getDouble(String prompt){
		
		
	}
}
