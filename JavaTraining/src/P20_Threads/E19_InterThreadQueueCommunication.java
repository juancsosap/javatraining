package P20_Threads;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class E19_InterThreadQueueCommunication {

	public static void main(String[] args) throws InterruptedException {

		Queue<String> q = new ArrayBlockingQueue<>(10);
		
		Thread tp = new Thread(new Producer(q));
		Thread tc = new Thread(new Consumer(q));
		
		tp.start();
		tc.start();
		
	}
	
	private static class Producer implements Runnable {

		private Queue<String> q;
		
		public Producer(Queue<String> q) {
			this.q = q;
		}
		
		@Override
		public void run() {
			
			synchronized(q) {
				for(int i=0; i<10; i++) {
					q.add("Message " + i);
					q.notify();
				}
			}
			
		}
		
	}

	private static class Consumer implements Runnable {

		private Queue<String> q;
		
		public Consumer(Queue<String> q) {
			this.q = q;
		}
		
		@Override
		public void run() {
			
			synchronized(q) {
				
				for(int i=0; i<10; i++) {
					if(q.isEmpty())
						try {
							q.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					System.out.println(q.remove().toUpperCase());
				}
				
			}
			
		}
		
	}
	
}
