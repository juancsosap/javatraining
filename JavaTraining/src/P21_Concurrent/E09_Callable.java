package P21_Concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class E09_Callable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		Callable<String> c1 = new MyTask("Printer 1");
		Callable<String> c2 = new MyTask("Printer 2");
		
		ExecutorService pool = Executors.newCachedThreadPool();
		
		Future<String> r1 = pool.submit(c1);
		Future<String> r2 = pool.submit(c2);
		
		pool.shutdown();
		
		System.out.println("Callable Results");
		
		System.out.println(r1.get());
		System.out.println(r2.get());
		
	}
	
	private static class MyTask implements Callable<String> {
		
		private String name;
		
		public MyTask(String name) {
			this.name = name;
		}
		
		@Override
		public String call() throws Exception {
			String result = "";
			for(int i=0; i<10; i++) {
				Thread.sleep(1000);
				result += this.name + ": " + i + "\n";
			}
			return result;
		}
		
	}

}
