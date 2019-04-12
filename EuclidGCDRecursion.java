/**
 * 
 */
package com.srccodes.examples;

/**
 * @author yorkmiguel
 * GCD of two numbers is the largest number that divides both of them.
 * A simple way to find GCD is to factorize both numbers and 
 * multiply common factors.
 *
 * 36 = 2 x 2 x 3 x 3
 * 60 = 2 x 2 x 3 x 5
 * 
 * GCD = Mulitplication of common
 * 	   = 2 x 2 x 3
 *     = 12
 *
 * Basic Euclidean Algorithm for GCD 
 * If we subtract smaller number from larger (we reduce larger number), 
 * GCD doesn’t change. 
 * So if we keep subtracting repeatedly the larger of two, 
 * we end up with GCD.    
 * 
 * Now instead of subtraction, if we divide smaller number, 
 * the algorithm stops when we find remainder 0.
 */
public class EuclidianGCDRecursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 10, b = 15, g; 
        g = gcd(a, b); 
        System.out.println("GCD(" + a +  " , " + b+ ") = " + g); 
          
        a = 35; b = 10; 
        g = gcd(a, b); 
        System.out.println("GCD(" + a +  " , " + b+ ") = " + g); 
          
        a = 31; b = 2; 
        g = gcd(a, b); 
        System.out.println("GCD(" + a +  " , " + b+ ") = " + g); 
	}
	
	// extended Euclidean Algorithm 
    public static int gcd(int a, int b) 
    { 
        if (a == 0) 
            return b; 
          
        return gcd(b%a, a); 
    } 

}
