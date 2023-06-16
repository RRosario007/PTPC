package calculator;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorUI {

	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(350,450);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		//panel.setBackground(Color.red);
		panel.setSize(350,450);
		
		
		JTextField answer = new JTextField("ENTER YOUR NAME HERE");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx =0;
		c.gridy =0;
		panel.add(answer, c);
		

		
		
		
		
		
	}
}
