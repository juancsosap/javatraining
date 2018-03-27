package Shield;

import Weapons.IWeapon;

public class NoShieldProxy extends ShieldProxy {

	private IShieldedUnit unit;
	
	public NoShieldProxy(IShieldedUnit unit) {
		super(0, unit);
	}
	
	@Override
	public void attack(IWeapon weapon) {
		this.unit.attack(weapon);
	}

	@Deprecated
	public void updateLevel() { }
	
}
