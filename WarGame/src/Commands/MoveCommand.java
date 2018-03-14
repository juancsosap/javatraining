package Commands;

import Elements.Unit;
import Location.IPoint;

public class MoveCommand implements ICommand {

	private boolean absolute;
	private IPoint point;
	
	public MoveCommand(IPoint point, boolean absolute) {
		this.point = point;
		this.absolute = absolute;
	}
	public MoveCommand(IPoint point) { this(point, false); }

	@Override
	public void execute(Unit troop) {
		if(this.absolute) troop.setPossition(this.point);
		else troop.getPossition().add(this.point);
	}

}
