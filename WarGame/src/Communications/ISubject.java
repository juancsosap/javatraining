package Communications;

import Commands.ICommand;

public interface ISubject {

	public void register(IObserver ob);
	public void unregister(IObserver ob);
	public void notifyOne(IObserver ob, ICommand command);
	public void notifyAll(ICommand command);

	public void update(IObserver ob, IInformation info);
    
}
