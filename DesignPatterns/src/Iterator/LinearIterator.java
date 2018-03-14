package Iterator;

import java.util.Iterator;

public abstract class LinearIterator implements Iterator<Double> {

	protected double maxValue;
	protected double steps;
	protected LinearIterable source;
	
	public LinearIterator(double maxValue, double steps, LinearIterable source) {
		this.maxValue = maxValue;
		this.steps = steps;
		this.source = source;
	}
	
}
