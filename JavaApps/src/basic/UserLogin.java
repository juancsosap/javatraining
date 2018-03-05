package basic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class UserLogin {

	public static void main(String[] args) {
		new LoginWindow();
	}

}

@SuppressWarnings("serial")
class LoginWindow extends JFrame {
	
	private LoginPanel panel = new LoginPanel();
	
	public LoginWindow() {
		this.setTitle("User Login");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(300, 300);
		this.center();
		this.setVisible(true);
		
		this.add(this.panel, BorderLayout.CENTER);
		this.addMargin();
		
	}
	
	private void addMargin() {
		this.add(new JPanel(), BorderLayout.NORTH);
		this.add(new JPanel(), BorderLayout.EAST);
		this.add(new JPanel(), BorderLayout.SOUTH);
		this.add(new JPanel(), BorderLayout.WEST);
	}
	
	private void center() {
		Dimension winSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) (winSize.getWidth() - this.getWidth())/2;
		int y = (int) (winSize.getHeight() - this.getHeight())/2;
		
		this.setLocation(x, y);
	}
	
	private class LoginPanel extends JPanel {
		
		private JLabel emailLabel = new JLabel("Email");
		private JTextField email = new JTextField();
		
		private JLabel passwordLabel = new JLabel("Password");
		private JPasswordField password = new JPasswordField();
		
		private JButton button = new JButton("Login");
		
		public LoginPanel() {
			this.setLayout(new GridLayout(5,1,10,10));
			
			this.emailLabel.setFont(new Font("Arial", Font.BOLD, 16));
			this.add(emailLabel);
			this.email.setHorizontalAlignment(JTextField.CENTER);
			this.email.setForeground(Color.RED);
			this.add(this.email);
			
			this.passwordLabel.setFont(new Font("Arial", Font.BOLD, 16));
			this.add(passwordLabel);
			this.password.setHorizontalAlignment(JTextField.CENTER);
			this.password.setForeground(Color.RED);
			this.add(this.password);
			
			this.button.setEnabled(false);
			this.add(this.button);
			
			email.getDocument().addDocumentListener(new Validator());
			password.getDocument().addDocumentListener(new Validator());
		}
		
		public JTextField getEmail() {
			return this.email;
		}
		
		public JPasswordField getPassword() {
			return this.password;
		}
		
		public void validField(JTextField field, boolean valid) {
			field.setForeground(!valid ? Color.RED : Color.BLACK);
		}
		
	}
	
	private class Validator implements DocumentListener {

		@Override
		public void changedUpdate(DocumentEvent de) {}

		@Override
		public void insertUpdate(DocumentEvent de) {
			this.validate();
		}

		@Override
		public void removeUpdate(DocumentEvent de) {
			this.validate();
		}
		
		private void validate() {
			String email = panel.getEmail().getText().trim().toLowerCase();
			char[] password = panel.getPassword().getPassword();
			boolean isValid = true;
			
			System.out.println("Email: " + email);
			System.out.println("Password: " + password.toString());
			
			if(!email.matches("[a-z._-]+[@]([-a-z]+[.][a-z]+)+")) {
				isValid = false;
				panel.validField(panel.getEmail(), false);
			} else { 
				panel.validField(panel.getEmail(), true);
			}
			
			if(password.length < 8) {
				isValid = false;
				panel.validField(panel.getPassword(), false);
			} else { 
				panel.validField(panel.getPassword(), true);
			}
			
			panel.button.setEnabled(isValid);
		}
		
	}
	
}