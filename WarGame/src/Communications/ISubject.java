package Communications;

import Commands.ICommand;
import Cosmos.ILocalable;

public interface ISubject extends ILocalable {

	public void register(IObserver ob);
	public void unregister(IObserver ob);
	public void notifyOne(IObserver ob, ICommand command);
	public void notifyAll(ICommand command);

	public void update(IObserver ob, IInformation info);
    
}
