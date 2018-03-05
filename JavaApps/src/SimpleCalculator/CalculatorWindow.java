package SimpleCalculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CalculatorWindow extends JFrame {

	public static void main(String[] args) {
		
		new CalculatorWindow();

	}
	
	private CalculatorDisplayPanel displayPanel = new CalculatorDisplayPanel();
	private CalculatorButtonsPanel buttonsPanel = new CalculatorButtonsPanel();
	
	private boolean newNumber = true;
	
	private double register = 0;
	private String oper = "="; 

	public CalculatorWindow() {
		this.setTitle("Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 250);
		this.center();
		this.setResizable(false);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		
		this.add(this.displayPanel, BorderLayout.NORTH);
		this.add(this.buttonsPanel, BorderLayout.CENTER);
	}
	
	private void center() {
		Dimension winSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) (winSize.getWidth() - this.getWidth())/2;
		int y = (int) (winSize.getHeight() - this.getHeight())/2;
		
		this.setLocation(x, y);
	}
	
	private class CalculatorDisplayPanel extends JPanel {
		
		private JTextField display = new JTextField("0");
		
		private CalculatorDisplayPanel() {
			
			this.setLayout(new BorderLayout());
			
			this.display.setEditable(false);
			this.display.requestFocus();
			this.add(this.display, BorderLayout.CENTER);
		}
		
		public String getText() {
			return this.display.getText();
		}
		
		public void setText(String text) {
			if(text.length() > 2 && newNumber) {
				if(text.substring(text.length()-2).equals(".0")) {
					text = text.substring(0, text.length()-2);
				}
			}
			this.display.setText(text);
			this.display.requestFocus();
		}
		
	}
	
	private class CalculatorButtonsPanel extends JPanel {
		
		private JButton[][] button = new JButton[4][4];
		
		private CalculatorButtonsPanel() {
			
			this.setLayout(new GridLayout(4,4));
			
			String[][] buttonText = {{"7", "8", "9", "/"}, 
									 {"4", "5", "6", "x"}, 
									 {"1", "2", "3", "-"}, 
									 {".", "0", "=", "+"}};
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					this.button[i][j] = new JButton(buttonText[i][j]);
					if(buttonText[i][j].matches("[0-9.]")) {
						this.button[i][j].addActionListener(new NumberListener());
					} else {
						this.button[i][j].addActionListener(new OperatorListener());
					}
					this.add(this.button[i][j]);
				}
			}
				
		}
		
		private class NumberListener implements ActionListener {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String button = e.getActionCommand();
				getNumber(button);
			}
			
			public void getNumber(String number) {
				String display = "0";
				if(!newNumber) {
					display = displayPanel.getText();
				}
				if(display.equals("0") && number.matches("[0-9]")) {
					display = number;
				} else {
					display = display + number;
				}
				if(display.matches("[0-9]+([.][0-9]*)?")) {
					displayPanel.setText(display);
					newNumber = false;
				}
			}
			
		}
				
		private class OperatorListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				String button = e.getActionCommand();
				this.calculate();
				oper = button;
			}
			
			public void calculate() {
				newNumber = true;
				double result = Double.parseDouble(displayPanel.getText());
				try {
					switch(oper) {
						case "+":
							result = register + result;
							break;
						case "-":
							result = register - result;
							break;
						case "x":
							result = register * result;
							break;
						case "/":	
							result = register / result;
							break;
					}
					register = result;
					displayPanel.setText(String.valueOf(result));
				} catch(Exception error) {
					register = 0;
					displayPanel.setText("NaN");
				}
			}
			
		}		


	}

}



