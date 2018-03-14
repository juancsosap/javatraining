package Weapons;

public abstract class BombWeapon implements IWeapon {

	private long level = 1;
	
	public static final long BASIC_RANGE = 10;
	
	public long getRange()  { return BASIC_RANGE * (2 - 1/getLevel()); }
	
	public long getLevel()  { return level; }
	public void setLevel(long value)  { this.level = value; }
	public void updateLevel() { level++; }
	
	public abstract void release();
	
}
