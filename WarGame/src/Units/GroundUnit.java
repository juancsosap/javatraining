package Units;

import java.util.ArrayList;

import Commands.ICommand;
import Commands.MoveCommand;
import Troops.BasicTroopMediator;
import Weapons.MisileWeapon;
import Weapons.IWeapon;

public class GroundUnit extends Unit {

	ArrayList<MisileWeapon> misile = new ArrayList<MisileWeapon>();

    public GroundUnit(BasicTroopMediator troop) {
    	super(troop);
        this.setType(UnitType.GROUND);
        this.setSpeed(1);
    }

    @Override
	public void update(ICommand command) {
    	if(command instanceof MoveCommand)
    		command.execute(this); 
    }

    @Override
    public void recharge(IWeapon weapon) {
        if (weapon instanceof MisileWeapon)
            if (misile.size() <= 5)
                misile.add((MisileWeapon) weapon);
    }

    @Override
	public void attack(IWeapon weapon) {
		// TODO Auto-generated method stub
		
	}
	
}
