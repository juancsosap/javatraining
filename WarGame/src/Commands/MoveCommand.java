package Commands;

import java.util.logging.Level;

import Location.IPoint;
import Logging.GlobalLogger;
import Units.Unit;

public class MoveCommand implements ICommand {

	private boolean absolute;
	private IPoint point;
	
	public MoveCommand(IPoint point, boolean absolute) {
		this.point = point;
		this.absolute = absolute;
	}
	public MoveCommand(IPoint point) { this(point, false); }

	@Override
	public void execute(Unit unit) {
		if(this.absolute) unit.setPossition(this.point);
		else unit.getPossition().add(this.point);
		GlobalLogger.getLogger().log(unit, Level.INFO, "MoveCommand Executed to the point " + unit.getPossition());
	}
	
	@Override
	public String toString() { return "Move Command"; }

}
