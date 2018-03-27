package Weapons;

import Cosmos.ICostable;
import Cosmos.IRangeable;

public interface IWeapon extends ICostable, IRangeable {
	
	public static final long BASIC_COST   = 50;
	public static final long BASIC_WEIGHT = 20;
	public static final long BASIC_SIZE   = 20;
	public static final long BASIC_POWER   = 1;
	
	public default long getCost()   { return BASIC_COST * getLevel(); }
	public default long getWeight() { return BASIC_WEIGHT * (1 + 1/getLevel())/2; }
	public default long getSize()   { return BASIC_SIZE * (1 + 1/getLevel())/2; }
	public default long getPower()   { return BASIC_POWER * (2 - 1/getLevel())/2; }
	
	public static long getCost(long level) { return level * BASIC_COST; }
	public static long getUpdateCost(IWeapon weapon) { return (weapon.getLevel() * 2 - 1) * BASIC_COST; }
	
	public long getLevel();
	public void setLevel(long value);
	public void updateLevel();
	
}
