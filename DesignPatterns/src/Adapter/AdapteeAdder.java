package Adapter;

public class AdapteeAdder implements IAdaptee {
	
	@Override
	public double calculate(double a, double b) {
		return a+b;
	}

}
