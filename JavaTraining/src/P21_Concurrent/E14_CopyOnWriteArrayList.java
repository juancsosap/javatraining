package P21_Concurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class E14_CopyOnWriteArrayList {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		List<String> al = new ArrayList<>();
		// No Thread Save 
		// Fail-Fast Iterator (ConcurrentModificationException)
		
		CopyOnWriteArrayList<String> cowal = new CopyOnWriteArrayList<>();
		// Thread Save
		// Write is made on a copy that is later sync
		// when many write operations are made is not recommended
		// Fail-Save
		
		Thread t = new MyThread(cowal);
		t.start();
		
		cowal.add("Juan");
		cowal.add("Jose");
		
		cowal.add("Juan");
		cowal.addIfAbsent("Jose");
		
		cowal.addAllAbsent(Arrays.asList("Maria", "Antonio", "Pepe", "Jose"));
		
		cowal.forEach(e -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			System.out.println(e);
			if(e.equals("Antonio")) cowal.remove(e);
			cowal.addIfAbsent("Andres");
			cowal.add("Luisa");
		});
		
		System.out.println(cowal);
		
	}
	
	private static class MyThread extends Thread {
		
		private List<String> l;
		
		public MyThread(List<String> l) {
			this.l = l;
		}
		
		@Override
		public void run() {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Child Thread Updating List");
			l.add("Ana");
		}
	}

}
