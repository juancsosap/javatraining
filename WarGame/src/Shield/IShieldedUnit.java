package Shield;

import Cosmos.ICostable;
import Units.IAttackable;

public interface IShieldedUnit extends IAttackable, ICostable {
	
	public static final long BASIC_COST   = 10;
	public static final long BASIC_PROTECTION   = 0;
	
	public default long getCost()   { return BASIC_COST * getLevel(); }
	public default long getProtection() { return BASIC_PROTECTION * getLevel(); }
	
	public static long getCost(long level) { return level * BASIC_COST; }
	public static long getUpdateCost(IShieldedUnit shield) { return ( (shield.getLevel() + 1) * 2 - 1) * BASIC_COST; }
	
	public long getLevel();
	public void updateLevel();
	
}
