package P20_Threads;

public class E06_ThreadSleep {

	public static void main(String[] args) {

		Runnable task = () -> {
			for(int i=0; i<10; i++) {
				String name = Thread.currentThread().getName();

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println(name + ": " + i);
			}
		};
		
		Thread t1 = new Thread(task, "Printer 1");
		
		Thread t2 = new Thread(task, "Printer 2");
		
		Thread t0 = new Thread(task, "Printer Main");
		
		t1.start();
		t2.start();
		
		t0.run();
	}
	
}
