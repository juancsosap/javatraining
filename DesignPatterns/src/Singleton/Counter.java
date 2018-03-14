package Singleton;

public class Counter {
	
	private static Counter instance = null;
	
	private Counter() {}
	
	public static Counter getInstance() {
		if(instance == null)
			instance = new Counter();
		return instance;
	}
	
	private int count = 0;
	
	public int getValue() { return this.count; }
	public void count() { this.count++; }

}
