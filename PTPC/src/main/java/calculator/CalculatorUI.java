package calculator;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.NumericShaper;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.Text;

public class CalculatorUI implements ActionListener{
	
	private JFrame mainFrame;
	private JPanel textBoxPanel;
	private JTextField textBox;
	private JPanel numberPanel;
	private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,decimalButton, clearButton;
	private JPanel operationsPanel;
	private JButton plusButton,minusButton,multButton,divButton, openParen, closeParen, enterButton, backSpace;
	private Calculator caculateEq;
	private boolean hitEqualbutton =false;
	private int parenCount = 0;
	public CalculatorUI() {
		caculateEq = new Calculator();
		mainFrame  = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(null);
		mainFrame.setSize(350,450);
		mainFrame.setLocationRelativeTo(null);
		answerBox();
		keypad();
		speacialOps();
		mainFrame.setVisible(true);
		mainFrame.revalidate();
	}
	
	private void answerBox() {
		textBoxPanel = new JPanel();
		textBoxPanel.setBackground(Color.red);
		textBoxPanel.setLayout(new FlowLayout());
		textBoxPanel.setBorder(new EmptyBorder(20,20,20,20));
		textBoxPanel.setBounds(0, 0, 334, 100);
		
		textBox = new JTextField("0");
		textBox.setEditable(false);
		textBox.setPreferredSize(new Dimension( 300, 50 ));
		Font font1 = new Font("SansSerif", Font.BOLD, 20);
		textBox.setFont(font1);
		textBox.setHorizontalAlignment(JTextField.RIGHT);
		
		textBoxPanel.add(textBox);
		mainFrame.add(textBoxPanel);
	}

	private void keypad() {
		
		numberPanel = new JPanel();
		numberPanel.setLayout(new GridLayout(4,3,5,5));
		numberPanel.setBackground(Color.blue);
		numberPanel.setBounds(0, 100, 225, 312);
		
		b1 = new JButton("1");
		b1.addActionListener(this);
		b2 = new JButton("2");
		b2.addActionListener(this);
		b3 = new JButton("3");
		b3.addActionListener(this);
		b4 = new JButton("4");
		b4.addActionListener(this);
		b5 = new JButton("5");
		b5.addActionListener(this);
		b6 = new JButton("6");
		b6.addActionListener(this);
		b7 = new JButton("7");
		b7.addActionListener(this);
		b8 = new JButton("8");		
		b8.addActionListener(this);
		b9 = new JButton("9");
		b9.addActionListener(this);
		numberPanel.add(b7);
		numberPanel.add(b8);
		numberPanel.add(b9);	
		numberPanel.add(b4);
		numberPanel.add(b5);
		numberPanel.add(b6);		
		numberPanel.add(b1);
		numberPanel.add(b2);
		numberPanel.add(b3);
		
		decimalButton = new JButton(".");
		decimalButton.addActionListener(this);
		numberPanel.add(decimalButton);
			
		b0 = new  JButton("0");
		b0.addActionListener(this);
		numberPanel.add(b0);
		enterButton = new JButton("=");
		enterButton.addActionListener(this);
		numberPanel.add(enterButton);

		
		
		mainFrame.add(numberPanel);
	}
	
	private void speacialOps() {
		operationsPanel = new JPanel();
		operationsPanel.setBackground(Color.green);
		operationsPanel.setLayout(new GridLayout(4,2,5,5));
		operationsPanel.setBounds(225, 100, 109, 312);
		
		clearButton = new JButton("CE");
		clearButton.addActionListener(this);
		operationsPanel.add(clearButton);
		backSpace = new JButton("⌫");
		backSpace.addActionListener(this);
		operationsPanel.add(backSpace);
		openParen = new JButton("(");
		openParen.addActionListener(this);
		operationsPanel.add(openParen);
		closeParen = new JButton(")");
		closeParen.addActionListener(this);
		operationsPanel.add(closeParen);
		plusButton = new JButton("+");
		plusButton.addActionListener(this);
		operationsPanel.add(plusButton);
		minusButton = new JButton("-");
		minusButton.addActionListener(this);
		operationsPanel.add(minusButton);
		multButton = new JButton("*");
		multButton.addActionListener(this);
		operationsPanel.add(multButton);
		divButton = new JButton("/");
		divButton.addActionListener(this);
		operationsPanel.add(divButton);
		mainFrame.add(operationsPanel);
		
		
	}
	
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
	
	public static void main(String[] args) {
			
		
		CalculatorUI test = new CalculatorUI();
		
		
	}
	
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

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == enterButton) {
			System.out.println(textBox.getText());
			
			Double solution = caculateEq.DivideNConquer(fixParen(textBox.getText()));
			textBox.setText(solution + "");
			hitEqualbutton = true;
			parenCount=0;
		}else if(e.getSource() == clearButton) {
			parenCount =0;
			hitEqualbutton = false;
			textBox.setText("0");
		}else if(e.getSource() == backSpace) {
			deleteOne();
		}else{
			if((e.getSource() != decimalButton && e.getSource() != plusButton && e.getSource() != minusButton && e.getSource() != multButton && e.getSource() != divButton) && textBox.getText().equals("0")) {
				textBox.setText("");
			}
			
			updateText(e.getActionCommand());
		}
		

		
	}
}
