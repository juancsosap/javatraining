package pooBasicDrawingShapes;

public abstract class Shape implements Describable {

	private static int quantity = 0;
	
	public abstract void printShape();
	
	public Shape() {
		Shape.addShape();
	}
	
	@Override
	public void finalize() {
		Shape.removeShape();
	}
		
	private static void addShape() {
		Shape.quantity++;
	}
	
	private static void removeShape() {
		Shape.quantity--;
	}
	
	public static int getQuantity() {
		return Shape.quantity;
	}
	
	public String getDescription() {
		return Describable.NO_DESCRIPTION;
	}
}
