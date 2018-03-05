package GraphCalculator;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class DisplayPanelCalculator extends JPanel {

	private JLabel display;
	
	private Calculator cpu;
	
	public DisplayPanelCalculator(Calculator cpu) {
		this.cpu = cpu;
		
		this.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 35));
		this.setBackground(ColorCalculator.BACKGROUND.getColor());
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		this.display = new JLabel("0");
		this.display.setFont(new Font("Arial", Font.BOLD, 48));
		this.add(display);
		
		this.addKeyListener(new KeyboardListener());
	}
	
	public void setDisplay(String text) {
		this.display.setText(text);
	}
	
	public void focusDisplay() {
		this.grabFocus();
	}
	
	public String getDisplay() {
		return this.display.getText();
	}
	
	private class KeyboardListener extends KeyAdapter {

		@Override
		public void keyTyped(KeyEvent e) {
			cpu.sendCommand(e.getKeyChar() + "");
		}
		
	}

}
