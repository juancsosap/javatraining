package BasicGraphics;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AgeCalculator extends JFrame {

	private JPanel contentPane;
	private JTextField tfFecha;
	private JLabel lblEdad;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgeCalculator frame = new AgeCalculator();
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
	public AgeCalculator() {
		setTitle("Calculadora de Edad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 305, 147);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFechaDeNacimiento.setBounds(10, 11, 178, 14);
		contentPane.add(lblFechaDeNacimiento);
		
		tfFecha = new JTextField();
		tfFecha.setBounds(10, 33, 161, 20);
		contentPane.add(tfFecha);
		tfFecha.setColumns(10);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(198, 13, 46, 14);
		contentPane.add(lblEdad);
		
		JLabel lbEdad = new JLabel("");
		lbEdad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbEdad.setBounds(198, 33, 79, 20);
		contentPane.add(lbEdad);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 20/12/2017
				String fechaStr = tfFecha.getText();
				int year = Integer.valueOf(fechaStr.split("/")[2]);
				int month = Integer.valueOf(fechaStr.split("/")[1]);
				int dayOfMonth = Integer.valueOf(fechaStr.split("/")[0]);
				
				LocalDate ahora = LocalDate.now();
				LocalDate nacimiento = LocalDate.of(year, month, dayOfMonth);
			
				Period diff = Period.between(nacimiento, ahora); 
				int edad = diff.getYears();
				
				lbEdad.setText(edad + " años");
			}
		});
		btnCalcular.setBounds(188, 74, 89, 23);
		contentPane.add(btnCalcular);
	}
}
