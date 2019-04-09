/**
 * 
 */
package com.srccodes.examples;

/**
 * @author yorkmiguel
 *
 */
public class TruthTable3 {

	public static void main(String[] args) {

        boolean a, b;

        a = false;

        System.out.println("                  AND     OR     XOR    NOT");
        System.out.println("  a       b     a && b  a || b  a ^ b   !a");
  
        do {

              b = false;

              do {

                    System.out.println(a + "\t" + b + "\t" + (a && b) + "\t" + 
                    (a || b) + "\t" + (a ^ b) + "\t" + (!a));

                    b = !b;

              } while (b); //while b == true;

              a = !a;

        } while (a); //while a == true;

  }

}//end TruthTable3
