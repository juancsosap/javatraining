package Iterator;

import java.util.Iterator;

public class RadianGenerator implements LinearIterable {

	private double steps = 2 * Math.PI / 8;
	private double value = -steps;
	private IteratorType type = IteratorType.CIRCULAR;

	public double getValue() { return this.value; }
	public void setValue(double value) { this.value = value; }

	public RadianGenerator(double start, double steps) {
		this.steps = steps;
		this.value = start - this.steps;
	}
	public RadianGenerator(double start) { this.value = start; }
	public RadianGenerator() {}
	
	public void setIterator(IteratorType type) { this.type = type; }
	
	public Iterator<Double> iterator() {
		if(this.type.equals(IteratorType.CIRCULAR)) 
			return new CircularIterator(2 * Math.PI, this.steps, this);
		if(this.type.equals(IteratorType.SECUENTIAL))
			return new SecuentialIterator(2 * Math.PI, this.steps, this);
		return null;
	}

}
