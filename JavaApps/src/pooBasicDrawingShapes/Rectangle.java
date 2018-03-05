package pooBasicDrawingShapes;

public class Rectangle extends Shape {
	
	private int width;
	private int height;

	public Rectangle(int width, int height) {
		setWidth(width);
		setHeight(height);
	}
	
	public void setWidth(int width) throws IllegalArgumentException {
		if(width > 0) {
			this.width = width;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public void setHeight(int height) throws IllegalArgumentException {
		if(height > 0) {
			this.height = height;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public int getHeight() {
		return this.height;
	}
	
	@Override
	public void printShape() {
		printLine();
		printSides();
		printLine();
	}
	
	private void printLine() {
		System.out.print(" ");
		for(int i=0; i<this.width; i++) {
			System.out.print("--");
		}
		System.out.println();
	}
	
	private void printSides() {
		for(int i=0; i<this.height; i++) {
			System.out.print("|");
			for(int j=0; j<this.width; j++) {
				System.out.print("  ");
			}
			System.out.println("|");
		}
	}
	
	@Override
	public String getDescription() {
		return "Rectangle with " + getWidth() + " units of width, and " +
				getHeight() + " units of high.";
	}

}
