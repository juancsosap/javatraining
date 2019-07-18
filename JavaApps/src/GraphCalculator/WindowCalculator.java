package GraphCalculator;

import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class WindowCalculator extends JFrame {

	private Calculator cpu = new Calculator();
	
	private DisplayPanelCalculator displayPanel = new DisplayPanelCalculator(this.cpu);
	private ButtonPanelCalculator buttonPanel = new ButtonPanelCalculator(this.cpu);
	
	public WindowCalculator() {
		this.cpu.setDisplay(displayPanel);
		
		this.setTitle("Calculator");
		this.setBounds(500, 100, 330, 520);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		
		this.add(this.displayPanel, BorderLayout.NORTH);
		this.add(this.buttonPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}

}
