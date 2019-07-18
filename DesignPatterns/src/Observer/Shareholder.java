package Observer;

import java.util.ArrayList;

public class Shareholder implements IStockObserver {

	private String name;
	private double capital;
	private ArrayList<Stock> stocks = new ArrayList<>();
	
	public Shareholder(String name, double capital) {
		this.name = name;
		this.capital = capital;
		System.out.println(" + " + name + " Shareholder was Created");
	}
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public double getCapital() { return capital; }
	
	@SuppressWarnings("unchecked")
	public ArrayList<Stock> getStocks() { return (ArrayList<Stock>) stocks.clone(); }
	
	@Override
	public void update(Stock stock) {
		System.out.println(" < " + this.name + " Shareholder was notified that " + stock.getName() + " : " + stock.getValue());
	}
	
	public void buyStock(Stock stock) {
		System.out.println(" ~ " + this.getName() + " is trying to buy a " + stock.getName() + " Stock");
		if(stock.getValue() <= capital) {
			capital -= stock.getValue();
			System.out.println(" ~ " + this.getName() + " bought a " + stock.getName() + " Stock");
			if(!stocks.contains(stock))
				stock.register(this);
			stocks.add(stock);
		} else
			System.out.println(" * " + this.getName() + " doesn't have enougth money to sell a " + stock.getName() + " Stock");
	}
	
	public void sellStock(Stock stock) {
		System.out.println(" ~ " + this.getName() + " is trying to sell a " + stock.getName() + " Stock");
		if(stocks.remove(stock)) {
			capital += stock.getValue();
			System.out.println(" ~ " + this.getName() + " sold a " + stock.getName() + " Stock");
			if(!stocks.contains(stock))
				stock.unregister(this);
		} else
			System.out.println(" * " + this.getName() + " doesn't have " + stock.getName() + " Stock to sell");
	}
	
	public void printStockSummary() {
		ArrayList<Stock> stocksList = getStocks();
		stocksList.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
		
		System.out.println("-------------------------------");
		System.out.println(" ---> " + getName() + " have " + stocksList.size() + " Stock(s) and " + getCapital() + " USD");
		
		String currentStock = stocksList.get(0).getName();
		int count = 0;
		for(Stock stock : stocksList) {
			if(stock.getName().equals(currentStock)) {
				count++;
			} else {
				System.out.println(" ---> " + currentStock + " : " + count);
				count = 1;
				currentStock = stock.getName();
			}
		}
		System.out.println(" ---> " + currentStock + " : " + count);
		System.out.println("-------------------------------\n");
		
	}
	
}
