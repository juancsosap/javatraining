package GraphCalculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class ButtonCalculator extends JButton {
	
	private Calculator cpu;
	private ButtonCalc buttonCalc;

	public ButtonCalculator(ButtonCalc buttonCalc, Calculator cpu) {
		this.cpu = cpu;
		this.buttonCalc = buttonCalc;
		
		this.setText(buttonCalc.getLabel());
		this.setBorderPainted(false);
		
		ButtonType type = buttonCalc.getType();
		switch(type) {
			case NUMBER:
				this.setFont(new Font("Arial", Font.BOLD, 24));
				this.setBackground(ColorCalculator.UP_NUMBER.getColor());
				this.addMouseListener(new ButtonListener(ColorCalculator.UP_NUMBER.getColor(),
														 ColorCalculator.OVER_NUMBER.getColor(),
														 ColorCalculator.DOWN_NUMBER.getColor()));
				break;
			case OPERATOR:
				this.setFont(new Font("Arial", Font.PLAIN, 24));
				this.setBackground(ColorCalculator.UP_OPERATOR.getColor());
				this.addMouseListener(new ButtonListener(ColorCalculator.UP_OPERATOR.getColor(),
														 ColorCalculator.OVER_OPERATOR.getColor(),
														 ColorCalculator.DOWN_OPERATOR.getColor()));
				break;
			case FUNCTION:
				this.setFont(new Font("Arial", Font.PLAIN, 16));
				this.setBackground(ColorCalculator.UP_FUNCTION.getColor());
				this.addMouseListener(new ButtonListener(ColorCalculator.UP_FUNCTION.getColor(),
														 ColorCalculator.OVER_FUNCTION.getColor(),
														 ColorCalculator.DOWN_FUNCTION.getColor()));
				break;
		}
		
	}
	
	private class ButtonListener implements MouseListener {
		
		private boolean inside;
		
		private Color upColor;
		private Color overColor;
		private Color downColor;
		
		public ButtonListener(Color upColor, Color overColor, Color downColor) {
			this.upColor = upColor;
			this.overColor = overColor;
			this.downColor = downColor;
		}

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setBackground(this.overColor);
			this.inside = true;
		}

		@Override
		public void mouseExited(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setBackground(this.upColor);
			this.inside = false;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setBackground(this.downColor);
			cpu.sendCommand(buttonCalc);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setBackground(this.inside ? this.overColor : this.upColor);
		}
		
	}

}
