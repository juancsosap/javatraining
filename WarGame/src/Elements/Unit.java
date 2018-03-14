package Elements;

import Commands.ICommand;
import Communications.IObserver;
import Location.IPoint;
import Location.Point3D;
import Weapons.IWeapon;

public abstract class Unit implements IUnit, IObserver, IAttackable {
    
	private String name;
    private IPoint possition;
    private UnitType type;
    
    private int speed;
    private BasicTroopMediator troop;

    public String getName() { return this.name; }
    public void setName(String value) { this.name = value; }

    public IPoint getPossition() { return possition; }
	public void setPossition(IPoint possition) { this.possition = possition; }
	
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
	
}