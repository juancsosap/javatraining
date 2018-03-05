package Components;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import Controler.Validable;
import Template.ProjectFont;

@SuppressWarnings("serial")
public class JCustomTextField extends JTextField {
	
	private Color successColor = Color.WHITE;
	private Color failedColor = Color.RED;
	private Validable validator;
	
	public JCustomTextField(int columns, Validable validator) {
		super(columns);
		this.validator = validator;
		
		setFont(new ProjectFont());
		
		addFocusListener(new EventAdapterHandler());
		addKeyListener(new EventAdapterHandler());
	}
	
	public void setSuccessColor(Color color) {
		this.successColor = color;
	}
	
	public void setFailedColor(Color color) {
		this.failedColor = color;
	}
	
	private class EventAdapterHandler implements FocusListener, KeyListener {
		
		public void focusLost(FocusEvent e) { setColor(); }
		public void focusGained(FocusEvent e) {}
		
		public void keyPressed(KeyEvent e) {}
		public void keyReleased(KeyEvent e) { setColor(); }
		public void keyTyped(KeyEvent e) {}
		
		private void setColor() {
			setBackground(validator.validate(getText()) ? successColor : failedColor);
		}
		
	}
	
}
