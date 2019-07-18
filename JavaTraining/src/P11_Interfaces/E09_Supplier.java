package P11_Interfaces;

import java.util.Random;
import java.util.function.Supplier;

public class E09_Supplier {

	public static void main(String[] args) {
		
		Supplier<Integer> generator1 = new IntegerRandomGenerator();
		System.out.println(generator1.get());
		
		Supplier<Double> generator2 = DoubleRandomGenerator;
		System.out.println(generator2.get());
		
		Supplier<Character> generator3 = CharRandomGenerator;
		System.out.println(generator3.get());
		
	}
	
	private static class IntegerRandomGenerator implements Supplier<Integer> {

		@Override
		public Integer get() {
			return (new Random()).nextInt();
		}
		
	}
	
	private static final Supplier<Double> DoubleRandomGenerator  = new Supplier<Double>() {

		@Override
		public Double get() {
			return (new Random()).nextDouble();
		}
		
	};
	
	private static final Supplier<Character> CharRandomGenerator = () -> (char) (byte) (new Random()).nextInt();

}
