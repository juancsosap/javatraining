package view;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Person;

@SuppressWarnings("serial")
public class World extends JFrame {
	
	public JPanel panel;
	public JScrollPane scrollPanel;
	public ViewPerson[][] people;
	
	public World() {
		panel = new JPanel();
		panel.setLayout(new GridLayout(60, 80));
		scrollPanel = new JScrollPane(panel);
		this.add(scrollPanel);
				
		people = new ViewPerson[60][80];
		for(int r=0; r< 60; r++) {
			for(int c=0; c<80; c++) {
				people[r][c] = new ViewPerson(new Person(r, c, false));
				panel.add(people[r][c]);
			}
		}		
		
		this.setTitle("Life Game");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
	}

}
