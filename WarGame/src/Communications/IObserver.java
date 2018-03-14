package Communications;

import Commands.ICommand;

public interface IObserver {
	
	public void update(ICommand action);

}
