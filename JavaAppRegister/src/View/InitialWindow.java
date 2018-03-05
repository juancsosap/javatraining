package View;

import java.awt.BorderLayout;
import java.awt.Dialog;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Controler.SearchPerson;
import Model.PersonData;

import java.awt.Toolkit;
import java.net.URL;

@SuppressWarnings("serial")
public class InitialWindow extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new InitialWindow();
	}

	/**
	 * Create the frame.
	 */
	
	public InitialWindow() {
		URL imageURL = InitialWindow.class.getResource("/View/Icono_Registro.png");
		setIconImage(Toolkit.getDefaultToolkit().getImage(imageURL));
		setTitle("BD de Usuarios");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAction = new JMenu("Acciones");
		menuBar.add(mnAction);
		
		JMenuItem mntmRegister = new JMenuItem("Registrar");
		mntmRegister.addActionListener(ae -> {
			new JDialog(new RegisterWindow(), "", Dialog.ModalityType.DOCUMENT_MODAL);
		});
		mnAction.add(mntmRegister);
		
		JMenuItem mntmSearch = new JMenuItem("Buscar");
		mntmSearch.addActionListener(ae -> new SearchWindow());
		mnAction.add(mntmSearch);
		
		JMenuItem mntmClose = new JMenuItem("Cerrar");
		mntmClose.addActionListener(ae -> dispose());
		mnAction.add(mntmClose);
		
		String[] columnsName = {"Nombre", "Apellido", "Genero",
				                "Edad",   "Pais",     "RUT",
				                "Email",  "Direcci\u00f3n"};
		
		PersonData[] fullPersonData = SearchPerson.searchAll();
		String[][] fulltable = new String[fullPersonData.length][8];
		for(int i=0; i<fullPersonData.length; i++) {
			PersonData p = fullPersonData[i];
			
			fulltable[i][0] = p.getName();
			fulltable[i][1] = p.getSurname();
			fulltable[i][2] = p.isMale() ? "Masculino" : "Femenino";
			fulltable[i][3] = p.getAge() + "";
			fulltable[i][4] = p.getCountry();
			fulltable[i][5] = p.getRut();
			fulltable[i][6] = p.getEmail();
			fulltable[i][7] = p.getAddress();
		}
		
		JTable table = new JTable(fulltable, columnsName);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setAutoCreateRowSorter(true);
		
		JScrollPane scrollpanel = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		contentPane.add(scrollpanel, BorderLayout.CENTER);
		
		setBounds(100, 100, 1000, 400);
		
	}
		
}