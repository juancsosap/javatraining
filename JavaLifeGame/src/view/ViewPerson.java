package view;

import java.awt.Color;

import javax.swing.JPanel;

import model.Person;

@SuppressWarnings("serial")
public class ViewPerson extends JPanel {
	
	private Person person;
	public Person getPerson() { return person; }
	public void setPerson(Person person) { 
		this.person = person;
		if(this.person.isAlive()) {
			this.Born();
		} else {
			this.Dead();
		}
	}
	
	public ViewPerson(Person person) {
		this.setPerson(person);
	}
	
	public void Born() {
		this.person.Born();
		this.setBackground(Color.BLACK);
	}
	
	public void Dead() {
		this.person.Dead();
		this.setBackground(Color.WHITE);
	}
}
