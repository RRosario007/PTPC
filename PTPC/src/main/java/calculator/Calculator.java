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
	 * @return double, the solution to the equation as a double so we don't loose decimals
	 */
	public double DivideNConquer(String number) {
		
		try {
			number = number.replaceAll(" ", "");
			Double total = 0.0;
			/**
			 * Using PEMDAS we do parentheses first. In here we detect parentheses and solve that first.
			 * We use recursion on the equation inside the parenthesis until there are not more parenthesis.
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
			 * After parentheses we solve multiplication and division. In this case we multiply or divide two numbers.
			 * We replace the two numbers with the solution by using a substring in order to not forget any part of the equation left over.
			 * 
			 */
			int index = 0;
			if(number.contains("*") || number.contains("/")) {
				for(int i = 0; i< number.length(); i++) {
					
					if(number.charAt(i) == '*' || number.charAt(i) =='/') {
						
						for(int j = i +1 ; j < number.length(); j++ ) {
							if(number.charAt(j) == '-' && j == i +1) {
								System.out.println("TEST");
								j++;
							}
							if(number.charAt(j) == '*' || number.charAt(j) =='/' || number.charAt(j) == '+' || number.charAt(j) =='-' || j == number.length()-1) {
								int edge = 0;
								if(j == number.length()-1) {					
									edge = 1;
								}
								int p = 0;
								if(number.charAt(i) == '*') {
									if(index != 0) {

										p = 1;
									}
									number = number.substring(0, index+p) + (Double.parseDouble(number.substring(index+p,i)) * Double.parseDouble(number.substring(i+1, j+edge))) + number.substring(j+edge);
								}else if(number.charAt(i) == '/') {
									if(index != 0) {
										p = 1;
									}
									number = number.substring(0, index+p) + (Double.parseDouble(number.substring(index+p,i)) / Double.parseDouble(number.substring(i+1, j+edge))) + number.substring(j+edge);
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
		} catch (Exception e) {
			// TODO: handle exception
			
			return Double.NaN;
		}
		
		
	}


}
