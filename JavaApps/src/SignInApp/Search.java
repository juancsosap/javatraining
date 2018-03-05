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
public class Search extends JFrame {

	private JPanel contentPane;
	private JTextField tfID;
	private JLabel tfName;
	private JLabel tfSurname;
	private JLabel tfAge;
	private JLabel lblError;

	private static DBManager dbman = new DBManager("netec");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
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
	public Search() {
		setTitle("Search Form");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 320, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setBounds(90, 11, 190, 14);
		lblError.setVisible(true);
		contentPane.add(lblError);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(20, 60, 90, 20);
		contentPane.add(lblName);
		
		tfName = new JLabel();
		tfName.setEnabled(false);
		tfName.setBounds(90, 60, 190, 20);
		contentPane.add(tfName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSurname.setBounds(20, 90, 90, 20);
		contentPane.add(lblSurname);
		
		tfSurname = new JLabel();
		tfSurname.setEnabled(false);
		tfSurname.setBounds(90, 90, 190, 20);
		contentPane.add(tfSurname);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAge.setBounds(20, 120, 90, 20);
		contentPane.add(lblAge);
		
		tfAge = new JLabel();
		tfAge.setEnabled(false);
		tfAge.setBounds(90, 120, 50, 20);
		contentPane.add(tfAge);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearch.setBounds(188, 151, 89, 23);
		contentPane.add(btnSearch);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setBounds(90, 152, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblId.setBounds(20, 30, 90, 20);
		contentPane.add(lblId);
		
		tfID = new JTextField();
		tfID.setColumns(10);
		tfID.setBounds(90, 30, 40, 20);
		contentPane.add(tfID);
		
		btnSearch.addActionListener(new SearchButtonListener());
		btnCancel.addActionListener(new CancelButtonListener());
		
	}
	
	private class SearchButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent arg0) {
			tfName.setText("");
			tfSurname.setText("");
			tfAge.setText("");
			
			String id = tfID.getText();
			
			boolean validNumber = id.matches("[0-9]+");
			lblError.setText(!validNumber ? "ID no Valido" : "");
			
			if(validNumber) {
				String[] data = dbman.selectData(id);
				
				boolean validID = (data != null);
				lblError.setText(!validID ? "ID no encontrado" : "");
				
				if(validID) {
					tfName.setText(data[0]);
					tfSurname.setText(data[1]);
					tfAge.setText(data[2]);
				}
				
			}
			
			tfID.grabFocus();
			
		}
		
	}
	
	private class CancelButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
		
	}
}
