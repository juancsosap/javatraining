package Iterator;

public class CircularIterator extends LinearIterator {

	public CircularIterator(double maxValue, double steps, LinearIterable source) {
		super(maxValue, steps, source);
	}
	
	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public Double next() {
		double num = source.getValue() + this.steps;
		source.setValue(num < this.maxValue ? num : num - this.maxValue);
		return source.getValue();
	}

}
