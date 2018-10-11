package P21_Concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class E12_CyclicBarrier {

	public static void main(String[] args) throws InterruptedException {
		
		CyclicBarrier cb = new CyclicBarrier(3);
		
		for(int i=0; i<10; i++) {
			(new Thread(new UserThread(cb), "User" + i)).start();
			
			Thread.sleep(1000);
		}
		
		System.out.println("Then all could be happy");
		
	}
	
	private static class UserThread implements Runnable {

		private CyclicBarrier cb;
		
		public UserThread(CyclicBarrier cb) {
			this.cb = cb;
		}
		
		@Override
		public void run() {
			String name = Thread.currentThread().getName();
			System.out.println(name + " arrive");
			
			try {
				cb.await(5, TimeUnit.SECONDS);
				System.out.println(name + " enter");
			} catch(TimeoutException ex) {
				System.out.println(name + " is alone");
			} catch(BrokenBarrierException | InterruptedException ex) {
				System.out.println(ex.getMessage());
			}
			
			
		}
		
	}

}
