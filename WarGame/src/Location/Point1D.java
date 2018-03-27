package Location;

public class Point1D implements IPoint {

	private double x;
	
    public Point1D(double x) {
        this.setX(x);
    }
	
	private void setX(double x) { this.x = x; }
	
	private double getX() { return x; }
	
	@Override
	public double[] toArray() {
		double[] array = {this.getX()};
		return array;
	}

	@Override
	public void fromArray(double[] array) throws IllegalArgumentException {
		try {
			this.setX(array[0]);
		} catch(Exception e) {
			throw new IllegalArgumentException("Invalid Value, the array must have 2 values (x,y).");
		}
	}
	
	@Override
	public int getDimentions() { return 1; }
	
	@Override
	public String toString() {
		return String.format("(%,.2f)", this.getX());
	}
	
}
