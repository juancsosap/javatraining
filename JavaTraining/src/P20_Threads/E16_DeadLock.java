package P20_Threads;

public class E16_DeadLock {

	public static void main(String[] args) {
		
		Person p1 = new Person("Juan");
		Person p2 = new Person("Jose");
		
		p1.setFriend(p2);
		p2.setFriend(p1);
		
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		
		t1.start();
		t2.start();
		
	}
	
	private static class Person implements Runnable {
		
		private String name;
		private Person friend;
		
		public Person(String name) {
			this.name = name;
		}
		
		public void setFriend(Person friend) {
			this.friend = friend;
		}
		
		public synchronized void greet(Person p) {
			System.out.println("Hi " + p.getName());
		}
		
		public synchronized String getName() {
			return this.name;
		}  

		@Override
		public void run() {
			greet(friend);			
		}
	}

}
