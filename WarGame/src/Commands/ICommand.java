package Commands;

import Units.Unit;

public interface ICommand {

	public void execute(Unit unit);
	
	public String toString();
	
}
