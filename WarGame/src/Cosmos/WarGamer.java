package Cosmos;

import java.util.ArrayList;
import java.util.logging.Level;

import Commands.ICommand;
import Communications.IInformation;
import Communications.IObserver;
import Factory.AirUnitFactory;
import Factory.GroundUnitFactory;
import Factory.IUnitFactory;
import Factory.MarineUnitFactory;
import Logging.GlobalLogger;
import Troops.BasicTroopMediator;
import Troops.ITroopMediator;
import Units.Unit;
import Units.UnitType;
import Weapons.IWeapon;

public class WarGamer implements IGamer {

	private IWorld world;
	
	private String name;
    private long money;
    private ArrayList<IWeapon> stock;

    private long level = 1;
	
	public long getLevel() { return this.level; }
	public void setLevel(long level) { 
		long oldLevel = this.level;
		this.level = level; 
		GlobalLogger.getLogger().log(this, Level.INFO, "WarGamer Level changed from " + oldLevel + " to " + this.level);
	}
	public void updateLevel() { 
		this.level++; 
		GlobalLogger.getLogger().log(this, Level.INFO, "WarGamer Level updated to " + this.level);
	}
	
    private ArrayList<IObserver> troops = new ArrayList<IObserver>();

    public WarGamer(IWorld world, String name) {
        this.setName(name);
        this.setMoney(1000);
        GlobalLogger.getLogger().log(this, Level.INFO, "WarGamer Created");
    }

    public void addUnit(BasicTroopMediator troop, UnitType type, String name, ArrayList<IWeapon> weapons) {
        IUnitFactory factory = null;

        if (type.equals(UnitType.AIR))
            factory = new AirUnitFactory();
        if (type.equals(UnitType.MARINE))
            factory = new MarineUnitFactory();
        if (type.equals(UnitType.GROUND))
            factory = new GroundUnitFactory();

        Unit unit = factory.make(troop, name, weapons);
        GlobalLogger.getLogger().log(this, Level.INFO, type + " Unit was make in the Factory as " + unit.getURL());
    }
    
    public void addTroop(String name) {
    	ITroopMediator troop = new BasicTroopMediator(this, name);
    	this.register(troop);
    	GlobalLogger.getLogger().log(this, Level.INFO, "Basic Troop was make as " + troop.getURL());
    }

    public void update(IObserver ob, IInformation info) { }

    public void notifyAll(ICommand command) {
        for(IObserver ob : troops)
            ob.update(command);
        GlobalLogger.getLogger().log(this, Level.INFO, "All Troops was notified with a " + command);
    }

    public void notifyOne(IObserver ob, ICommand command) {
        ob.update(command);
        GlobalLogger.getLogger().log(this, Level.INFO, "The " + ob.getName() + " Troop was notified with a " + command);
    }

    public void register(IObserver ob) {
        if (!troops.contains(ob)) {
        	world.register(ob);
        	troops.add(ob);
            GlobalLogger.getLogger().log(this, Level.INFO, "The " + ob.getName() + " Troop was register for notifications");
        }
    }

    public void unregister(IObserver ob) {
        if (troops.contains(ob)) {
            troops.remove(ob);
            world.unregister(ob);
            GlobalLogger.getLogger().log(this, Level.INFO, "The " + ob.getName() + " Troop was unregister for notifications");
        }
    }

    public IWorld getWorld() { return world; }
	public void setWorld(IWorld world) { 
		String oldWorld = this.world.getURL();
		this.world = world; 
		GlobalLogger.getLogger().log(this, Level.INFO, "WarGamer was moved to the " + world.getURL() + " World from " + oldWorld);
	}

	public String getName() { return name; }
	public void setName(String name) { 
		String oldName = this.name;
		this.name = name; 
		GlobalLogger.getLogger().log(this, Level.INFO, "WarGamer Name changed from " + oldName);
	}

	public long getMoney() { return money; }
	public void setMoney(long money) { 
		String oldMoney = String.format("%,.2f UGM", this.money);
		String newMoney = String.format("%,.2f UGM", money);
		this.money = money;
		GlobalLogger.getLogger().log(this, Level.INFO, "WarGamer Money was changed from " + oldMoney + " to " + newMoney);
	}
	public void addMoney(long money) { this.setMoney(this.getMoney() + money); }
	public void removeMoney(long money) { this.setMoney(this.getMoney() - money); }

	public ArrayList<IWeapon> getStock() { return stock; }
	public void setStock(ArrayList<IWeapon> stock) { 
		this.stock = stock;
		GlobalLogger.getLogger().log(this, Level.INFO, "WarGamer Stock was modified");
	}
	
	@Override
	public String toString() { return this.getName(); }

		
}
