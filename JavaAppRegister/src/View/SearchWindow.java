package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Components.*;
import Controler.*;
import Model.PersonData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class SearchWindow extends JFrame {

	private JPanel contentPane;
	private JTextField tfRut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchWindow frame = new SearchWindow();
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
	public SearchWindow() {
		URL imageURL = SearchWindow.class.getResource("/View/Icono_Registro.png");
		setIconImage(Toolkit.getDefaultToolkit().getImage(imageURL));
		setTitle("Buscar Usuario");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 292, 120);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblRut = new JCustomLabel("RUT");
		lblRut.setBounds(10, 10, 62, 20);
		panel.add(lblRut);
		
		tfRut = new JCustomTextField(10, new RutValidator());
		tfRut.setBounds(73, 10, 174, 20);
		panel.add(tfRut);
		
		JButton btSearch = new JCustomButton("Buscar");
		btSearch.setBounds(158, 40, 89, 23);
		btSearch.addActionListener(ae -> {
			PersonData pd = SearchPerson.search(tfRut.getText());
			if(pd == null) {
				JOptionPane.showMessageDialog(null, "El Rut suministrado no se encuentra registrado.");
			} else {
				RegisterWindow result = new RegisterWindow(false, pd);
				result.setVisible(true);
			}
		});
		panel.add(btSearch);
	}
		
}