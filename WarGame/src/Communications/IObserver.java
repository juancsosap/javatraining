package Communications;

import Commands.ICommand;
import Cosmos.ILocalable;

public interface IObserver extends ILocalable {
	
	public void update(ICommand action);

}
