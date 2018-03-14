package Adapter;

public class AdapterMathPow implements ITarget {
	
	@Override
	public int requestInt(int a, int b) {
		return (int) Math.pow((double) a, (double) b);
	}
	
	@Override
	public double requestDouble(double a, double b) {
		return Math.pow(a, b);
	}
	
}
