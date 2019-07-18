package Troops;

import java.util.ArrayList;

import Commands.ICommand;
import Communications.IObserver;
import Cosmos.WarGamer;

public class BasicTroopMediator implements ITroopMediator {

	private ArrayList<IObserver> units = new ArrayList<IObserver>();
	
	private String name;
	private WarGamer gamer;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public WarGamer getGamer() { return gamer; }
	public void setGamer(WarGamer gamer) { this.gamer = gamer; }

	public BasicTroopMediator(WarGamer gamer, String name) {
		this.setGamer(gamer);
		this.setName(name);
	}
	
	@Override
	public void update(ICommand command) {
		for(IObserver unit : units)
			unit.update(command);
	}

	@Override
	public void add(IObserver unit) {
		if (!units.contains(unit))
			units.add(unit);
	}

	@Override
	public void remove(IObserver unit) {
		if (units.contains(unit))
			units.remove(unit);
	}
	
	@Override
	public String toString() { return this.getName(); }
	
	@Override
	public String getURL() {
		return String.format("%s/%s", this.getGamer().getURL(), this);
	}

}
