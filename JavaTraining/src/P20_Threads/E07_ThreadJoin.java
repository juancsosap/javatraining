package P20_Threads;

public class E07_ThreadJoin {

	public static void main(String[] args) throws InterruptedException {

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
		
		t1.start();
		
		t1.join();
		
		t2.start();
		
		t2.join(5000);
		
		task.run();
	}
	
}
