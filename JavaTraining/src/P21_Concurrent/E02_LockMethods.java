package P21_Concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class E02_LockMethods {

	public static void main(String[] args) {
		
		Person p1 = new Person("Juan");
		Person p2 = new Person("Jose");
		
		Room room1 = new Room(101);
		// Room room2 = new Room(201);
		
		Thread t1 = new Thread(new Sleep(p1, room1));
		Thread t2 = new Thread(new Sleep(p2, room1));
		
		t1.start();
		t2.start();
		
	}
	
	private static class Room {
		
		private Lock lock;
		private int id;
		
		public Room(int id) {
			this.lock = new ReentrantLock();
			this.id = id;
		}
		
		public void rest(Person p) {
			if(this.lock.tryLock()) {
				
				System.out.println(p.name + " Resting on room " + this.id);
				
				sleep(1000);
				
				System.out.println(p.name + " Leaving room " + this.id);
				
				this.lock.unlock();
			} else {
				System.out.println("Room " + this.id + " not available for " + p.name);
			}
		}

		public void show(Person p) {
			try {
				if(this.lock.tryLock(10, TimeUnit.MILLISECONDS)) {
					
					System.out.println(p.name + " Showing the room " + this.id);
					
					sleep(100);
					
					System.out.println(p.name + " Leaving room " + this.id);
					
					this.lock.unlock();
				} else {
					System.out.println("Room " + this.id + " couldn't be show by " + p.name);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public void sleep(Person p) {
			this.lock.lock();
			
			System.out.println(p.name + " Sleeping on room " + this.id);
			
			sleep(5000);
			
			System.out.println(p.name + " Weaking Up and leaving room " + this.id);
			
			this.lock.unlock();
		}
		
		private void sleep(long time) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	private static class Person {
		
		public String name;
		
		public Person(String name) {
			this.name = name;
		}

	}
	
	private static class Sleep implements Runnable {

		private Person p;
		private Room r;
		
		public Sleep(Person p, Room r) {
			this.p = p;
			this.r = r;
		}
		
		@Override
		public void run() {
			r.show(p);
			r.rest(p);
			r.sleep(p);
		}
		
	}

}
