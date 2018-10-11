package P20_Threads;

public class E08_ThreadYield {

	public static void main(String[] args) throws InterruptedException {

		Runnable task = () -> {
			for(int i=0; i<10; i++) {
				String name = Thread.currentThread().getName();

				System.out.println(name + ": " + i);
				
				if(name.equals("main")) Thread.yield();
			}
			
		};
		
		Thread t1 = new Thread(task, "Printer 1");
		Thread t2 = new Thread(task, "Printer 2");
		
		t1.start();
		t2.start();
		
		task.run();
	}
	
}
