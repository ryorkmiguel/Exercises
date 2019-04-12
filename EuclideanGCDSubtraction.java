/**
 * 
 */
package com.srccodes.examples;

/**
 * @author yorkmiguel
 * The most efficient method to find GCD of two numbers
 *
 * Basis:
 *
 * GCD does not change if the larger number is replaced by its difference with the smaller number.
 *
 * This identity is successively used until the two numbers are equal.
 *
 * This new number is the GCD.
 *
 * Natural Language:
 *
 * 1.If either number is zero, return zero
 * 2.If both numbers are equal return either number as GCD
 * 3.Subtract the difference between the two numbers from the larger number
 * 4.Go back to step 2
 */
public class EuclidianGCDSubtraction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 int num1, num2;
	        
	        //Reading the input number
	        num1 = 25;
	        num2 = 10;
	        
	        while (num1 != num2) {
	        	if(num1 > num2)
	                num1 = num1 - num2;
	            else
	                num2 = num2 - num1;
	        }

	        //displaying the result
	        System.out.printf("GCD of given numbers is: %d", num2);
	    }
	}
	
