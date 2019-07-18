package basic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class EmailValidatorApp {
	
	public static void main(String[] args) {	
		new EmailValidatorWindow();
	}
	
}

@SuppressWarnings("serial")
class EmailValidatorWindow extends JFrame {
		
	private EmailValidatorPanel panel = new EmailValidatorPanel();
	private ResultPanel result = new ResultPanel();
	
	public EmailValidatorWindow() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Email Validator");
		this.setSize(450, 150);
		this.setResizable(true);
		this.center();
		this.setVisible(true);
		
		this.setLayout(new BorderLayout());
		this.add(panel, BorderLayout.NORTH);
		this.add(result, BorderLayout.CENTER);
	}
	
	private void center() {
		Dimension winSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) (winSize.getWidth() - this.getWidth())/2;
		int y = (int) (winSize.getHeight() - this.getHeight())/2;
		
		this.setLocation(x, y);
	}
	
	private class EmailValidatorPanel extends JPanel {
		
		private JLabel label = new JLabel("Email: ");
		private JTextField text  = new JTextField(20);
		
		public EmailValidatorPanel() {
			this.add(this.label);
			
			Document doc = text.getDocument();
			doc.addDocumentListener(new Validator());
			this.add(this.text);
			
		}
		
		public boolean validEmail() {
			if(this.text.getText().trim().toLowerCase().matches("[a-z._-]+[@]([-a-z]+[.][a-z]+)+")) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	private class ResultPanel extends JPanel {
		
		private JLabel label = new JLabel();
		
		public ResultPanel() {
			this.label.setFont(new Font("Arial", Font.BOLD, 45));
			this.add(this.label);
		}
		
		public void setResult(String result, boolean isOK) {
			if(isOK) {
				this.label.setForeground(Color.GREEN);
			} else {
				this.label.setForeground(Color.RED);
			}
			this.label.setText(result);
			
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
			if(panel.validEmail()) {
				result.setResult("Correct", true);
			} else {
				result.setResult("Incorrect", false);
			}
		}
		
	}

}
