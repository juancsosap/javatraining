package P21_Concurrent;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;
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
		
		//System.out.printf("Result: %,d\n", f.number);

		ini = LocalDateTime.now();

		Fib.calculate(40);
				
		fin = LocalDateTime.now();
		
		System.out.printf("Time Required: %,d msg\n", Duration.between(ini, fin).toMillis());

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
		//p.getResult().forEach((k, v) -> System.out.println(k + " : " + v));

		ini = LocalDateTime.now();

		Map<Integer,Boolean> result = new HashMap<>();
		for(int num = 1; num <= size; num++) {
			result.put(num, PrimeVerifier.isPrime(num));
		}
				
		fin = LocalDateTime.now();
		
		System.out.printf("Time Required: %,d msg\n", Duration.between(ini, fin).toMillis());
		
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
		
		public static long calculate(int number) {
			return number <= 2 ? 1 : calculate(number - 1) + calculate(number - 2);
		}
		
	}
	
	@SuppressWarnings("serial")
	private static class PrimeVerifier extends RecursiveAction { 
		
		private Map<Integer, Boolean> result = new ConcurrentHashMap<>();
		private int blockSize;
		private int iniNum;
		private int quantity;
		
		public PrimeVerifier(int iniNum, int quantity, int blockSize) {
			this.iniNum = iniNum;
			this.quantity = quantity;
			this.blockSize = blockSize;
		}
		
		@Override
		protected void compute() {
			if(quantity <= blockSize) {
				for(int num = iniNum; num < iniNum + quantity - 1; num++) {
					result.put(num, isPrime(num));
				}
			} else {
				PrimeVerifier f1 = new PrimeVerifier(iniNum, quantity/2, blockSize);
				PrimeVerifier f2 = new PrimeVerifier(iniNum + quantity/2  + 1, quantity - quantity/2, blockSize);
				
				invokeAll(f1, f2);
				
				result.putAll(f1.getResult());
				result.putAll(f2.getResult());
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
		
		public Map<Integer,Boolean> getResult() {
			return this.result;
		}
		
	}

}
