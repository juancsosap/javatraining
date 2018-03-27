package Units;

import Commands.ICommand;
import Location.IPoint;
import Location.Point3D;
import Troops.BasicTroopMediator;
import Weapons.IWeapon;

public abstract class Unit implements IUnit {
    
	public static final long BASIC_COST   = 300;
	
	private String name;
    private IPoint possition;
    private UnitType type;
    private long level = 1;
    
    private int speed;
    private BasicTroopMediator troop;

    public String getName() { return this.name; }
    public void setName(String value) { this.name = value; }

    public IPoint getPossition() { return possition; }
	public void setPossition(IPoint possition) { this.possition = possition; }
	
	public double getRange() { return 0; }
	public long getCost()   { return BASIC_COST * getLevel(); }
	
	public long getLevel()  { return level; }
	public void setLevel(long value)  { this.level = value; }
	public void updateLevel() { level++; }
	
	public UnitType getType() { return type; }
	public void setType(UnitType type) { this.type = type; }
	
	public int getSpeed() { return speed; }
	public void setSpeed(int speed) { this.speed = speed; }

	public BasicTroopMediator getTroop() { return this.troop; }
	public void setTroop(BasicTroopMediator troop) { this.troop = troop; }
	
    public Unit(BasicTroopMediator troop) {
        this.setTroop(troop);
        this.setPossition(new Point3D(0, 0, 0));
    }

    public abstract void recharge(IWeapon weapon);
    public abstract void update(ICommand command);
	
    @Override
	public String toString() { return this.getName(); }
    
    @Override
    public String getURL() {
    	return String.format("%s/%s/%s", this.getTroop().getGamer(), this.getTroop(), this);
    }
    
}