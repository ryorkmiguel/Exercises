/**
 * 
 */
package com.srccodes.examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author yorkmiguel
 * 
 * Hangman
 * 
 * Select one from the list of random words attached. 
 * Show the number of characters as blanks (underscore character, _). 
 * Get user guess character one by one. For each right guess, 
 * replace the blank with the character (could be multiple characters). 
 * For each wrong guess, build the gallows, noose and the hanging 
 * character section by section - two sections for the gallows, 
 * one for the noose, one each for head, torso, each limb. 
 * Total 9 sections. After 9 failures, hanging is complete!
 *
 */
public class Hangman {

	/**
	 * @param args
	 */
	
	// Create a class attributes
	static String wordToGuess;
	char c;
	List<Character> chars;
	List<Character> feedback;
	Stack<String> hangmanPic; 
	List<Character> wrongLetters; 
	int wrongGuess;
	static int guessCount;
	
//	static int code[];
//	static String guess;
//	static int guessArray[];

//	static char feedback[];
	static boolean solved;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Hangman hm = new Hangman();
		hm.play();
		
	}//endMethod Main
	
	/**
	 * <h1>Default constructor</h1>
	 * sets solved  = false
	 * creates the code
	 * @throws FileNotFoundException 
	 */
	public Hangman() throws FileNotFoundException {
		solved = false;
		wrongGuess = 0;
		guessCount = 1;
//		code =  new int[4];
//		guessArray = new int[4];
//		feedback = new char[4];
		
		feedback = new ArrayList<Character>();
		hangmanPic = new Stack<String>();
		wrongLetters = new ArrayList<Character>();
		
		clearState();
		createCode();
	
	}//endDefaultConstructor Mastermind
	
	/**
	 * <h1> clears state
	 * sets feedback array to blank
	 */
	public void clearState() {
	
//		guessArray = new int[4];
//		feedback = new char[4];		
//		guess = "";
		
	}//endMethod ClearState	
	
	public void play() {
		int numTries = 0;
		
		while (numTries < 9 && !solved) {
			numTries++;
			getUserInput();
			generateFeedback();
			doOrDieGuess();
		}		
		
		if (numTries == 9) {
			System.out.println();
			System.out.println("YOU HAVE BEEN HANGED!");
			System.out.println();
			System.out.print("The word was: ");
			
			// Print feedback
			for(int i = 0; i < chars.size(); i++) {
				System.out.print(Character.toUpperCase(chars.get(i)));
			}
			
			//Terminate JVM
	     	System.exit(0);	
		}
		
	}//endMethod play
	
	/**
	 * gets User guess as string
	 */
	public void getUserInput() {
		
		// Declare the object and initialize with 
        // predefined standard input object 
        Scanner sc = new Scanner(System.in); 
        
        System.out.print("Guess #" + guessCount + " Enter a character: ");
   
        // Character input 
        c = sc.next().charAt(0); 
   
        // Print the read value 
 //       System.out.println("c = "+c); 
        guessCount++;
		
	}//endMethod getUserInput
		
	/** 
	 *  Yes or No to Do or Die Guess
	 */
	public void doOrDieGuess() {
		Scanner scan = new Scanner(System.in);
		System.out.print(":X Do you to guess the answer :X (Y/N) ?: ");
	    String YorNAnswer = scan.nextLine(); 
	    
	    switch (YorNAnswer)
	    {
	    case "Y": readFinalGuess();
	    case "y": readFinalGuess();
	             break;
	    case "N":
	    case "n"://exit from program;
	             break;

	    default :
	             System.out.println("invalid choice")   ;
	             break;
	    }
		
	    System.out.println();
		
	}//endMethod doOrDieGuess
	
	/** 
	 *  Yes or No to Do or Die Guess
	 */
	public void readFinalGuess() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Type in Final Guess: ");
	    String guessAnswer = scan.nextLine(); 		
	    
	    ArrayList<Character> chrFinalAnswer = new ArrayList<Character>();
	    
	    for (int i = 0; i < guessAnswer.length(); i++) {
			chrFinalAnswer.add(guessAnswer.charAt(i));
		}
	    
	    
	    int finalCorrect = 0;
        
        for (int i = 0; i < chrFinalAnswer.size(); i++) {
        	
        	char chrFinaAnswer = chrFinalAnswer.get(i);
        	char chrChars = chars.get(i);
        	
            if (chrFinaAnswer == chrChars) {
            	finalCorrect++;
            }
            else {
            	solved = false;
            }
        }	
        
      //if total correct = total number in array then solved
        if (finalCorrect == chars.size()) {
        	solved = true;
        }
        
        if (solved) {
        	System.out.println(); 
			System.out.println("SUCCESS!"); 
			System.out.println("You guessed the word correctly!");
			System.out.println(); 
			
			for (int i = 0; i < feedback.size(); i++) {
	            char value = feedback.get(i);
	            System.out.print(value + " ");
	        }
        }
		else {
			System.out.println();
			System.out.println("WRONG ANSWER!");
			System.out.println(":X YOU HAVE BEEN HANGED! :X");
			System.out.println();
			System.out.print("The word was: ");
			
			// Print feedback
			for(int i = 0; i < chars.size(); i++) {
				System.out.print(Character.toUpperCase(chars.get(i)));
			}	
			
		}
		
	     //Terminate JVM
	     System.exit(0);
		
	}//endMethod readFinalGuess
	
	/**
	* creates the code for the user to guess
	 * @throws FileNotFoundException 
	*/
	public void createCode() throws FileNotFoundException {
		
	//	Scanner sc = new Scanner(new File(/Users/yorkmiguel/develroot/JavaExamples/src/com/srccodes/examples/100 random words.txt));
		Scanner sc = new Scanner(new File("/Users/yorkmiguel/develroot/JavaExamples/src/com/srccodes/examples/100 random words kids.txt"));
		List<String> randomWords = new ArrayList<String>();
		while (sc.hasNextLine()) {
		  randomWords.add(sc.nextLine());
		}
		
//		System.out.println(lines);

//		String[] arr = lines.toArray(new String[0]);
		
		Random rand = new Random();
	    String wordToGuess = randomWords.get(rand.nextInt(randomWords.size()));
		
//	    System.out.println(wordToGuess);
	    
//		wordToGuess = "coordinated";
		
		chars = new ArrayList<Character>(wordToGuess.length());
//		feedback = new ArrayList<Character>(wordToGuess.length());
		
		for (int i = 0; i < wordToGuess.length(); i++) {
			chars.add(wordToGuess.charAt(i));
		}
		
//		System.out.print(chars);
		
		System.out.println();
		
		System.out.println("WELCOME TO HANGMAN!");
		System.out.println("You have 9 TRIES to guess the WORD.");
		System.out.println("You can guess the ANSWER but if you are WRONG, GAME OVER!");

		System.out.println();
		
		for(int i = 0; i < chars.size(); i++) {
			System.out.print("_ ");
		}
		
		System.out.print("Guess this word (" + chars.size() + " letters long)");
		System.out.println();
		System.out.println();	
		    
	    }//endMethod CreateCode
		
	/**
	* generates hangman graphic feedback based on user input
    * generates letter feedback based on user input
    */
	public void generateFeedback() {
			//feedback array shows the letters guessed right
			//chars array shows all of the letters of the word to be guessed
			
			//if feedback array is empty, load it with '_'
			if(feedback.isEmpty()){
				for(int i = 0; i < chars.size(); i++) {	
					feedback.add('_');
				}	
			}
			
			//if letter guessed is in chars array, update with letter or letters
			boolean correctGuess = false;
			
			for(int i = 0; i < chars.size(); i++) {
				
				if(chars.get(i) == c) {
					feedback.set(i,c);
					correctGuess = true;
				}
			}

			System.out.println();	        
	        System.out.println();	
	        
	        //Check letter for letter how many correct
	        int totalCorrect = 0;
	        
	        for (int i = 0; i < chars.size(); i++) {
	        	
	        	char chrFeedback = feedback.get(i);
	        	char chrChars = chars.get(i);
	        	
	            if (chrFeedback == chrChars) {
	            	totalCorrect++;
	            }
	        }	
	        
//	        System.out.println("TotalCorrect = " + totalCorrect);
	        
	        //if total correct = total number in array then solved
	        if (totalCorrect == chars.size()) {
	        	solved = true;
	        }
	        
	        if (solved) {
	        	System.out.println(); 
				System.out.println("SUCCESS!"); 
				System.out.println("You guessed the word correctly!");
				System.out.println(); 
				
				for (int i = 0; i < feedback.size(); i++) {
		            char value = feedback.get(i);
		            System.out.print(value + " ");
		        }
			
		     	//Terminate JVM
		     	System.exit(0);
	        }
			
			System.out.println();
//			System.out.println("wrongGuess = " + wrongGuess);
//			System.out.println();
			
//			String guess31 = "  _______          "; 
			String guess33 = " |       |         "; //guess3   09 noose
			String guess32 = " |       |         "; //3	       10 noose
			String guess41 = " |       O         "; //guess4   11 head
			String guess51 = " |       |         "; //guess5   12 body 
			String guess61 = " |      /|         "; //guess6   13 arm
			String guess71 = " |      /|\\       "; //guess7   14 arm
			String guess81 = " |       /         "; //guess8   15 left leg 
			String guess91 = " |       /\\       "; //guess8 2 16 legs
//			String guess12 = " |                 "); 
//			String guess11 = " __________________ "); 
			
			String guess31 = " _________          "; //guess3	08 top
			String guess26 = " |                  "; //guess2	07 pole
			String guess25 = " |                  "; //2		06 pole
			String guess24 = " |                  "; //2		05 pole
			String guess23 = " |                  "; //2		04 pole
			String guess22 = " |                  "; //2		03 pole
			String guess21 = " |                  "; //2		02 pole
			String guess11 = " __________________ "; //guess1   01 base
			
			
			//if no current guess is not matched print
			if (!correctGuess) {
	        //	System.out.println(c + " is not in the word.");
	        	wrongGuess++;
	        }
			
			switch(wrongGuess) {
			  case 1:  //guess1 base
				  hangmanPic.push(guess11);
			    break;
			  case 2: //guess2 pole
				  hangmanPic.push(guess21);
				  hangmanPic.push(guess22);
				  hangmanPic.push(guess23);
				  hangmanPic.push(guess24);
				  hangmanPic.push(guess25);
				  hangmanPic.push(guess26);
			    break;
			  case 3: //guess3 top & noose
				  hangmanPic.pop();
				  hangmanPic.pop();
				  hangmanPic.push(guess32);
				  hangmanPic.push(guess33);
				  hangmanPic.push(guess31);  //top
			    break; 
			  case 4: //guess4 head
				  hangmanPic.pop();
				  hangmanPic.pop();
				  hangmanPic.pop();
				  hangmanPic.pop();
				  hangmanPic.push(guess41);  //head
				  hangmanPic.push(guess32);
				  hangmanPic.push(guess33);
				  hangmanPic.push(guess31);  //top
			    break;    
			  case 5: //guess5 body
				  hangmanPic.pop();
				  hangmanPic.pop();
				  hangmanPic.pop();
				  hangmanPic.pop();
				  hangmanPic.push(guess51);  //body only
				  hangmanPic.push(guess41);  //head
				  hangmanPic.push(guess32);
				  hangmanPic.push(guess33);
				  hangmanPic.push(guess31);  //top
			    break;
			  case 6: //guess6 body + left arm
				  hangmanPic.pop();
				  hangmanPic.pop();
				  hangmanPic.pop();
				  hangmanPic.pop();
				  hangmanPic.pop();
				  hangmanPic.push(guess61);  //body + left arm
				  hangmanPic.push(guess41);  //head
				  hangmanPic.push(guess32);
				  hangmanPic.push(guess33);
				  hangmanPic.push(guess31);  //top
			    break;
			  case 7: //guess7 body + 2 arms
				  hangmanPic.pop();
				  hangmanPic.pop();
				  hangmanPic.pop();
				  hangmanPic.pop();
				  hangmanPic.pop();
				  hangmanPic.pop();
				  hangmanPic.push(guess71);  //body + left arm + right arm
				  hangmanPic.push(guess41);  //head
				  hangmanPic.push(guess32);
				  hangmanPic.push(guess33);
				  hangmanPic.push(guess31);  //top
			    break;
			  case 8: //guess8 left leg
				  hangmanPic.pop();
				  hangmanPic.pop();
				  hangmanPic.pop();
				  hangmanPic.pop();
				  hangmanPic.pop();
				  hangmanPic.pop();
				  hangmanPic.push(guess81);  //left leg
				  hangmanPic.push(guess71);  ///body + left arm + right arm
				  hangmanPic.push(guess41);  //head
				  hangmanPic.push(guess32);
				  hangmanPic.push(guess33);
				  hangmanPic.push(guess31);  //top
			    break;
			  case 9: //guess9 left leg  
			      hangmanPic.pop();
				  hangmanPic.pop();
				  hangmanPic.pop();
				  hangmanPic.pop();
				  hangmanPic.pop();
				  hangmanPic.pop();
				  hangmanPic.push(guess91);  //left leg + right leg
				  hangmanPic.push(guess71);  //body + left arm
				  hangmanPic.push(guess41);  //head
				  hangmanPic.push(guess32);
				  hangmanPic.push(guess33);
				  hangmanPic.push(guess31);  //top
			    
			  default:
				  System.out.println("NONE WRONG");
			}
			
			
			System.out.println();
			/** 
			 *  FEEBACK
			 *  1) print hangman pic
			 *  2) print word result
			 *  3) print guessed letters
			 */
	        System.out.println("HANGMAN PIC"); 
	        System.out.println();
	        
	        //Print hangman picture array
	        for (int i = hangmanPic.size() - 1; i >= 0; i--) {
	        	System.out.println(hangmanPic.get(i));
	        }
	        
	        System.out.println();
	        
	        //print correct letters + underscores
	        for (int i = 0; i < feedback.size(); i++) {
	            char value = feedback.get(i);
	            System.out.print(value + " ");
	        }
	        
	        System.out.println();
	        
	        boolean matched = false;
	        if (!correctGuess) {
	        	System.out.println("Sorry, " + c + " is not in the word");
	        	for (int i = 0; i < wrongLetters.size(); i++) {
	        		if(wrongLetters.get(i) == 'c') {
	        			matched = true;
	        		}
			    }
		    }
	        
	        if(!matched && !correctGuess) {
	        	wrongLetters.add(c);
	        }
	        	
	        System.out.print("Letters Chosen: ");
	        
	      //print incorrect letters 
	        for (int i = 0; i < wrongLetters.size(); i++) {
	            char value = wrongLetters.get(i);
	            System.out.print(value + " ");
	        }
	        
	        System.out.println();
	        System.out.println();

			
//			System.out.println("   _______          "); //guess4
//			System.out.println("  |                 "); //guess3
//			System.out.println("  |                 "); //3
//			System.out.println("  |                 "); //3
//			System.out.println("  |                 "); //guess2
//			System.out.println("  |                 "); //2
//			System.out.println("  |                 "); //2
//			System.out.println(" __________________ "); //guess1
			
//			System.out.println(); 

//			System.out.println("   _______          "); 
//			System.out.println("  |       |         "); //guess3
//			System.out.println("  |       |         "); // 
//			System.out.println("  |       O         "); //guess4
//			System.out.println("  |     //|\\       "); //guess5 6 7
//			System.out.println("  |     //\\        "); //guess8 9
//			System.out.println("  |                 "); 
//			System.out.println(" __________________ "); 	
			
			
		
		}//endMethod generateFeedback


	}//endClass Hangman	
	

		
		
		
		
		

