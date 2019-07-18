package BasicPooShape;

public abstract class Shape {
	
	private String type;
	
	public String getType() {
		return this.type;
	}
	
	public Shape() {
		this.type = "Not Defined";
	}
	
	public abstract double getArea();
	
}