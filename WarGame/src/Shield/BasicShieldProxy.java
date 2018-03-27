package Shield;

import Weapons.IWeapon;

public class BasicShieldProxy extends ShieldProxy {

	private IShieldedUnit unit;
	
	public BasicShieldProxy(long level, IShieldedUnit unit) {
		super(level, unit);
	}
	
	@Override
	public void attack(IWeapon weapon) {
		long newLevel = weapon.getLevel() - this.getLevel();
		if(newLevel > 0) {
			weapon.setLevel(newLevel);
			this.unit.attack(weapon);
		}
	}

}
