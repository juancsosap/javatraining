package Elements;

import java.util.ArrayList;

import Commands.ICommand;
import Communications.IObserver;
import Cosmos.Gamer;

public class BasicTroopMediator implements IObserver, IMediator {

	private ArrayList<IObserver> units = new ArrayList<IObserver>();
	
	private String name;
	private Gamer gamer;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public Gamer getGamer() { return gamer; }
	public void setGamer(Gamer gamer) { this.gamer = gamer; }

	public BasicTroopMediator(Gamer gamer, String name) {
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

}
