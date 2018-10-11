package P21_Concurrent;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class E15_CopyOnWriteArraySet {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Set<String> hs = new HashSet<>();
		// No Thread Save 
		// Fail-Fast Iterator (ConcurrentModificationException)
		
		Set<String> cowas = new CopyOnWriteArraySet<>();
		// Thread Save
		// Write is made on a copy that is later sync
		// when many write operations are made is not recommended
		// Fail-Save
		
		Thread t = new MyThread(cowas);
		t.start();
		
		cowas.add("Juan");
		cowas.add("Jose");
		cowas.add("Pepe");
		cowas.add("Antonio");
		
		cowas.forEach(e -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			System.out.println(e);
			if(e.equals("Pepe")) cowas.remove(e);
			cowas.add("Maria");
		});
		
		System.out.println(cowas);
	}
	
	private static class MyThread extends Thread {
		
		private Set<String> s;
		
		public MyThread(Set<String> s) {
			this.s = s;
		}
		
		@Override
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Child Thread Updating Set");
			s.add("Ana");
		}
	}

}
