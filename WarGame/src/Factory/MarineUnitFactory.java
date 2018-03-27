package Factory;

import java.util.ArrayList;

import Troops.BasicTroopMediator;
import Units.MarineUnit;
import Units.Unit;
import Weapons.IWeapon;

public class MarineUnitFactory implements IUnitFactory {
	
	@Override
	public Unit make(BasicTroopMediator troop, String name, ArrayList<IWeapon> weapons) {
        Unit unit = new MarineUnit(troop);
        unit.setName(name);
        for (IWeapon weapon : weapons)
            unit.recharge(weapon);
        troop.add(unit);
        return unit;
    }

}
