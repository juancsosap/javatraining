package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.Person;
import view.ViewPerson;
import view.World;

public class Life {
	
	public World earth;
	
	public Life() {
		this.startTimer(500);
		earth = new World();
		this.createPeople();
	}
	
	public void createPeople() {
		for(int r=25; r<35; r++) {
			for(int c=35; c<45; c++) {
				boolean isAlive = Math.random() >= 0.6 ? true : false;
				if(isAlive) {
					this.earth.people[r][c].Born();
				}
			}
		}
	}
	
	public static Person testPerson(Person person, int lives) {
		if(person.isAlive() && lives < 2) { person.Dead(); }
		if(person.isAlive() && lives > 3) { person.Dead(); }
		if(!person.isAlive() && lives == 3) { person.Born(); }
		return person;
	}
	
	public static int livesCount(ViewPerson[][] people, int x, int y) {
		int count = 0;
		for(int i=-1; i<=1; i++) {
			for(int j=-1; j<=1; j++) {
				if(!(i == 0 && j == 0)) {
					int column = x + i;
					int row = y + j;
					if(people[row][column].getPerson().isAlive()) {
						count++;
					}
				}
			}
		}
		return count;
	}
	
	public void startTimer(int interval) {
		Timer timer = new Timer(interval, new TimeEventListener());
		timer.start();
	}
	
	class TimeEventListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Person[][] newPeople = new Person[60][80];
			for(int r=0; r<60; r++) {
				for(int c=0; c<80; c++) {
					if(r>0 && c>0 && r<59 && c<79) {
						int lives = Life.livesCount(earth.people, c, r);
						Person person = Life.testPerson(earth.people[r][c].getPerson(), lives);
						newPeople[r][c] = person;
					} else {
						newPeople[r][c] = new Person(r, c, false);
					}
					
				}
			}
			for(int r=0; r<60; r++) {
				for(int c=0; c<80; c++) {
					earth.people[r][c].setPerson(newPeople[r][c]);
				}
			}
			
		}

	}
	
}
