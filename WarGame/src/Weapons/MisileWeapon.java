package Weapons;

public abstract class MisileWeapon implements IWeapon {

	private long level = 1;
	
	public static final long BASIC_SPEED = 10;
	
	public long getSpeed()  { return BASIC_SPEED * (2 - 1/getLevel()); }
	
	public long getLevel()  { return level; }
	public void setLevel(long value)  { this.level = value; }
	public void updateLevel() { level++; }
	
	public abstract void shoot();

}
