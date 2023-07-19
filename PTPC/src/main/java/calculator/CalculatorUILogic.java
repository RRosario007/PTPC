package calculator;

public class CalculatorUILogic {

	/**
	 * 
	 * @param equation, this is the button that is pressed as a string
	 * Need to detect what it is and pass through certain check in order to add it to the text box.
	 * Firstly it checks if its a parenthesis, then it checks if its operand, then it checks if its a decimal, and lastly if its just a number it adds it
	 */
	private void updateText(String equation) {
		String tempEq = textBox.getText();
		
		if(equation.equals("(")) {
			parenCount++;
		}
		
		if(equation.equals(")") && parenCount == 0){
			return;
		}else if(equation.equals(")") && parenCount != 0) {
			parenCount--;
		}
		
		if(!tempEq.isEmpty() && tempEq.charAt(tempEq.length()- 1) == '-' && (tempEq.charAt(tempEq.length()- 2) == '/' || tempEq.charAt(tempEq.length()- 2) == '*' )) {
			if(equation.equals("-") || equation.equals("+")){
				deleteOne();
				return;
			}else if(equation.equals("*") || equation.equals("/")) {
				deleteOne();
				deleteOne();
				textBox.setText(textBox.getText() + equation);
				return;
			}

		}
		
		if((equation.equals("*") || equation.equals("/") || equation.equals("-") || equation.equals("+"))) {
			if(!tempEq.isEmpty()) {
				if(tempEq.charAt(tempEq.length() -1) == equation.charAt(0)) {
					return;
				}else if(tempEq.charAt(tempEq.length() -1) != equation.charAt(0) && (tempEq.charAt(tempEq.length() -1) == '+' || tempEq.charAt(tempEq.length() -1) == '/' || tempEq.charAt(tempEq.length() -1) == '-' || tempEq.charAt(tempEq.length() -1) == '*')) {
					if(equation.equals("-") && (tempEq.charAt(tempEq.length() -1) == '*' || tempEq.charAt(tempEq.length() -1) == '/')) {
						
						textBox.setText(textBox.getText() + equation);
						return;
					}				
					textBox.setText(tempEq.substring(0, tempEq.length()-1) + equation);
					return;
				}
				
			}
				
		}
		
		
		if(equation.equals(".")) {
			for(int i = tempEq.length() -1; i >= 0; i--) {
				if(tempEq.charAt(i) == '.') {
					return;
				}else if(tempEq.charAt(i) == '+' || tempEq.charAt(i) == '-' || tempEq.charAt(i) == '*' || tempEq.charAt(i) == '/') {
					textBox.setText(textBox.getText() + equation);
					return;
				}
			}
		}
		if(hitEqualbutton && !(equation.equals("*") || equation.equals("/") || equation.equals("-") || equation.equals("+"))) {
			System.out.println("enter was hit");
			textBox.setText("");
			hitEqualbutton = false;
		}
		
		
		textBox.setText(textBox.getText() + equation);
			
		hitEqualbutton = false;
		
		
		
	}
	
	/**
	 * 
	 * @param number, the string of the equation
	 * In the case parenthesis weren't closed, like 2+(3-5, the closing parenthesis are added.
	 * @return the equation with the parenthesis that where missing is returned
	 */
	private String fixParen(String number) {
		if(parenCount !=0) {
			for(int i =0; i < parenCount; i++) {
				number += ")";
			}
		}
		System.out.println(number);
		for(int i = 1; i < number.length(); i++) {
			if(number.charAt(i) == '(' && !(number.charAt(i-1) =='+' || number.charAt(i-1) =='-' || number.charAt(i-1) =='*' || number.charAt(i-1) =='/' || number.charAt(i-1) =='(')) {			
				number = number.substring(0, i) + "*" + number.substring(i);
			}
			
			if(number.charAt(i) == ')' && i != number.length()-1 &&!(number.charAt(i-1) =='+' || number.charAt(i-1) =='-' || number.charAt(i-1) =='*' || number.charAt(i-1) =='/' || number.charAt(i+1) ==')')) {
				number = number.substring(0, i+1) + "*" + number.substring(i+1);
			}
		}
		
		
		return number;
	}
	
	/**
	 * This method deletes one character every time the delete button is hit
	 */
	private void deleteOne() {
		if(textBox.getText().isEmpty()) {
			return;
		}
		textBox.setText(textBox.getText().substring(0, textBox.getText().length() -1));
		if(textBox.getText().isEmpty()) {
			textBox.setText("0");
			return;
		}
	}
}
