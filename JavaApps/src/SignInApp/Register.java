package SignInApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class Register extends JFrame {

	private JPanel contentPane;
	private JLabel lblError;
	private JTextField tfName;
	private JTextField tfSurname;
	private JTextField tfAge;

	private static DBManager dbman = new DBManager("netec");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setTitle("Register Form");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 320, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setBounds(90, 11, 190, 14);
		lblError.setVisible(false);
		lblError.setText("Favor poner datos validos");
		contentPane.add(lblError);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(20, 30, 90, 20);
		contentPane.add(lblName);
		
		tfName = new JTextField();
		tfName.setBounds(90, 30, 190, 20);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSurname.setBounds(20, 60, 90, 20);
		contentPane.add(lblSurname);
		
		tfSurname = new JTextField();
		tfSurname.setBounds(90, 60, 190, 20);
		contentPane.add(tfSurname);
		tfSurname.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAge.setBounds(20, 90, 90, 20);
		contentPane.add(lblAge);
		
		tfAge = new JTextField();
		tfAge.setBounds(90, 90, 50, 20);
		contentPane.add(tfAge);
		tfAge.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegister.setBounds(184, 139, 89, 23);
		contentPane.add(btnRegister);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setBounds(86, 140, 89, 23);
		contentPane.add(btnCancel);
		
		btnRegister.addActionListener(new RegisterButtonListener());
		btnCancel.addActionListener(new CancelButtonListener());
		
	}
	
	private class RegisterButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent arg0) {
			boolean validName = !tfName.getText().isEmpty();
			boolean validSurname = !tfSurname.getText().isEmpty();
			boolean validNumber = tfAge.getText().matches("[0-9]+");
			
			boolean valid = validName && validSurname && validNumber;
			lblError.setVisible(!valid);
			
			if(valid) {
				if(dbman.uniqueData(tfName.getText(), tfSurname.getText())) {				
					dbman.insertData(tfName.getText(), tfSurname.getText(), tfAge.getText());
				
					tfName.setText("");
					tfSurname.setText("");
					tfAge.setText("");
				}
			}
			
			tfName.grabFocus();
			
		}
		
	}
	
	private class CancelButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
		
	}
}