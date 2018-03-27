package Cosmos;

import java.util.ArrayList;
import java.util.logging.Level;

import Commands.ICommand;
import Communications.IInformation;
import Communications.IObserver;
import Logging.GlobalLogger;
import Units.IUnit;

public class WarWorld implements IWorld {

	private String name;
	
	private ArrayList<IUnit> units = new ArrayList<IUnit>();
	
	public WarWorld(String name) {
		this.name = name;
		GlobalLogger.getLogger().log(this, Level.INFO, "WarWorld Created");
	}

	public void setName(String value) { 
		String oldName = this.name;
		this.name = value; 
		GlobalLogger.getLogger().log(this, Level.INFO, "WarWorld Name changed from " + oldName);
	}
	
	public String getName() { return name; }
	
	@Override
	public String toString() { return this.getName(); }

	@Override
	public void register(IObserver ob) {
		IUnit unit = (IUnit) ob;
        if (!units.contains(unit)) {
        	units.add(unit);
        	GlobalLogger.getLogger().log(this, Level.INFO, "The " + ob.getName() + " Unit was register for notifications");
        }
	}

	@Override
	public void unregister(IObserver ob) {
		IUnit unit = (IUnit) ob;
        if (units.contains(unit)) {
        	units.remove(unit);
        	GlobalLogger.getLogger().log(this, Level.INFO, "The " + ob.getName() + " Unit was unregister for notifications");
        }
	}

	@Override
	public void notifyOne(IObserver ob, ICommand command) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyAll(ICommand command) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(IObserver ob, IInformation info) {
		// TODO Auto-generated method stub
		
	}
	
}
