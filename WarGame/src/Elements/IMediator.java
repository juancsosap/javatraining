package Elements;

import Communications.IObserver;

public interface IMediator {
	
	public void add(IObserver unit);
	public void remove(IObserver unit);

}
