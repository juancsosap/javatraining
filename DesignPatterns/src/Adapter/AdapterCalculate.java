package Adapter;

public class AdapterCalculate implements ITarget {

	IAdaptee adaptee;
	
	public AdapterCalculate(IAdaptee adaptee) {
		this.adaptee = adaptee;
	}
	
	@Override
	public int requestInt(int a, int b) {
		return (int) adaptee.calculate((double) a, (double) b);
	}
	
	@Override
	public double requestDouble(double a, double b) {
		return adaptee.calculate(a, b);
	}

}
