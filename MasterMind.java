/**
 * 
 */
package com.srccodes.examples;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


/**
 * @author yorkmiguel
 *
 */
public class Mastermind {

	/**
	 * @param args
	 */
	
	// Create a class attributes
	static int code[];
	static String guess;
	static int guessArray[];
	static int guessCount = 1;
	static char feedback[];
	static boolean solved;
//	static ArrayList<int[]> historyList = new ArrayList<int[]>();
	
	public static void main(String[] args) {
		Mastermind mm = new Mastermind();
		mm.play();

	}//endMain
	
	/**
	 * <h1>Default constructor</h1>
	 * sets solved  = false
	 * creates the code
	 */
	public Mastermind() {
		solved = false;
		code =  new int[4];
		guessArray = new int[4];
		feedback = new char[4];
		clearState();
		createCode();
	
	}//endDefaultConstructor Mastermind
	
	/**
	 * <h1> clears state
	 * sets feedback array to blank
	 */
	public void clearState() {
	
		guessArray = new int[4];
		feedback = new char[4];		
		guess = "";
		
	}//endMethod ClearState
	
	public void play() {
		int numTries = 0;
		
		System.out.println("This is MasterMind!");
		System.out.println("Guess the 4 Digit Number");
		System.out.println("b = number is in the right order");
		System.out.println("w = number is not in the correct order");
		System.out.println("You have 10 tries");
		System.out.println();	
		
		while (numTries < 12 && !solved) {
			numTries++;
			getUserInput();
			parseUserInput();
			generateFeedback();
		}
		
		if (numTries == 12) {
			System.out.println();
			System.out.println("YOU LOSE!");
			System.out.println();
			System.out.print("The number was ");
			
			// Print feedback
		    for (int i=0; i<code.length; ++i) 
		    	System.out.print(" " + code[i]); 
			
			//Terminate JVM
	     	System.exit(0);
			
		}
		
	}//endMethod play
	
	/**
	 * gets User guess as string
	 */
	public void getUserInput() {
		
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.print("Enter 4 unique numbers (1-9): ");

	    guess = myObj.nextLine();  // Read user input
		
	}
	
	/** 
	 * converts the string into integer and breaks into individual digits
	 */
	public void parseUserInput() {
        String delimiter = "";
        //splits guess String into a String array
        String[] arrIntegerStrings = guess.split(delimiter);
        // Creates integer array
//        guessArray = new int[arrIntegerStrings.length];
        //Parses the integer for each string
        for (int i = 0; i < guessArray.length; i++) {
//            System.out.print(arrIntegerStrings[i] + " ");
        	guessArray[i] = Integer.parseInt(arrIntegerStrings[i]);
//        	System.out.println(guessArray[i]);
        }
        
        
	}//endMethod parseUserInput
        
    /**
    * creates the code for the user to guess
    */
    public void createCode() {
    	
    	Integer[] intArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8 , 9};
	    /* Remember: If you define the array like this:
	     * int[] array = new int[]{1, 2, 3, 4}; then the below 
	     * method won't work as it doesn't work for primitive types
	     */
     	    List<Integer> guessList = Arrays.asList(intArray);

	    // Shuffling list elements
	    Collections.shuffle(guessList);
	    
	    List<Integer> listToGuess = guessList.subList(0, 4);
	
	    // ArrayList to Array Conversion 
        for (int i =0; i < listToGuess.size(); i++) {
            code[i] = listToGuess.get(i);
 //       	System.out.print(code[i]);	
        }
        System.out.println();
	    
    }//endMethod CreateCode
       
    /**
	 * generates string of 'b' and 'w' to let user know 
	 * how the input was evaluated
	 */
	public void generateFeedback() {
	// on 4 'b', solved = true
		
//		int[] code = {1,2,3,4};
		int countB = 0;
		int countW = 0;
//		int numOfWhites = 0;
		feedback = new char[4];		
		
		for (int i = 0; i < code.length; i++){
			
			if(code[i] == guessArray[i]) {
				feedback[i] = 'b';
				countB++;
			}
			else {
				for (int j = 0; j < code.length; j++) {
					if(code[i] == guessArray[j]) {
						feedback[i] = 'w';
						countW++;
					}
				}
			}
		}
		
	        
//		System.out.println("count B " + countB); 
//		System.out.println("count W " + countW); 

//		numOfWhites = countW - countB;
//		System.out.println("num of whites " + numOfWhites); 
		
		//4 b's = Success!
		if(countB == 4) {
			solved = true;
		}
		
		if (solved) {
			System.out.println(); 
			System.out.println("SUCCESS!"); 
			System.out.println("You chose the correct numbers in the correct sequence!"); 
			System.out.print("Guess #" + guessCount + ": ");
			
			// load b's
			for (int i = 0; i < countB; i++){
				feedback[i] = 'b';
			}
			
			for (int i = 0; i < guessArray.length; i++){
				System.out.print(guessArray[i]);
			}
			// Print feedback
		    for (int i=0; i<feedback.length; ++i) 
		    	System.out.print(" " + feedback[i]); 
	     		System.out.println();
	     		
	     	//Terminate JVM
	     	System.exit(0);
		}
		
		//START PRINTING USER FEEDBACK
		System.out.print("Guess #" + guessCount + ": "); 
		guessCount++;
		
		// load b's
//		for (int i = 0; i < countB; i++){	
//			feedback[i] = 'b';
//		}
		
		//load w's
//		for (int i = countB; i < numOfWhites; i++){
//			feedback[i] = 'w';
//		}
	     	
	     //Print User Guess
		for (int i = 0; i < guessArray.length; i++){
				System.out.print(guessArray[i]);
		}
		
		//Sorting the chars
//		Arrays.sort(feedback);
//	    for (char ch: feedback){
//	       System.out.println(ch);
//	    }
		
		// Print feedback
	    for (int i=0; i<feedback.length; ++i) {
	    	if (feedback[i] == 'b') {
	    	    	System.out.print(" " + feedback[i]);
	    	}
	    	
	    }
     	
	    for (int i=0; i<feedback.length; ++i) {
	    	if (feedback[i] == 'w') {
	    	    	System.out.print(" " + feedback[i]);
	    	}
	    	
	    }
	    
	    System.out.println(); 
     		
     	//store in history
//     	historyList.add(guessArray);
     	
//     	for (int index = 0; index < historyList.size(); index++) {
//     	   System.out.println(historyList.get(index));
//     	 }
 
	}//endMethod generateFeedback


}//endClass Mastermind
