package Factory;

import java.util.ArrayList;

import Elements.BasicTroopMediator;
import Elements.Unit;
import Weapons.IWeapon;

public interface IUnitFactory {

	public Unit make(BasicTroopMediator troop, String name, ArrayList<IWeapon> weapons);
	
}
