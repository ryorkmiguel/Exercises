/**
 * 
 */
package com.srccodes.examples;

import java.util.Scanner;

/**
 * @author yorkmiguel
 * RPN Calculator
 * 
 * 134 * 434 + 3 / 3 * 9 - 4
 * 134 434 * 3 3 / 9 * 4 - -
 * 
 * 134 => op1
 * 434 => op2
 * * -> op1 * op2 => op1        op1 = (134 * 434)
 * 3 => op2
 * 3 => op3
 *  / -> op2 / op3 => op2       op2 = (3 / 3)
 * 9 => op3
 * * -> op2 * op3 => op2        op2 = (3 / 3) * 9
 * 4 -> op3
 * - -> op2 - op3 => op2        op2 = ((3 / 3) * 9 )
 * + -> op1 + op2 => op1
 * print op1
 *
 */
public class myStack {

	double values[];
	int index;
	String inputStr;
	String tokens[];
	double result;
	Scanner in;
	
	public static void main(String[] args) {
		/// create instance
		myStack ms = new myStack();
		// get input string from user
		ms.getInput();
		// parse input into array
		ms.parse(ms.inputStr);
		double result = ms.evaluate();
		// scan array (navigate left to right) iterator i
		//   if ith position is a number, push
		//   if ith position is an operator, pop2, pop1, calculate pop1 operator pop2, push result
		// at end of scan, print whatever is on top of stack
		System.out.println(result);
		// cleanup
		ms.cleanUp();

	}
	
	public myStack() {
		values = new double[20];
		index = 0;
		in = new Scanner(System.in);
	}
	
	public void cleanUp() {
		in.close();
	}
	
	public void getInput () {
		System.out.println("Enter Input: ");
		inputStr = in.nextLine();
		System.out.println("Input = " + inputStr);
	}
	
	public void parse (String s) {
		tokens = s.split(" ");
		for (int i = 0; i < tokens.length; i++) {
		System.out.println("tokens = " + tokens[i]);
		}
	}
	
	public void push (double d) {
	
		values[index++] = d;
		System.out.println(values[0]);

	}
	
	public double pop() {
		return values [--index];
	}
	
	public double evaluate() {
		double retVal = 0.0, op1, op2, calc;
		for (String s: tokens) {
			switch(s.charAt(0)) { // what to do if there are not enough operands in stack?
			case '+':
				if (index < 2) System.out.println("Error");
				else {
					op2 = pop();
					op1 = pop();
					calc = op1 + op2;
					push(calc);
				}
				break;
			case '-':
				op2 = pop();
				op1 = pop();
				calc = op1 - op2;
				push(calc);
				break;
			case '*':
				op2 = pop();
				op1 = pop();
				calc = op1 * op2;
				push(calc);
				break;
			case '/': // what if op2 is 0
				op2 = pop();
				op1 = pop();
				if (op2 ==0)System.out.println("Attempt to divide by zero");
				else {
					calc = op1 / op2;
					push(calc);
				}
				break;
			case '%':
				op2 = pop();
				op1 = pop();
				calc = op1 % op2;
				push(calc);
				break;
			default:
				op1 = Double.parseDouble(s);
				push(op1);
				break;
			}
		}
		if (index > 0)
			retVal = pop();
		return retVal;
	}
	
	

}
