package P21_Concurrent;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class E13_ConcurrentHashMap {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Map<Integer, String> hm = new HashMap<>();
		// No Thread Save
		// Fail-Fast Iterator (ConcurrentModificationException)
		
		Map<String, Integer> ht = new Hashtable<>();
		// Thread Save
		// Complete Object Lock for read and write operations
		// 1 Concurrent Level
		// Fail-Save
		
		ConcurrentMap<Integer, String> chm = new ConcurrentHashMap<>(16, 0.75F, 16);
		// Thread Save
		// Segment Lock for write operations
		// Many Concurrency Levels (16 by default)
		// No lock required for read operations
		
		Thread t = new MyThread(chm);
		t.start();
		
		chm.put(101, "Juan");
		chm.put(102, "Jose");
		chm.put(102, "Andres");
		
		chm.putIfAbsent(103, "Luis");
		chm.putIfAbsent(102, "Pepe");
		
		chm.remove(103);
		chm.remove(101, "Jose");
		
		chm.replace(101, "Maria");
		chm.replace(102, "Pepe", "Ana");
		
		chm.forEach((k, v) -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(k + " :  " + v);
		});
		
		
		
	}
	
	@SuppressWarnings({ "unused", "serial" })
	private class ConcurrentMapAdapter<K, V> extends HashMap<K, V> implements ConcurrentMap<K, V> {

		public V putIfAbsent(K key, V value) { return null; }
		public boolean remove(Object key, Object value) { return false; }
		public boolean replace(K key, V oldValue, V newValue) { return false; }
		
	}
	
	private static class MyThread extends Thread {
		
		private Map<Integer, String> chm;
		
		public MyThread(Map<Integer, String> chm) {
			this.chm = chm;
		}
		
		@Override
		public void run() {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Child Thread Updating Map");
			chm.put(104, "Ana");
		}
	}


}
