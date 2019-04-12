/**
 * 
 */
package com.srccodes.examples;

/**
 * @author yorkmiguel
 * 1 1 2 3 5 8 13 21 34 55 89 144 ... fibonacci sequence
 * F(0) = 1
 * F(1) = 1
 * F(n) = F(n-1) + F(n-2)
 * Golden Ratio (phi) = F(n) / F(n-1) where n>34
 * 1. Write function to calculate nth Fibonacci number
 * 2. Calculate Golden Ratio by getting F(34) and F(35)
 */
public class FibonacciRecursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		    int n = 11; 
		    System.out.println(fib(n));
		    System.out.println();
		    
		    //Golden Ratio
		    System.out.println("Calculate Golden Ratio:");
		    n = 34;
		    System.out.println("n = 34; 34th Fibonacci is " +  fib(n));
		    
		    n = 35;
		    System.out.println("n = 35; 35th Fibonacci is " +  fib(n));
		   
	}
	
	static int fib(int n) 
    { 
    if (n <= 1) 
       return n; 
    return fib(n-1) + fib(n-2); 
    } 

}
