package P21_Concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class E03_ReentrantLock {

	public static void main(String[] args) {
		
		Person p1 = new Person("Juan");
		Person p2 = new Person("Jose");
		Person p3 = new Person("Luis");
		Person p4 = new Person("Maria");
		
		Room room = new Room(101);
		
		Thread t1 = new Thread(new Visit(p1, room));
		Thread t2 = new Thread(new Visit(p2, room));
		Thread t3 = new Thread(new Visit(p3, room));
		Thread t4 = new Thread(new Visit(p4, room));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
	
	private static class Room {
		
		private ReentrantLock lock;
		private int id;
		public List<Person> people = new ArrayList<>();
		private int locks = 0;
		
		public Room(int id) {
			this.lock = new ReentrantLock();
			this.id = id;
		}
		
		public ReentrantLock getKey() {
			return this.lock;
		}
		
		public synchronized void lock(Lock key, Person p) {
			if(key.equals(this.lock)) {
				if(this.locks < 4) {
					if(this.lock.tryLock()) {
						timed(10);
						this.locks = this.lock.getHoldCount();
						System.out.println(p.name + " lock the room " + this.id + " with " + this.lock.getHoldCount() + " lock(s)");
					} else
						System.out.println(p.name + " can't lock the room " + this.id + ", because was locked for other one");
				} else {
					System.out.println(p.name + " couldn't locked more the room " + this.id);
				}
			} else
				System.out.println(p.name + " has an invalid key for room " + this.id);
		}
		
		public synchronized void unlock(Lock key, Person p) {
			if(key.equals(this.lock)) {
				if(this.locks > 0) {
					try {
						this.lock.unlock();
						timed(10);
						this.locks = this.lock.getHoldCount();
						System.out.println(p.name + " unlock the room " + this.id + " with " + this.lock.getHoldCount() + " lock(s)");
					} catch(IllegalMonitorStateException ex) {
						System.out.println(p.name + " can't unlock the room " + this.id + ", because was locked for other one");
					}
				} else {
					System.out.println(p.name + " can't unlock more the room " + this.id);
				}
			} else
				System.out.println(p.name + " has an invalid key for room " + this.id);
		}
		
		public synchronized void enter(Person p) {
			if(!this.people.contains(p)) {
				if(this.locks == 0) {
					people.add(p);
					timed(20);
					System.out.println(p.name + " enter to the room " + this.id);
				} else	
					System.out.println(p.name + " can't enter to the room " + this.id + ", because it's close");
			} else
				System.out.println(p.name + " can't enter again to the room " + this.id + ", because he/she is already inside");
		}

		public synchronized void exit(Person p) {
			if(this.people.contains(p)) {
				if(this.locks == 0) {
					people.remove(p);
					timed(20);
					System.out.println(p.name + " exit from the room " + this.id);
				} else	
					System.out.println(p.name + " can't exit from the room " + this.id + ", because it's close");
			} else
				System.out.println(p.name + " can't exit from the room " + this.id + ", because he/she isn't inside");
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
		
		public Person(String name) {
			this.name = name;
		}

	}
	
	private static class Visit implements Runnable {

		private Person p;
		private Room r;
		
		public Visit(Person p, Room r) {
			this.p = p;
			this.r = r;
		}
		
		@Override
		public void run() {
			r.enter(p);
			r.lock(r.getKey(), p);
			r.lock(r.getKey(), p);
			r.exit(p);
			r.unlock(r.getKey(), p);
			r.unlock(r.getKey(), p);
			r.exit(p);
		}
		
	}

}
