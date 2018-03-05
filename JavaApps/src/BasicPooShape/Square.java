package BasicPooShape;

public final class Square extends Rectangle {
	
	public Square(double side) {
		super(side, side);
	}
	
	@Override
	public String getType() {
		return "Shape.Square";
	}
	
}
