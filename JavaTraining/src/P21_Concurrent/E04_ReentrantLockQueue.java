package P21_Concurrent;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class E04_ReentrantLockQueue {

	public static void main(String[] args) {
		
		Cashier c1 = new Cashier();
		
		
		Arrays.asList(new Person("Juan", 4),   new Person("Jose", 2),
					  new Person("Luis", 1),   new Person("Maria", 0),
					  new Person("Ana", 4),    new Person("Pepe", 2),
					  new Person("Andres", 1), new Person("Carlos", 0))
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
				System.out.println(p.name + " is waiting in the queue");
				this.lock.lock();
				timed(2000);
				System.out.println(p.name + " is paying");
				this.lock.unlock();
				System.out.println(p.name + " is leaving the place");
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
		
		public Person(String name, int tolerance) {
			this.name = name;
			this.tolerance = tolerance;
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
