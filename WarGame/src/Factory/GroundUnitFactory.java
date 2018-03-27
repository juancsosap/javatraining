package Factory;

import java.util.ArrayList;

import Troops.BasicTroopMediator;
import Units.GroundUnit;
import Units.Unit;
import Weapons.IWeapon;

public class GroundUnitFactory implements IUnitFactory {
	
	@Override
	public Unit make(BasicTroopMediator troop, String name, ArrayList<IWeapon> weapons) {
        Unit unit = new GroundUnit(troop);
        unit.setName(name);
        for (IWeapon weapon : weapons)
        	unit.recharge(weapon);
        troop.add(unit);
        return unit;
    }

}
