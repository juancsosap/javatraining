package Troops;

import Communications.IObserver;

public interface ITroopMediator extends IObserver {
	
	public void add(IObserver unit);
	public void remove(IObserver unit);

}
