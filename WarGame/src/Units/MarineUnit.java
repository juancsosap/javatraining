package Units;

import java.util.ArrayList;

import Commands.ICommand;
import Commands.MoveCommand;
import Troops.BasicTroopMediator;
import Weapons.MisileWeapon;
import Weapons.IWeapon;

public class MarineUnit extends Unit {

	ArrayList<MisileWeapon> misile = new ArrayList<>(); 

    public MarineUnit(BasicTroopMediator troop) {
    	super(troop);
        this.setType(UnitType.MARINE);
        this.setSpeed(2);
    }

    @Override
	public void update(ICommand command) { 
    	if(command instanceof MoveCommand)
    		command.execute(this); 
    }

    @Override
    public void recharge(IWeapon weapon) {
        if (weapon instanceof MisileWeapon)
            if (misile.size() <= 20)
                misile.add((MisileWeapon) weapon);
    }

	@Override
	public void attack(IWeapon weapon) {
		// TODO Auto-generated method stub
		
	}

}
