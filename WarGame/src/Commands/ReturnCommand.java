package Commands;

import java.util.logging.Level;

import Logging.GlobalLogger;
import Units.Unit;

public class ReturnCommand implements ICommand {

	@Override
	public void execute(Unit unit) {
		unit.getPossition().reset();
		GlobalLogger.getLogger().log(unit, Level.INFO, "ReturnCommand Executed");
	}

	@Override
	public String toString() { return "Return Command"; }
	
}
