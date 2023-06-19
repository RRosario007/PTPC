package calculator;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.Text;

public class CalculatorUI {

	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(350,450);
		frame.setVisible(true);
		//frame.setResizable(false);
		
		JPanel toptextPanel = new JPanel();
		toptextPanel.setBackground(Color.red);
		toptextPanel.setLayout(new FlowLayout());
		toptextPanel.setBorder(new EmptyBorder(20,20,20,20));
		toptextPanel.setBounds(0, 0, 334, 100);
		
		JTextField answer = new JTextField();
		answer.setPreferredSize(new Dimension( 300, 50 ));
		Font font1 = new Font("SansSerif", Font.BOLD, 20);
		answer.setFont(font1);
		answer.setHorizontalAlignment(JTextField.RIGHT);
		toptextPanel.add(answer);
				
		
		frame.add(toptextPanel);
		
		JPanel numberPanel = new JPanel();
		numberPanel.setLayout(new GridLayout(3,3,5,5));
		numberPanel.setBackground(Color.blue);
		numberPanel.setBounds(0, 100, 225, 312);

		
		JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
		

		b1 = new JButton("1");
		numberPanel.add(b1);

		b2 = new JButton("2");
		numberPanel.add(b2);

		b3 = new JButton("3");
		numberPanel.add(b3);

		b4 = new JButton("4");
		numberPanel.add(b4);

		b5 = new JButton("5");
		numberPanel.add(b5);

		b6 = new JButton("6");
		numberPanel.add(b6);

		b7 = new JButton("7");
		numberPanel.add(b7);

		b8 = new JButton("8");
		numberPanel.add(b8);
		
		b9 = new JButton("9");
		numberPanel.add(b9);
		
		frame.add(numberPanel);
		
		
		
		JPanel operationsPanel = new JPanel();
		operationsPanel.setBackground(Color.green);
		operationsPanel.setLayout(new GridLayout(2,2,5,5));
		operationsPanel.setBounds(225, 100, 109, 312);
		
		JButton ba,bb,bc,bd;
		
		ba = new JButton("+");
		operationsPanel.add(ba);
		bb = new JButton("-");
		operationsPanel.add(bb);
		bc = new JButton("*");
		operationsPanel.add(bc);
		bd = new JButton("/");
		operationsPanel.add(bd);
		
		
		
		frame.add(operationsPanel);
		
		frame.revalidate();
		
		
		
	}
}
