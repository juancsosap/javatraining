package View;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Components.*;
import Controler.*;
import Model.Person;
import Model.PersonData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class RegisterWindow extends JFrame {

	private JPanel contentPane;
	private JCustomTextField tfName;
	private JCustomTextField tfSurname;
	private JCustomTextField tfAge;
	private JTextField tfRut;
	private JTextField tfEmail;
	private JComboBox<String> cbCountry;
	private JTextArea taAddress;
	private JRadioButton rbMale;
	private JRadioButton rbFemale;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//Person person = new Person("Juan", "", "");
		//PersonData pd = new PersonData(person, true, 0, "Chile", "", "");
		new RegisterWindow();
	}

	/**
	 * Create the frame.
	 */
	
	public RegisterWindow() { this(true, null); }
	public RegisterWindow(boolean editable, PersonData pd) {
		URL imageURL = RegisterWindow.class.getResource("/View/Icono_Registro.png");
		setIconImage(Toolkit.getDefaultToolkit().getImage(imageURL));
		setTitle(!editable ? "Resultado Busqueda" : "Registro de Usuarios");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 292, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNombre = new JCustomLabel("Nombre");
		lblNombre.setBounds(10, 11, 62, 19);
		panel.add(lblNombre);
		
		tfName = new JCustomTextField(10, new NameValidator());
		tfName.setBounds(73, 12, 174, 20);
		tfName.setEditable(editable);
		tfName.setText(pd == null ? "" : pd.getName());
		panel.add(tfName);
		
		JLabel lblApellido = new JCustomLabel("Apellido");
		lblApellido.setBounds(10, 40, 62, 19);
		panel.add(lblApellido);
		
		tfSurname = new JCustomTextField(10, new NameValidator());
		tfSurname.setBounds(73, 41, 174, 20);
		tfSurname.setEditable(editable);
		tfSurname.setText(pd == null ? "" : pd.getSurname());
		panel.add(tfSurname);
		
		JLabel lblGenero = new JCustomLabel("Genero");
		lblGenero.setBounds(10, 70, 77, 19);
		panel.add(lblGenero);
		
		ButtonGroup rbGroup = new ButtonGroup();
		
		rbMale = new JCustomRadioButton("Masculino", rbGroup, true);
		rbMale.setBounds(73, 69, 86, 23);
		rbMale.setEnabled(editable);
		rbMale.setSelected(pd == null ? true : pd.isMale());
		panel.add(rbMale);
		
		rbFemale = new JCustomRadioButton("Femenino", rbGroup);
		rbFemale.setBounds(158, 69, 89, 23);
		rbFemale.setEnabled(editable);
		rbFemale.setSelected(pd == null ? false : !pd.isMale());
		panel.add(rbFemale);
		
		JLabel lblEdad = new JCustomLabel("Edad");
		lblEdad.setBounds(10, 100, 77, 19);
		panel.add(lblEdad);
		
		tfAge = new JCustomTextField(10, new AgeValidator()) ;
		tfAge.setBounds(73, 100, 86, 20);
		tfAge.setEditable(editable);
		tfAge.setText(pd == null ? "" : pd.getAge() + "");
		panel.add(tfAge);
		
		JLabel lblPais = new JCustomLabel("Pais");
		lblPais.setBounds(10, 130, 77, 19);
		panel.add(lblPais);
		
		cbCountry = new JCountryComboBox();
		cbCountry.setBounds(73, 130, 174, 20);
		cbCountry.setEditable(editable);
		cbCountry.setSelectedItem(pd == null ? "" : pd.getCountry());
		panel.add(cbCountry);
		
		JLabel lblRut = new JCustomLabel("RUT");
		lblRut.setBounds(10, 160, 77, 19);
		panel.add(lblRut);
		
		tfRut = new JCustomTextField(10, new RutValidator());
		tfRut.setBounds(73, 161, 174, 20);
		tfRut.setEditable(editable);
		tfRut.setText(pd == null ? "" : pd.getRut());
		panel.add(tfRut);
		
		JLabel lblEmail = new JCustomLabel("Email");
		lblEmail.setBounds(10, 190, 77, 19);
		panel.add(lblEmail);
		
		tfEmail = new JCustomTextField(10, new EmailValidator());
		tfEmail.setBounds(73, 191, 174, 20);
		tfEmail.setEditable(editable);
		tfEmail.setText(pd == null ? "" : pd.getEmail());	
		panel.add(tfEmail);
		
		JLabel lblDireccion = new JCustomLabel("Direcci\u00F3n");
		lblDireccion.setBounds(10, 220, 77, 19);
		panel.add(lblDireccion);
		
		taAddress = new JCustomTextArea();
		taAddress.setBounds(73, 219, 174, 72);
		taAddress.setEditable(editable);
		taAddress.setText(pd == null ? "" : pd.getAddress());
		panel.add(taAddress);
		
		JButton btAceptar = new JCustomButton("Aceptar");
		btAceptar.setBounds(158, 302, 89, 23);
		btAceptar.setVisible(!editable);
		btAceptar.addActionListener(ae -> dispose());
		panel.add(btAceptar);
		
		JButton btRegister = new JCustomButton("Registrar");
		btRegister.setBounds(158, 302, 89, 23);
		btRegister.setVisible(editable);
		btRegister.addActionListener(ae -> {
			Person person = new Person(tfName.getText(), tfSurname.getText(), tfRut.getText());
			PersonData persondata = new PersonData(person, rbMale.isSelected(), Integer.parseInt(tfAge.getText()), (String) cbCountry.getSelectedItem(), tfEmail.getText(), taAddress.getText());
			new RegisterPerson(persondata);
			JOptionPane.showMessageDialog(null, "Usuario satisfactoriamente registrado.");
			clearForm();
		});
		panel.add(btRegister);
		
		JButton btClean = new JCustomButton("Limpiar");
		btClean.setBounds(59, 302, 89, 23);
		btClean.setVisible(editable);
		btClean.addActionListener(ae -> clearForm());
		panel.add(btClean);
	}
	
	private void clearForm() {
		tfName.setText("");
		tfSurname.setText("");
		tfRut.setText("");
		rbMale.setSelected(true);
		tfAge.setText("0");
		cbCountry.setSelectedIndex(0);
		tfEmail.setText("");
		taAddress.setText("");
	}
		
}