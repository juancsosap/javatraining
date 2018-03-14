package Singleton;

public class Program {

	public static void main(String[] args) {
		
		System.out.println("Creating a new Counter1");
		Counter counter1 = Counter.getInstance();
		
		System.out.println("Count: " + counter1.getValue());
		
		System.out.println("Counting with Counter1");
		counter1.count();
		
		System.out.println("Count: " + counter1.getValue());
		
		System.out.println("Creating a new Counter2");
		Counter counter2 = Counter.getInstance();
		
		System.out.println("Count: " + counter2.getValue());
		
		System.out.println("Counting with Counter2");
		counter2.count();
		
		System.out.println("Count: " + counter1.getValue());
		
		System.out.println("Counting without variable");
		Counter.getInstance().count();
		
		System.out.println("Count: " + Counter.getInstance().getValue());
		
	}

}
