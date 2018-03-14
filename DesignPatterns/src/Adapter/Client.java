package Adapter;

public class Client {

	public static void main(String[] args) {
		
		ITarget[] adapters = new ITarget[3];
		int numInt;
		double numDouble;
		
		adapters[0] = new AdapterCalculate(new AdapteeAdder());
		adapters[1] = new AdapterCalculate(new AdapteeMultiplier());
		adapters[2] = new AdapterMathPow();
		
		for(ITarget adapter : adapters) {
			// Input Integer Variables
			numInt = adapter.requestInt(5, 5);
			System.out.println(numInt);
			
			// Input Double Variables
			numDouble = adapter.requestDouble(Math.PI, Math.PI);
			System.out.println(numDouble);
		}
		
	}
	
}
