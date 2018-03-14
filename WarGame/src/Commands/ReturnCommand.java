package Commands;

import Elements.Unit;

public class ReturnCommand implements ICommand {

	@Override
	public void execute(Unit troop) {
		troop.getPossition().reset();
	}

}
