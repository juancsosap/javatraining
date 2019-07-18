package BasicPooShape;

public class MainPoo {

	public static void main(String[] args) {
		Circle c1 = new Circle(1);
		System.out.println(c1.toString() + ":" + c1.getType() + ":" + c1.getArea());
		Circle c2 = new Circle(1);
		System.out.println(c2.toString() + ":" + c2.getType() + ":" + c2.getArea());
		Shape r1 = new Rectangle(2,5);
		System.out.println(r1.getType() + ":" + r1.getArea());
		
		System.out.println(ShapeColor.DARK.getColor().getBlue());
		
		if(r1 instanceof Comparable) {
			System.out.println("C1 is Circle and has the Comparable Interface Implemented");
		}
		if(c1.compareTo(c2) == 1) {
			System.out.println("C1 is Bigger");
		} else if(c1.compareTo(c2) == -1) {
			System.out.println("C2 is Bigger");
		} else {
			System.out.println("C1 and C2 are Equals");
		}
		
		Shape s1 = new Square(2);
		System.out.println(s1.getType() + ":" + s1.getArea());
		
	}

}
