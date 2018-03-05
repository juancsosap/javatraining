package pooBasicDrawingShapes;

public class Square extends Rectangle {

	public Square(int side) {
		super(side,side);
	}
	
	@Deprecated
	public void setWidth(int width) {
		setSide(width);
	}
	
	@Deprecated
	public int getWidth() { 
		return super.getWidth();
	}

	@Deprecated
	public void setHeight(int height) {
		setSide(height);
	}
	
	@Deprecated
	public int getHeight() { 
		return super.getHeight();
	}
	
	public void setSide(int side) {
		super.setHeight(side);
		super.setWidth(side);
	}
	
	public int getSide() {
		return super.getWidth();
	}
	
	@Override
	public String getDescription() {
		return "Square with " + getSide() + " units of side.";
	}
	
}
