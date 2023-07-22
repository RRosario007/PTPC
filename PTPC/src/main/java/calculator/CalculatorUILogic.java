package calculator;

public class CalculatorUILogic {
	
	private int parenCount = 0;
	private boolean hitEqualbutton =false;
	private Calculator calculateEq = new Calculator();

	/**
	 * 
	 * @param equation, this is the button that is pressed as a string
	 * Need to detect what it is and pass through certain check in order to add it to the text box.
	 * Firstly it checks if its a parenthesis, then it checks if its operand, then it checks if its a decimal, and lastly if its just a number it adds it
	 */
	public String updateText(String equation, String textBox) {
		if(equation.equals("(")) {
			parenCount++;
		}
		
		if(equation.equals(")") && parenCount == 0){
			return textBox;
		}else if(equation.equals(")") && parenCount != 0) {
			parenCount--;
		}
		
		if(!textBox.isEmpty() && textBox.charAt(textBox.length()- 1) == '-' && (textBox.charAt(textBox.length()- 2) == '/' || textBox.charAt(textBox.length()- 2) == '*' )) {
			if(equation.equals("-") || equation.equals("+")){
				textBox = deleteOne(textBox);
				return textBox;
			}else if(equation.equals("*") || equation.equals("/")) {
				textBox = deleteOne(textBox);
				textBox = deleteOne(textBox);
				return textBox + equation;
			}

		}
		
		if((equation.equals("*") || equation.equals("/") || equation.equals("-") || equation.equals("+"))) {
			if(!textBox.isEmpty()) {
				if(textBox.charAt(textBox.length() -1) == equation.charAt(0) || textBox.charAt(textBox.length() -1) == '.') {
					return textBox;
				}else if(textBox.charAt(textBox.length() -1) != equation.charAt(0) && (textBox.charAt(textBox.length() -1) == '+' || textBox.charAt(textBox.length() -1) == '/' || textBox.charAt(textBox.length() -1) == '-' || textBox.charAt(textBox.length() -1) == '*')) {
					if(equation.equals("-") && (textBox.charAt(textBox.length() -1) == '*' || textBox.charAt(textBox.length() -1) == '/')) {
						
						return textBox + equation;
					}				
					return textBox.substring(0, textBox.length()-1) + equation;
				}
				
			}
				
		}
		
		
		if(equation.equals(".")) {
			for(int i = textBox.length() -1; i >= 0; i--) {
				if(textBox.charAt(i) == '.') {
					return textBox;
				}else if(textBox.charAt(i) == '+' || textBox.charAt(i) == '-' || textBox.charAt(i) == '*' || textBox.charAt(i) == '/') {
					
					return textBox + equation;
				}
			}
		}
		if(hitEqualbutton && !(equation.equals("*") || equation.equals("/") || equation.equals("-") || equation.equals("+"))) {
			hitEqualbutton = false;
			return "" + equation;
		}
		
		hitEqualbutton = false;
		
		return textBox + equation;
			
		
		
		
	}
	
	/**
	 * 
	 * @param number, the string of the equation
	 * In the case parenthesis weren't closed, like 2+(3-5, the closing parenthesis are added.
	 * @return the equation with the parenthesis that where missing is returned
	 */
	public String fixParen(String number) {
		if(parenCount !=0) {
			for(int i =0; i < parenCount; i++) {
				number += ")";
			}
		}
		for(int i = 1; i < number.length(); i++) {
			if(number.charAt(i) == '(' && !(number.charAt(i-1) =='+' || number.charAt(i-1) =='-' || number.charAt(i-1) =='*' || number.charAt(i-1) =='/' || number.charAt(i-1) =='(')) {			
				number = number.substring(0, i) + "*" + number.substring(i);
			}
			
			if(number.charAt(i) == ')' && i != number.length()-1 &&!(number.charAt(i+1) =='+' || number.charAt(i+1) =='-' || number.charAt(i+1) =='*' || number.charAt(i+1) =='/' || number.charAt(i+1) ==')')) {
				number = number.substring(0, i+1) + "*" + number.substring(i+1);
			}
		}
		
		parenCount = 0;
		System.out.println(number);
		return number;
	}
	
	public String clearText() {
		parenCount = 0;
		hitEqualbutton = false;
		return "0";
	}
	
	public String solvEquation(String equation) {
		
		hitEqualbutton = true;
		return calculateEq.DivideNConquer(fixParen(equation)) + "";
	}
	/**
	 * This method deletes one character every time the delete button is hit
	 */
	public String deleteOne(String textBox) {
		if(textBox.isEmpty()) {
			return "0";
		}
		if(textBox.charAt(textBox.length()-1) == '(') {
			parenCount--;
		}else if(textBox.charAt(textBox.length()-1) == ')') {
			parenCount++;
		}
		textBox = (textBox.substring(0, textBox.length() -1));
		if(textBox.isEmpty()) {
			textBox = "0";
		}
		
		return textBox;
	}
}
