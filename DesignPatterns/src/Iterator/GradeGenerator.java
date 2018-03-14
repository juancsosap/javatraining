package Iterator;

import java.util.Iterator;

public class GradeGenerator implements LinearIterable {

	private double steps = 360 / 8;
	private double value = -steps ;
	private IteratorType type = IteratorType.CIRCULAR;
	
	public double getValue() { return this.value; }
	public void setValue(double value) { this.value = value; }

	public GradeGenerator(double start, double steps) {
		this.steps = steps;
		this.value = start - this.steps;
	}
	public GradeGenerator(double start) { this.value = start; }
	public GradeGenerator() {}
	
	public void setIterator(IteratorType type) { this.type = type; }
	
	public Iterator<Double> iterator() {
		if(this.type.equals(IteratorType.CIRCULAR)) 
			return new CircularIterator(360, this.steps, this);
		if(this.type.equals(IteratorType.SECUENTIAL))
			return new SecuentialIterator(360, this.steps, this);
		return null;
	}
	
}
