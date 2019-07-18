package Commands;

import java.util.logging.Level;

import Logging.GlobalLogger;
import Units.Unit;

public class NoCommand implements ICommand {

	@Override
	public void execute(Unit unit) {
		GlobalLogger.getLogger().log(unit, Level.INFO, "NoCommand Executed");
	}
	
	@Override
	public String toString() { return "No Command"; }

}
