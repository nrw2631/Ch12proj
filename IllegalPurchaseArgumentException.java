package edu.seminolestate.managepurchases;
/*
 * Nick Wetherington	
 * 6/29/2021
 * The purpose of this assignment is to use exceptions, objects, and text file input and file output. 
 * The application will allow the user to enter data about purchases and store that data in a text file
 */
public class IllegalPurchaseArgumentException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public IllegalPurchaseArgumentException() {
		super("DEFAULT TEXT");
	}

	public IllegalPurchaseArgumentException(String msg) {
		super(msg);
	}

}

