/**
 * 
 */
package com.srccodes.examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yorkmiguel
 *
 */
public class BinarySearch {

	/**
	 * @param args
	 *  Java program to implement Binary Search for strings
	 *  
	 *  Java String compareTo() method is used for comparing two strings lexicographically. 
	 *  Each character of both the strings is converted into a Unicode value for comparison. 
	 *  If both the strings are equal then this method returns 0 else it returns positive or negative value. 
	 *  The result is positive if the first string is lexicographically greater than 
	 *  the second string else the result would be negative.
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(new File(/Users/yorkmiguel/develroot/JavaExamples/src/com/srccodes/examples/100 random words.txt));
		//	Scanner sc = new Scanner(new File("/Users/yorkmiguel/develroot/JavaExamples/src/com/srccodes/examples/100 random words kids.txt"));
			Scanner sc = new Scanner(new File("/Users/yorkmiguel/develroot/JavaExamples/src/com/srccodes/examples/100 random words.txt"));
			
			List<String> randomWords = new ArrayList<String>();
			while (sc.hasNextLine()) {
			  randomWords.add(sc.nextLine());
			}
		
			System.out.println(randomWords);
		
//		String[] arr = { "contribute", "geeks", "ide", "practice"}; 
        String x = "zippy"; 
//        int result = binarySearch(arr, x); 
        
        String[] arrString = randomWords.toArray(new String[0]); 
        
        int result = binarySearch(arrString, x); 
  
        if (result == -1) 
            System.out.println("Element not present"); 
        else
            System.out.println("Element found at "
                              + "index " + result); 

	}
	// Returns index of x if it is present in arr[], 
    // else return -1 
    static int binarySearch(String[] arr, String x) 
    { 
        int l = 0, r = arr.length - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
  
            int res = x.compareTo(arr[m]); 
  
            // Check if x is present at mid 
            if (res == 0) 
                return m; 
  
            // If x greater, ignore left half 
            if (res > 0) {
                l = m + 1; 
            System.out.println("l " + l);
            System.out.println("r " + r);
            System.out.println();
            }
            // If x is smaller, ignore right half 
            else
                r = m - 1; 
        } 
  
        return -1; 
    } 

}
