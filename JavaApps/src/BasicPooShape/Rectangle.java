package BasicPooShape;

public class Rectangle extends Shape {

	private double base = 0;
	private double height = 0;
	
	public final int vertices = 4;
	
	public Rectangle(double base, double height) {
		this.base = base;
		this.height = height;
	}
	
	@Override
	public final double getArea() {
		return this.base * this.height;
	}
	
	@Override
	public String getType() {
		return "Shape.Rectangle";
	}

}
