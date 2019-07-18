package Factory;

import java.util.ArrayList;

import Troops.BasicTroopMediator;
import Units.Unit;
import Weapons.IWeapon;

public interface IUnitFactory {

	public Unit make(BasicTroopMediator troop, String name, ArrayList<IWeapon> weapons);
	
}
