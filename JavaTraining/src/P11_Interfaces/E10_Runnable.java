package P11_Interfaces;

import java.util.Random;

public class E10_Runnable {
    
    public static void main(String[] args) {
		
		Runnable generator1 = new IntegerRandomGenerator();
		generator1.run();
		
		Runnable generator2 = DoubleRandomGenerator;
		generator2.run();
		
		Runnable generator3 = CharRandomGenerator;
		generator3.run();
		
	}
	
	private static class IntegerRandomGenerator implements Runnable {

		@Override
		public void run() {
			System.out.println((new Random()).nextInt());
		}
		
	}
	
	private static final Runnable DoubleRandomGenerator  = new Runnable() {

		@Override
		public void run() {
			System.out.println((new Random()).nextDouble());
		}
		
	};
	
	private static final Runnable CharRandomGenerator = () -> System.out.println((char) (byte) (new Random()).nextInt());
}
