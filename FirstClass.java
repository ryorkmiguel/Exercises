/**
 * 
 */
package com.srccodes.examples;

import java.util.ArrayList;

/**
 * @author yorkmiguel
 *
 */
public class FirstClass {

	/**
	 * @param args
	 */
	
	ArrayList<InvItem> inventory;
	ArrayList<XactionItem> transactions;
	
	/**
	 * 
	 */
	public FirstClass() {
		inventory = new ArrayList<InvItem>();
		transactions = new ArrayList<XactionItem>();
	}
	
	public static void main(String[] args) {
		FirstClass localObject = new FirstClass();
		localObject.createInventory();
		localObject.createTransactions();
		localObject.applyTransactions();
		localObject.createInvoice();

	}
	
	/**
	 * Creating items and placing into inventory
	 */
	public void createInventory() {
		InvItem item1, item2, item3, item4, item5, item6;
		item1 = new InvItem ("Mega Widgets", 10000.0, 30);
		item2 = new InvItem ("Large Widgets", 1000.0, 50);
		item3 = new InvItem ("Medium Widgets", 100.0, 100);
		item4 = new InvItem ("Regular Widgets", 10.0, 150);
		item5 = new InvItem ("Small Widgets", 1.0, 100);
		item6 = new InvItem ("Micro Widgets", 0.1, 500);
		inventory.add(item1);
		inventory.add(item2);
		inventory.add(item3);
		inventory.add(item4);
		inventory.add(item5);
		inventory.add(item6);
	}
	
	/**
	 * Creating transaction line items
	 */
	public void createTransactions() {
		XactionItem item1, item2, item3, item4;
		item1 = new XactionItem("Medium Widgets", 10);
		item2 = new XactionItem("Regular Widgets", 15);
		item3 = new XactionItem("Small Widgets", 12);
		item4 = new XactionItem("Micro Widgets", 30);
		transactions.add(item1);
		transactions.add(item2);
		transactions.add(item3);
		transactions.add(item4);
	}
	
	/**
	 * Apply transactions, i.e. create invoice line items and update inventory quantity
	 */
	public void applyTransactions() {
		for (XactionItem xItem : transactions) {
			InvItem item = findItem(xItem.getItemName());
			item.setItemQty(item.getItemQty() - xItem.getItemQty());
		}
	}
	
	/**
	 * search in inventory for item
	 * @param name
	 * @return
	 */
	public InvItem findItem (String name) {
		InvItem found = null;
		for (InvItem iItem : inventory)
			if (iItem.getItemName().equals(name))
				found = iItem;
		return found;
	}
	
	/**
	 * create invoice
	 * print line items with quantity, description, unit cost, extended cost
	 * keep running total of extended cost
	 * at end of list, print extended cost as sub total
	 * set tax = 10%
	 * set S&H = 5%
	 * print tax and S&H lines
	 * print total = subtotal + tax + S&H
	 * 
	 */
	public void createInvoice() {
		double subtotal = 0.0;
		// header line
		System.out.println("Quantity | Description | Unit Price | Total");
		for (XactionItem xItem : transactions) {
			InvItem item = findItem(xItem.getItemName());
			double extCost = item.getItemCost() * xItem.getItemQty();
			subtotal += extCost;
			System.out.println(xItem.getItemQty() + " | " + item.getItemName() + " | " 
					+ item.getItemCost() + " | " + extCost);
		}
		System.out.println ("Subtotal: " + subtotal);
		double tax = subtotal * 0.1;
		double sh = subtotal * 0.05;
		System.out.println("Tax: "+ tax);
		System.out.println("Shipping & Handling: "+ sh);
		System.out.println("Total: "+ (subtotal+tax+sh));

	}
	
	
	

}
