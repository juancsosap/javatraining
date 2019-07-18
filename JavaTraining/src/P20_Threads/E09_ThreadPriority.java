package P20_Threads;

// The priority affect the Thread Scheduler, that is controlled by the OS
// Some OS such as Windows have no support for priority

public class E09_ThreadPriority {

	public static void main(String[] args) throws InterruptedException {

		Runnable task = () -> {
			for(int i=0; i<10; i++) {
				String name = Thread.currentThread().getName();
				int priority = Thread.currentThread().getPriority();

				System.out.println(name + ": " + i + " - " + priority);
			}
			
		};
		
		Thread t1 = new Thread(task, "Printer 1");
		
		// 10 High Priority
		t1.setPriority(Thread.MAX_PRIORITY); 
		
		Thread t2 = new Thread(task, "Printer 2");
		
		// 1 Low Priority
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		
		Thread t3 = new Thread(task, "Printer 2");
		
		// 5 Default Priority
		Thread.currentThread().setPriority(Thread.NORM_PRIORITY);
		
		t1.start();
		t2.start();
		t3.start();
		
		task.run();
		
	}
	
}
