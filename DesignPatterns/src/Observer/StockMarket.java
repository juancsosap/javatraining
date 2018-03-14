package Observer;

public class StockMarket implements IStockObserver {

	private String name;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public StockMarket(String name) {
		this.name = name;
		System.out.println(" + " + name + " StockMarket was Created");
	}
	
	@Override
	public void update(Stock stock) {
		System.out.println(" < " + this.name + " StockMarket was notified that " + stock.getName() + " : " + stock.getValue());
	}

}
