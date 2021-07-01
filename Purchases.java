package edu.seminolestate.managepurchases;


import java.time.LocalDate;
/*
 * Nick Wetherington	
 * 6/29/2021
 * The purpose of this assignment is to use exceptions, objects, and text file input and file output. 
 * The application will allow the user to enter data about purchases and store that data in a text file
 */
public class Purchases {

	private String productName;
	private String storeName;
	private LocalDate purchaseDate;
	private double cost;
	
	public Purchase(String newProductName, String newStoreName, 
			LocalDate newPurchaseDate, double newCost)
			throws IllegalPurchaseArgumentException {
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String newProductName) {
		
		if (newProductName != null && newProductName.length() > 0)
		productName = newProductName;
		else
			throw new IllegalPurchaseArgumentException (" ");
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String newStoreName) {
		throws IllegalPurchaseArgumentException 
		if (newStoreName != null)
		storeName = newStoreName;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate newPurchaseDate) {
		 if (newPurchaseDate != null)
		purchaseDate = newPurchaseDate;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double newCost) {
		throws IllegalPurchaseArgumentException 
		if (newCost >= 0)
		cost = newCost;
		
	}
	@Override
	public String toString() {
		return getClass() + "productName=" + this.productName + "," + "storeName=" + this.storeName +
				"," + "purchaseDate=" + this.purchaseDate + "," + "cost=" + this.cost;
		
	}	
}
	
	

