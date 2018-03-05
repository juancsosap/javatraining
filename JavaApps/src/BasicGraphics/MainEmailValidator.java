package BasicGraphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainEmailValidator {

	public static void main(String[] args) {
		
		new EmailValidatorWindow(200, 200);

	}

}

@SuppressWarnings("serial")
class EmailValidatorWindow extends JFrame {
	
	public EmailValidatorWindow(int x, int y) {
		this.setVisible(true);
		this.setLocation(x, y);
		this.setTitle("Email Validator");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		
		this.add(new EmailValidatorPanel(), BorderLayout.CENTER);
		
		this.add(new JPanel(), BorderLayout.NORTH);
		this.add(new JPanel(), BorderLayout.SOUTH);
		this.add(new JPanel(), BorderLayout.EAST);
		this.add(new JPanel(), BorderLayout.WEST);
		
		this.setSize(500, 300);
	}
	
}

@SuppressWarnings("serial")
class EmailPopUpWindow extends JFrame {
	
	public EmailPopUpWindow(String message) {
		this.setVisible(true);
		this.setTitle("Email Validation Result");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		
		JPanel popupPanel = new JPanel();
		this.add(popupPanel, BorderLayout.CENTER);
		
		JLabel messageLabel = new JLabel(message);
		messageLabel.setFont(new Font("Arial", Font.BOLD, 35));
		messageLabel.setForeground(Color.RED);
		popupPanel.add(messageLabel);
		
		this.pack();
		
		this.center();
	}
	
	private void center() {
		Dimension winSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) (winSize.getWidth() - this.getWidth())/2;
		int y = (int) (winSize.getHeight() - this.getHeight())/2;
		
		this.setLocation(x, y);
	}
	
}

@SuppressWarnings("serial")
class EmailValidatorPanel extends JPanel {
	
	private JTextField texto = new JTextField(20);
	
	public EmailValidatorPanel() {
		this.setLayout(new GridLayout(3, 1, 10, 10));
		
		JLabel label = new JLabel("Email: ");
		label.setForeground(Color.RED);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("Arial", Font.BOLD, 35));
		this.add(label);
		
		
		texto.setHorizontalAlignment(JLabel.CENTER);
		texto.setFont(new Font("Arial", Font.BOLD, 35));
		this.add(texto);
		
		JButton boton = new JButton("Validate");
		boton.addActionListener(new Validator());
		boton.setFont(new Font("Arial", Font.BOLD, 35));
		this.add(boton);
		
	}
	
	private class Validator implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) { 
			if(texto.getText().matches("^[a-zA-Z][a-zA-Z0-9.-_]*[@]([a-zA-Z0-9-_]+[.][a-zA-Z0-9-_]+)+$")) {
				new EmailPopUpWindow("Correo Correcto");
			} else {
				new EmailPopUpWindow("Correo Incorrecto");
			}
		}

	}

	
}











