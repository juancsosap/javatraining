package Observer;

import java.util.ArrayList;

class Stock implements IStockObservable, INomrable {

	private String name;
	private double value;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public double getValue() { return value; }
	public void setValue(double value) { 
		this.value = value;
		notifyObservers();
	}
	
	public Stock(String name, double value, StockMarket market) {
		this.name = name;
		this.value = value;
		System.out.println(" + " + name + " Stock was Created");
		register(market);
	}
	
	ArrayList<IStockObserver> shareholders = new ArrayList<>();
	
	@Override
	public void register(IStockObserver ob) {
		if(!shareholders.contains(ob)) {
			shareholders.add(ob);
			System.out.println(" > " + ob.getName() + " " + ob.getClass().getName() + " register " + this.getName() + " Stock");
		}
	}
	
	@Override
	public void unregister(IStockObserver ob) {
		if(shareholders.contains(ob)) {
			shareholders.remove(ob);
			System.out.println(" > " + ob.getName() + " " + ob.getClass().getName() + " unregister " + this.getName() + " Stock");
		}
	}
	
	@Override
	public void notifyObservers() {
		for(IStockObserver ob : shareholders) {
			ob.update(this);
			System.out.println(" > " + ob.getName() + " " + ob.getClass().getName() + " was notified about " + this.getName() + " Stock");
		}
	}
	
}
