package P21_Concurrent;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
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
		
		//System.out.printf("Result: %,d\n", f.get());		
		
		System.out.println("\n-------------------------------------\n");
		
		int size = 100_000;
		PrimeVerifier p = new PrimeVerifier(1, size, 1_000);
		
		ini = LocalDateTime.now();
		
		pool = new ForkJoinPool(10);
		pool.submit(p);
		pool.shutdown();
		
		pool.awaitTermination(5, TimeUnit.MINUTES);
		
		fin = LocalDateTime.now();
		
		System.out.printf("Time Required: %,d msg\n", Duration.between(ini, fin).toMillis());
		
		//System.out.print("Result: ");
		//p.get().forEach((k, v) -> System.out.println(k + " : " + v));
	
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
	
	@SuppressWarnings("serial")
	private static class PrimeVerifier extends RecursiveTask<Map<Integer, Boolean>> { 
		
		private int blockSize;
		private int iniNum;
		private int quantity;
		
		public PrimeVerifier(int iniNum, int quantity, int blockSize) {
			this.iniNum = iniNum;
			this.quantity = quantity;
			this.blockSize = blockSize;
		}
		
		@Override
		protected Map<Integer, Boolean> compute() {
			Map<Integer, Boolean> result = new HashMap<>();
			
			if(quantity <= blockSize) {
				for(int num = iniNum; num < iniNum + quantity - 1; num++) {
					result.put(num, isPrime(num));
				}
				return result;
			} else {
				PrimeVerifier f1 = new PrimeVerifier(iniNum, quantity/2, blockSize);
				PrimeVerifier f2 = new PrimeVerifier(iniNum + quantity/2  + 1, quantity - quantity/2, blockSize);
				
				invokeAll(f1, f2);
				
				try {
					result.putAll(f1.get());
					result.putAll(f2.get());
					return result;
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
					return null;
				}
				
			}
		}
		
		public static boolean isPrime(int num) {
			if(num > 1) {
				for(int i = 2; i < num; i++) {
					if(num % i == 0) return false;
				}
				return true;
			}
			return false;
		}
		
	}


}
