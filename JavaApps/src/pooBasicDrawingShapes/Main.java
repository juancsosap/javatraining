package pooBasicDrawingShapes;

public class Main {

	public static void main(String[] args) {

		Shape[] shape = new Shape[8]; 
		
		shape[0] = new Line(10);
		shape[1] = new Line(20,Direction.HORIZONTAL);
		shape[2] = new Line(5,Direction.VERTICAL);
		shape[3] = new Line(7,Direction.DIAGONAL_LEFT);
		shape[4] = new Line(3,Direction.DIAGONAL_RIGTH);
		shape[5] = new Rectangle(5,2);
		shape[6] = new Square(4);
		shape[7] = new Oval(7);
		
		for(Shape s: shape) {
			System.out.println(s.getDescription());
			s.printShape();
		}
		
		System.out.println(Shape.getQuantity());
	
	}

}
