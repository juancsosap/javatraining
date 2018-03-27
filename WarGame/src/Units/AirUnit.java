package Units;

import java.util.ArrayList;

import Commands.ICommand;
import Commands.MoveCommand;
import Troops.BasicTroopMediator;
import Weapons.BombWeapon;
import Weapons.MisileWeapon;
import Weapons.IWeapon;

public class AirUnit extends Unit {

	private ArrayList<MisileWeapon> misiles = new ArrayList<MisileWeapon>();
    private ArrayList<BombWeapon> bombs = new ArrayList<BombWeapon>();

    public AirUnit(BasicTroopMediator troop) {
    	super(troop);
        this.setType(UnitType.AIR);
        this.setSpeed(4);
    }

    @Override
	public void update(ICommand command) {
    	if(command instanceof MoveCommand)
    		command.execute(this); 
    }

    @Override
	public void recharge(IWeapon weapon) {
        if (weapon instanceof MisileWeapon)
            if (misiles.size() <= 5)
                misiles.add((MisileWeapon) weapon);

        if (weapon instanceof BombWeapon)
            if (bombs.size() <= 8)
                bombs.add((BombWeapon) weapon);
    }

	@Override
	public void attack(IWeapon weapon) {
		// TODO Auto-generated method stub
		
	}
	
}
