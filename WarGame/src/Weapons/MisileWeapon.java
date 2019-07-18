package Weapons;

import Location.IPoint;

public abstract class MisileWeapon implements IWeapon {

	private long level = 1;
	
	public static final long BASIC_SPEED = 10;
	public static final long BASIC_RANGE = 1;
	
	private IPoint possition;
    
	public IPoint getPossition() { return possition; }
	public void setPossition(IPoint possition) { this.possition = possition; }
	
	public double getRange()  { return BASIC_RANGE * (2 - 1/getLevel()); }
	
	public long getSpeed()  { return BASIC_SPEED * (2 - 1/getLevel()); }
	
	public long getLevel()  { return level; }
	public void setLevel(long value)  { this.level = value; }
	public void updateLevel() { level++; }
	
	public abstract void shoot();

}
