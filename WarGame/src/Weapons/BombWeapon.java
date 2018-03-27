package Weapons;

import Location.IPoint;

public abstract class BombWeapon implements IWeapon {

	private long level = 1;
	
	public static final long BASIC_RANGE = 10;
	public double getRange()  { return BASIC_RANGE * (2 - 1/getLevel()); }
	
	private IPoint possition;
    
	public IPoint getPossition() { return possition; }
	public void setPossition(IPoint possition) { this.possition = possition; }
	
	public long getLevel()  { return level; }
	public void setLevel(long value)  { this.level = value; }
	public void updateLevel() { level++; }
	
	public abstract void release();
	
}
