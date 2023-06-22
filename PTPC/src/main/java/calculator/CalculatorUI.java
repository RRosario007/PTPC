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
	private JButton plusButton,minusButton,multButton,divButton, openParen, closeParen, enterButton, emptyButton;
	
	
	public CalculatorUI() {
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
		
		textBox = new JTextField();
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
		clearButton = new JButton("CE");
		clearButton.addActionListener(this);
		b0 = new  JButton("0");
		b0.addActionListener(this);
		numberPanel.add(b0);
		numberPanel.add(clearButton);
		
		
		mainFrame.add(numberPanel);
	}
	
	private void speacialOps() {
		operationsPanel = new JPanel();
		operationsPanel.setBackground(Color.green);
		operationsPanel.setLayout(new GridLayout(4,2,5,5));
		operationsPanel.setBounds(225, 100, 109, 312);
		
		enterButton = new JButton("=");
		enterButton.addActionListener(this);
		operationsPanel.add(enterButton);
		emptyButton = new JButton();
		emptyButton.addActionListener(this);
		operationsPanel.add(emptyButton);
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
		textBox.setText(textBox.getText() + equation);
		
	}
	
	public static void main(String[] args) {
			
		
		CalculatorUI test = new CalculatorUI();
		
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == enterButton) {
			System.out.println(e.getActionCommand() +  " hi");
		}else if(e.getSource() == clearButton) {
			System.out.println(e.getActionCommand() + " hello");
		}else {
			updateText(e.getActionCommand());
		}
		

		
	}
}
