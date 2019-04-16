/**
 * 
 */
package com.srccodes.examples;

/**
 * 
 */


/**
 * 
 * <h1>InvItem</h1>
 * <p>InvItem is an <em>internal</em> class within FirstClass used for keeping track of inventory items
 * It is used in creating invoices.</p>
 * @author praka
 *
 */
public class InvItem {
/*
 * itemName is the name used for tracking and invoicing
 */
	String itemName;
	/*
	 * itemCost is the cost per unit of the item for invoicing
	 */
	double itemCost;
	/*
	 * itemQty is the quantity of the item on hand (i.e. in inventory)
	 */
	int itemQty;
	/**
	 * 
	 */
	public InvItem() {
		itemName = "";
		itemCost = 0.0;
		itemQty = 0;
	}
	/**
	 * @param itemName
	 * @param itemCost
	 * @param itemQty
	 */
	public InvItem(String itemName, double itemCost, int itemQty) {

		this.itemName = itemName;
		this.itemCost = itemCost;
		this.itemQty = itemQty;
	}
	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * @return the itemCost
	 */
	public double getItemCost() {
		return itemCost;
	}
	/**
	 * @param itemCost the itemCost to set
	 */
	public void setItemCost(double itemCost) {
		this.itemCost = itemCost;
	}
	/**
	 * @return the itemQty
	 */
	public int getItemQty() {
		return itemQty;
	}
	/**
	 * @param itemQty the itemQty to set
	 */
	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}
	
}
