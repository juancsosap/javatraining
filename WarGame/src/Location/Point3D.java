package Location;

public class Point3D implements IPoint {

	private double x, y, z;
	
    public Point3D(double x, double y, double z) {
        this.setX(x);
        this.setY(y);
        this.setZ(z);
    }
	
	private void setX(double x) { this.x = x; }
	private void setY(double y) { this.y = y; }
	private void setZ(double z) { this.z = z; }
	
	private double getX() { return x; }
	private double getY() { return y; }
	private double getZ() { return z; }
	
	@Override
	public double[] toArray() {
		double[] array = {this.getX(), this.getY(), this.getZ()};
		return array;
	}

	@Override
	public void fromArray(double[] array) throws IllegalArgumentException {
		try {
			this.setX(array[0]);
			this.setY(array[1]);
			this.setZ(array[2]);
		} catch(Exception e) {
			throw new IllegalArgumentException("Invalid Value, the array must have 3 values (x,y,z).");
		}
	}

	@Override
	public int getDimentions() { return 3; }

	@Override
	public String toString() {
		return String.format("(%,.2f; %,.2f; %,.2f)", this.getX(), this.getY(), this.getZ());
	}
	
}
