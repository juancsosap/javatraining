package P09_Classes;

public class E10_Vectors {

	public static void main(String[] args) {

		Vector2D v1 = new Vector2D(10, 20);
		Vector2D v2 = new Vector2D(30, 40);
		
		v1.display();
		v2.display();
		
		Vector2D v3 = v1.add(v2);
		Vector2D v4 = new Vector2D(v1.sub(v2));
		
		v3.display();
		v4.display();
		
		v1.add(v2);
		
		v3.display();
		v4.display();
		
		Vector3D v5 = new Vector3D(10, 20, 30);
		Vector3D v6 = new Vector3D(40, 50, 60);
		
		v5.display();
		v6.display();
		
		Vector3D v7 = v5.add(v6);
		Vector3D v8 = new Vector3D(v5.sub(v6));
		
		v7.display();
		v8.display();
		
		v5.add(v6);
		
		v7.display();
		v8.display();

	}

}

abstract class Vector {
	
	private double[] values;
	
	protected abstract int getDim();
	
	public Vector(double ... values) {
		this.values = new double[this.getDim()];
		for(int dim = 0; dim < this.getDim(); dim++) {
			this.setValue(dim, dim < values.length ? values[dim] : 0);
		}
	}
	
	protected void setValue(int dim, double value) {
		this.values[dim] = value;
	}
	
	protected double getValue(int dim) {
		return this.values[dim];
	}
	
	@Override
	public String toString() {
		StringBuilder text = new StringBuilder();
		text.append("(");
		for(int dim = 0; dim < this.getDim(); dim++) {
			if(dim > 0) text.append(" ");
			text.append(values[dim]);
		}
		text.append(")");
		return text.toString();
	}
	
	public void display() {
		System.out.println(this);
	}
	
	private Vector add(Vector v, int factor) {
		for(int dim = 0; dim < this.getDim(); dim++) {
			double value = this.getValue(dim) + factor * v.getValue(dim);
			this.setValue(dim, value);
		}
		return this;
	}
	protected Vector add(Vector v) { return this.add(v, 1); }
	protected Vector sub(Vector v) { return this.add(v, -1); }

}

class Vector3D extends Vector {
	
	public Vector3D(double x, double y, double z) { super(x, y, z); }
	public Vector3D(Vector3D v) { super(v.getX(), v.getY(), v.getZ()); }

	@Override
	protected int getDim() { return 3; }
	
	public double getX() { return this.getValue(0); }
	public double getY() { return this.getValue(1); }
	public double getZ() { return this.getValue(2); }
	
	public Vector3D add(Vector3D v) { return (Vector3D) super.add(v); }
	public Vector3D sub(Vector3D v) { return (Vector3D) super.sub(v); }
	
}

class Vector2D extends Vector {
	
	public Vector2D(double x, double y) { super(x, y); }
	public Vector2D(Vector2D v) { super(v.getX(), v.getY()); }

	@Override
	protected int getDim() { return 2; }
	
	public double getX() { return this.getValue(0); }
	public double getY() { return this.getValue(1); }
	
	public Vector2D add(Vector2D v) { return (Vector2D) super.add(v); }
	public Vector2D sub(Vector2D v) { return (Vector2D) super.sub(v); }
	
}
