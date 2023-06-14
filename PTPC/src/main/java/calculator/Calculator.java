package calculator;

import java.awt.Dialog;
import java.util.Scanner;

public class Calculator {
	
	public double DivideNConquer(String number) {
		number = number.replaceAll(" ", "");
		Double total = 0.0;
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
		
		if(!number.contains("-") && !number.contains("+") && !number.contains("*") && !number.contains("/") ) {
			return Double.parseDouble(number);
		}
		if((number.charAt(0) == '-' || number.charAt(0) == '+') && (!number.substring(1, number.length()).contains("-") && !number.substring(1, number.length()).contains("+"))) {		
			return Double.parseDouble(number);
		}
		for(int i = 1; i < number.length(); i++) {
			if(number.charAt(i) == '+' || number.charAt(i) == '-') {
				total = DivideNConquer(number.substring(0,i)) + DivideNConquer(number.substring(i,number.length()));
			}
		}	
		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 2 * 3 * 2 + 3 * 1 - 2 + 5 * (2 * 5 - 2 *8)	
		// Solution, Solve this using recursion, and I think I'm going to divide and conquer
		// on addition and subtraction. Also pay attention to ().
		
		String num = "-6*5*0";
		
		Calculator test = new Calculator();
		
		System.out.println(test.DivideNConquer(num));
		
		
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Enter your Equation:\n");
//		
//		String equation = scan.nextLine();
//		
//		
//		System.out.println(equation.replaceAll(" ", ""));

	
	}

}
