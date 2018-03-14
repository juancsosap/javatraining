package Observer;

public class _Program {

	public static void main(String[] args) {
		
		System.out.println("----- StockMarket Creations ------");
		StockMarket newyork = new StockMarket("New York");
		StockMarket tokyo = new StockMarket("tokyo");
		System.out.println();
		
		System.out.println("--------- Stock Creations --------");
		Stock toyota = new Stock("Toyota", 10.0, tokyo);
		Stock zte = new Stock("ZTE", 15.0, tokyo);
		
		Stock aws = new Stock("AWS", 100.0, newyork);
		Stock microsoft = new Stock("Microsoft", 50.0, newyork);
		System.out.println();
		
		System.out.println("------ Shareholder Creations -----");
		Shareholder juan = new Shareholder("Juan", 1000.0);
		Shareholder luis = new Shareholder("Luis", 70.0);
		System.out.println();
		
		System.out.println("----------- Transactions ---------");
		luis.buyStock(toyota);
		luis.printStockSummary();
		luis.buyStock(toyota);
		luis.printStockSummary();
		luis.buyStock(aws);
		luis.printStockSummary();
		luis.buyStock(zte);
		luis.printStockSummary();
		luis.sellStock(aws);
		luis.printStockSummary();
		luis.sellStock(toyota);
		luis.printStockSummary();
		luis.sellStock(zte);
		luis.printStockSummary();
		luis.buyStock(microsoft);
		luis.printStockSummary();
		
		juan.buyStock(aws);
		juan.printStockSummary();
		juan.buyStock(toyota);
		juan.printStockSummary();
		System.out.println();
		
		System.out.println("----------- Stock Changes ---------");
		toyota.setValue(12.00);
		aws.setValue(110.00);
		zte.setValue(17.00);
		
		
	}

}
