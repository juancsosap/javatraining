package pooBasicDrawingShapes;

public class Line extends Shape {

	private int length;
	private Direction dir;
	
	public Line(int length, Direction dir) {
		super();
		this.setLength(length);
		this.setDirection(dir);
	}
	
	public Line(int length) {
		super();
		this.setLength(length);
		this.setDirection(Direction.HORIZONTAL);
	}
	
	public void setLength(int length) 
			throws IllegalArgumentException {
		if(length > 0) {
			this.length = length;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public int getLength() {
		return this.length;
	}
	
	public void setDirection(Direction dir) 
			throws IllegalArgumentException {
		if(dir instanceof Direction) {
			this.dir = dir;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public Direction getDirection() {
		return this.dir;
	}
	
	@Override
	public void printShape() {
		for(int i=0; i<this.length; i++) {
			if(dir == Direction.HORIZONTAL) {
				System.out.print("--");
			} else if(dir == Direction.VERTICAL) {
				System.out.println("|");
			} else if(dir == Direction.DIAGONAL_LEFT) {
				for(int j=this.length-1; j>i; j--) {
					System.out.print(" ");
				}
				System.out.println("/");
			} else if(dir == Direction.DIAGONAL_RIGTH) {
				for(int j=0; j<i; j++) {
					System.out.print(" ");
				}
				System.out.println("\\");
			}
		}
		if(dir == Direction.HORIZONTAL) {
			System.out.println();
		}
	}

	@Override
	public String getDescription() {
		return getDirection().getText() + " Line, with " + 
				getLength() + " units of length.";
	}

}

enum Direction {
	VERTICAL("Vertical"), 
	HORIZONTAL("Horizontal"), 
	DIAGONAL_RIGTH("Diagonal to the Rigth"), 
	DIAGONAL_LEFT("Diagonal to the Left");
	
	private String text;
	
	private Direction(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
}