package P11_Interfaces;

import java.util.Scanner;
import java.util.function.DoubleFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class E10_PrimitiveFunctions {

	public static void main(String[] args) {
		
		try(Scanner console = new Scanner(System.in)) {
			
			String value = console.nextLine();
			
			ToDoubleFunction<String> calculator1 = new SquareCalculator();
			System.out.println(calculator1.applyAsDouble(value));
			
			ToIntFunction<String> calculator2 = CubeCalculator;
			System.out.println(calculator2.applyAsInt(value));
			
			ToLongFunction<String> calculator3 = DoubleCalculator;
			System.out.println(calculator3.applyAsLong(value));
			
			Double newvalue = Double.parseDouble(value);
			
			DoubleFunction<String> calculator4 = StringDoubler;
			String result4 = calculator4.apply(newvalue);
			System.out.println(result4);
			
			DoubleFunction<Integer> calculator5 = IntegerDoubler;
			Integer result5 = calculator5.apply(newvalue);
			System.out.println(result5);
			
			DoubleFunction<Double> calculator6 = DoubleDoubler;
			Double result6 = calculator6.apply(newvalue);
			System.out.println(result6);			
			
		}
		
	}
	
	private static class SquareCalculator implements ToDoubleFunction<String> {

		@Override
		public double applyAsDouble(String value) {
			Double value_as_double = Double.parseDouble(value); 
			return value_as_double * value_as_double;
		}
		
	}
	
	private static final ToIntFunction<String> CubeCalculator  = new ToIntFunction<String>() {

		@Override
		public int applyAsInt(String value) {
			Integer value_as_int = Integer.parseInt(value); 
			return value_as_int * value_as_int * value_as_int;
		}
		
	};
	
	private static final ToLongFunction<String> DoubleCalculator  = v -> Long.parseLong(v) * 2;
	
	private static final DoubleFunction<String> StringDoubler  = v -> (v * 2) + "";
	private static final DoubleFunction<Integer> IntegerDoubler  = v -> (int) (v * 2);
	private static final DoubleFunction<Double> DoubleDoubler  = v -> v * 2;
	
}
