package Observer;

public interface IStockObservable {

	public void register(IStockObserver ob);
	public void unregister(IStockObserver ob);
	public void notifyObservers();
	
}
