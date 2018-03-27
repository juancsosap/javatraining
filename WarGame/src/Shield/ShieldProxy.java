package Shield;

import Weapons.IWeapon;

public abstract class ShieldProxy implements IShieldedUnit {

	private long level = 0;
	private IShieldedUnit unit;
	
	public ShieldProxy(long level, IShieldedUnit unit) {
		this.unit = unit;
	}
	
	@Override
	public void attack(IWeapon weapon) {
		this.unit.attack(weapon);
	}

	public long getLevel() { return level; }
	public void updateLevel() { level++; }
	
}
