package P21_Concurrent;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class E16_ForkJoinRecursiveAction {

	public static void main(String[] args) throws InterruptedException {
		
		Fib f = new Fib(40);
		
		LocalDateTime ini = LocalDateTime.now();
		
		ForkJoinPool pool = new ForkJoinPool(10);
		pool.submit(f);
		pool.shutdown();
		
		pool.awaitTermination(5, TimeUnit.MINUTES);
		
		LocalDateTime fin = LocalDateTime.now();
		
		System.out.printf("Time Required: %,d msg\n", Duration.between(ini, fin).toMillis());
		
		System.out.printf("Result: %,d\n", f.number);
		
	}
	
	@SuppressWarnings("serial")
	private static class Fib extends RecursiveAction { 
		
		private int n;
		private long number = 0;
		
		public Fib(int n) {
			this.n= n;
		}
		
		@Override
		protected void compute() {
			if(n <= 1)
				number = n;
			else {
				Fib f1 = new Fib(n-1);
				Fib f2 = new Fib(n-2);
				
				invokeAll(f1, f2);
				
				number = f1.number + f2.number;
				
				//String name = Thread.currentThread().getName();
				//System.out.println("Fib(" + n + ") executed by " + name);
			}
		}
		
	}

}
