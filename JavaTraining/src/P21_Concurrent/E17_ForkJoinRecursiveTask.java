package P21_Concurrent;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class E17_ForkJoinRecursiveTask {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Fib f = new Fib(40);
		
		LocalDateTime ini = LocalDateTime.now();
		
		ForkJoinPool pool = new ForkJoinPool(10);
		pool.submit(f);
		pool.shutdown();
		
		pool.awaitTermination(5, TimeUnit.MINUTES);
		
		LocalDateTime fin = LocalDateTime.now();
		
		System.out.printf("Time Required: %,d msg\n", Duration.between(ini, fin).toMillis());
		
		System.out.printf("Result: %,d\n", f.get());
		
	}
	
	@SuppressWarnings("serial")
	private static class Fib extends RecursiveTask<Long> { 
		
		private int n;
		
		public Fib(int n) {
			this.n= n;
		}
		
		@Override
		protected Long compute() {
			try {
				if(n <= 1)
					return (long) n;
				else {
					Fib f1 = new Fib(n-1);
					Fib f2 = new Fib(n-2);
					
					invokeAll(f1, f2);
					
					try {
						return f1.get() + f2.get();
					} catch (InterruptedException | ExecutionException e) {
						e.printStackTrace();
						return null;
					}
				}
			} finally {
				//String name = Thread.currentThread().getName();
				//System.out.println("Fib(" + n + ") executed by " + name);
			}
		}
		
	}

}
