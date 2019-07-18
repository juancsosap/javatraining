package P11_Interfaces;

import java.util.Scanner;
import java.util.function.UnaryOperator;

public class E12_UnaryOperator {

	public static void main(String[] args) {
		
		try(Scanner console = new Scanner(System.in)) {
			
			System.out.print("Cicle Radio: ");
			double radio = Double.parseDouble(console.nextLine());
			
			System.out.printf("Diameter: %,.2f%n", Diameter.apply(radio));
			System.out.printf("Perimeter: %,.2f%n", Perimeter.apply(radio));
			System.out.printf("Area: %,.2f%n", Area.apply(radio));
			
		}
		
	}
	
	private static final UnaryOperator<Double> Diameter  = r -> 2 * r;
	private static final UnaryOperator<Double> Perimeter  = r -> 2 * Math.PI * r;
	private static final UnaryOperator<Double> Area  = r -> Math.PI * r * r;
	
}
