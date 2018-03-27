package Location;

public class Point2D implements IPoint {

	private double x, y;
	
    public Point2D(double x, double y) {
        this.setX(x);
        this.setY(y);
    }
	
	private void setX(double x) { this.x = x; }
	private void setY(double y) { this.y = y; }
	
	private double getX() { return x; }
	private double getY() { return y; }
	
	@Override
	public double[] toArray() {
		double[] array = {this.getX(), this.getY()};
		return array;
	}

	@Override
	public void fromArray(double[] array) throws IllegalArgumentException {
		try {
			this.setX(array[0]);
			this.setY(array[1]);
		} catch(Exception e) {
			throw new IllegalArgumentException("Invalid Value, the array must have 2 values (x,y).");
		}
	}

	@Override
	public int getDimentions() { return 2; }
	
	@Override
	public String toString() {
		return String.format("(%,.2f; %,.2f)", this.getX(), this.getY());
	}
	
}
