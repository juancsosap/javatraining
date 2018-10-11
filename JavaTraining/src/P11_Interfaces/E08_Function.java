package P11_Interfaces;

import java.util.Scanner;
import java.util.function.Function;

public class E08_Function {

	public static void main(String[] args) {
		
		try(Scanner console = new Scanner(System.in)) {
			
			Double value = Double.parseDouble(console.nextLine());
			
			Function<Double, Double> calculator;
			
			calculator = new SquareCalculator();
			System.out.println(calculator.apply(value));
			
			calculator = CubeCalculator;
			System.out.println(calculator.apply(value));
			
			calculator = DoubleCalculator;
			System.out.println(calculator.apply(value));
			
		}
		
	}
	
	private static class SquareCalculator implements Function<Double, Double> {

		@Override
		public Double apply(Double value) {
			return value * value;
		}
		
	}
	
	private static final Function<Double, Double> CubeCalculator  = new Function<Double, Double>() {

		@Override
		public Double apply(Double value) {
			return value * value * value;
		}
		
	};
	
	private static final Function<Double, Double> DoubleCalculator  = v -> v + v;

}
