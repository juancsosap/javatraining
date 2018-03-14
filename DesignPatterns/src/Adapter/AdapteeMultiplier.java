package Adapter;

public class AdapteeMultiplier implements IAdaptee {
	
	@Override
	public double calculate(double a, double b) {
		return a*b;
	}

}
