/**
 * 
 */
package com.srccodes.examples;

/**
 * <h1>Invoice Item</h1>
 * <p>This is a line item of the transaction</p>
 * @author praka
 *
 */
public class XactionItem {
	String itemName;
	int itemQty;
	/**
	 * 
	 */
	public XactionItem() {
		itemName="";
		itemQty = 0;
	}
	/**
	 * @param itemName
	 * @param itemQty
	 */
	public XactionItem(String itemName, int itemQty) {
		this.itemName = itemName;
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
