package Iterator;

public class SecuentialIterator extends LinearIterator {

	public SecuentialIterator(double maxValue, double steps, LinearIterable source) {
		super(maxValue, steps, source);
	}
	
	@Override
	public boolean hasNext() {
		return source.getValue() + this.steps < this.maxValue;
	}

	@Override
	public Double next() {
		source.setValue(source.getValue() + this.steps);
		return source.getValue() < this.maxValue ? source.getValue() : null;
	}

}
