package calculator;

import java.awt.Dialog;
import java.util.Scanner;

/**
 * 
 * @author ricardo
 *
 *	Creating a calculator. Here is where the operations are working(PEMDAS).
 *	Need to include exponents later.
 *	
 */
public class Calculator {
		
	/**
	 * 
	 * @param number, the equation that we want to solve as a string
	 * @return double, the solution to the equation as a double because of division so we don't loose decimals
	 */
	public double DivideNConquer(String number) {
		number = number.replaceAll(" ", "");
		Double total = 0.0;
		
		
		/**
		 * Using PEMDAS we do parentheses first. In here we detect parentheses and solve that first.
		 */
		if(number.contains("(")) {
			for(int i = 0; i < number.length(); i++) {
				if(number.charAt(i) == '(') {
					int count = 1;
					for(int j = i +1; j <number.length(); j++) {
						if(number.charAt(j) == '(') {
							count++;
						}else if(number.charAt(j) == ')') {
							count--;
						}
						if(count == 0) {
							number = number.substring(0,i) + DivideNConquer(number.substring(i+1, j)) + number.substring(j+1, number.length());
							break;
						}
						
					}
				}
			}
		}
		
		/**
		 * After parentheses we solve multiplication and division. In this case we multiply or divide two numbers and replace the answer on the number string.
		 * 
		 */
		int index = 0;
		if(number.contains("*") || number.contains("/")) {
			for(int i = 0; i< number.length(); i++) {
				
				if(number.charAt(i) == '*' || number.charAt(i) =='/') {
					for(int j = i +1 ; j < number.length(); j++ ) {
						if(number.charAt(j) == '*' || number.charAt(j) =='/' || number.charAt(j) == '+' || number.charAt(j) =='-' || j == number.length()-1) {
							int edge = 0;
							if(j == number.length()-1) {
								edge = 1;
							}
							if(number.charAt(i) == '*') {
								number = number.substring(0, index) + (Double.parseDouble(number.substring(index,i)) * Double.parseDouble(number.substring(i+1, j+edge))) + number.substring(j+edge);
							}else if(number.charAt(i) == '/') {
								number = number.substring(0, index) + (Double.parseDouble(number.substring(index,i)) / Double.parseDouble(number.substring(i+1, j+edge))) + number.substring(j+edge);
							}
							i = index;
							break;
						}
					}
					
				}else if(number.charAt(i) == '+' || number.charAt(i) =='-') {
					index = i;
				}
				
			}
		}
		
		/**
		 * if we don't detect any other operation then we return the number
		 */
		if(!number.contains("-") && !number.contains("+") && !number.contains("*") && !number.contains("/") ) {
			return Double.parseDouble(number);
		}
		/**
		 * returning negative or positive number if its the last number.
		 */
		if((number.charAt(0) == '-' || number.charAt(0) == '+') && (!number.substring(1, number.length()).contains("-") && !number.substring(1, number.length()).contains("+"))) {		
			return Double.parseDouble(number);
		}
		/**
		 * Lastly, this is for addition and subtraction. We use recursion because with addition or subtraction the order doesn't matter as long as the signs are kept.
		 * For example subtracting 4 is the same as adding -4. 
		 */
		for(int i = 1; i < number.length(); i++) {
			if(number.charAt(i) == '+' || number.charAt(i) == '-') {
				total = DivideNConquer(number.substring(0,i)) + DivideNConquer(number.substring(i,number.length()));
			}
		}	
		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		// Solution, Solve this using recursion, and I think I'm going to divide and conquer
		// on addition and subtraction. Also pay attention to ().
		
		String num = "-6*5*0";
		
		Calculator test = new Calculator();
		
		System.out.println(test.DivideNConquer(num));

	
	}

}
