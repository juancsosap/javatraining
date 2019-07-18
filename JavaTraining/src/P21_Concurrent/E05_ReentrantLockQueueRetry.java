package P21_Concurrent;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class E05_ReentrantLockQueueRetry {

	public static void main(String[] args) {
		
		Cashier c1 = new Cashier();
		
		
		Arrays.asList(new Person("Juan", 4, 3),   new Person("Jose", 2, 1),
					  new Person("Luis", 1, 1),   new Person("Maria", 0, 0),
					  new Person("Ana", 4, 5),    new Person("Pepe", 2, 2),
					  new Person("Andres", 1, 2), new Person("Carlos", 0, 4))
		      .forEach(p -> (new Thread(new Pay(p, c1))).start());
				
	}
	
	private static class Cashier {
		
		private ReentrantLock lock;
		
		public Cashier() {
			this.lock = new ReentrantLock(true);
		}
		
		public void pay(Person p) {
			int queueLength = this.lock.getQueueLength();
			System.out.println(p.name + " saw the queue with " + queueLength + " people");
			if(queueLength <= p.tolerance) {
				int wait = 0;
				System.out.println(p.name + " is waiting in the queue");
				do {
					try {
						if(this.lock.tryLock(1, TimeUnit.SECONDS)) {
							timed(1000);
							System.out.println(p.name + " is paying");
							this.lock.unlock();
							System.out.println(p.name + " is leaving the place");
							break;
						} else {
							wait++;
							System.out.println(p.name + " is already waiting in the queue");
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} while(wait < p.patience);
				if(wait == p.patience)
					System.out.println(p.name + " leave the queue, because the wait was too long for him/her");
			} else {
				System.out.println(p.name + " leave the queue, because was too long for him/her");
			}
		}
		
		private void timed(long time) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	private static class Person {
		
		public String name;
		public int tolerance;
		public int patience;
		
		public Person(String name, int tolerance, int patience) {
			this.name = name;
			this.tolerance = tolerance;
			this.patience = patience;
		}

	}
	
	private static class Pay implements Runnable {

		private Person p;
		private Cashier c;
		
		public Pay(Person p, Cashier c) {
			this.p = p;
			this.c = c;
		}
		
		@Override
		public void run() {
			c.pay(p);
		}
		
	}

}
