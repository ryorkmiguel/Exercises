/**
 * 
 */
package com.srccodes.examples;

/**
 * @author yorkmiguel
 * Algorithm on display. Use algorithm to create matrix of primes less than n
 * Use array of size n+1 because 0 is what we start with in counting arrays 
 * and 0 doesn't count
 * Use array of char, i.e. char[]
 * Set array[i] = 'p' if prime, 'c' if composite, 'u' is unmarked, 'n' for N/A (0,1)
 *
 */
public class SieveOfEratosthenes {

	/**
	 * @param args
	 */
	 public static void main(String args[]){ 
	        int n = 30; 
	        System.out.print("Following are the prime numbers "); 
	        System.out.println("smaller than or equal to " + n); 
	        SieveOfEratosthenes g = new SieveOfEratosthenes(); 
	        g.FindPrimes(n); 
	  }//end main
	 
	 void FindPrimes(int n){ 
	        // Create a boolean array "prime[0..n]" and initialize 
	        // all entries it as true. A value in prime[i] will 
	        // finally be false if i is Not a prime, else true. 
	        boolean prime[] = new boolean[n+1]; 
	        
	        for(int i=0;i<n;i++){ 
	            prime[i] = true; 
	        }//end for    
	        
	        for(int p = 2; p*p <=n; p++){ 
	                
	        	// If prime[p] is not changed, then it is a prime 
	            if(prime[p] == true) { 
	                    
	            	// Update all multiples of p 
	                for(int i = p*p; i <= n; i += p){
	                	prime[i] = false;
	                }//end for
	                    
	            } //endif
	                
	        }//endfor
	            
	        // Print all prime numbers 
	        for(int i = 2; i <= n; i++) { 
	        	if(prime[i] == true) { 
	        		System.out.print(i + " ");
	        	}
	        }//endFor
	            
	    }//endMethod FindPrimes
	 
}//endClass SieveOfEratosthenes
