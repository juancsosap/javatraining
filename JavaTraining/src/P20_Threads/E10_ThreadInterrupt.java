package P20_Threads;

public class E10_ThreadInterrupt {

	public static void main(String[] args) {

		Runnable task = () -> {
			String name = Thread.currentThread().getName();
			
			System.out.println(name + " will sleep");
			
			try {
				Thread.sleep(10_000);
				System.out.println(name + " sleep good");
			} catch (InterruptedException e) {
				System.out.println(name + " was interrupted");
			}
		};
		
		Thread t1 = new Thread(task, "Juan");
		Thread t2 = new Thread(task, "Luis");
		Thread t3 = new Thread(task, "Jose");
		Thread t4 = new Thread(task, "Pepe");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		String name = "Main"; 
		System.out.println(name + " will wake up to the others");
		
		t1.interrupt();
		
		try {
			Thread.sleep(4_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t2.interrupt();

		try {
			Thread.sleep(4_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t3.interrupt();

		try {
			Thread.sleep(4_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t4.interrupt();
		
		System.out.println("Now all are awake");
		
	}
	
}
