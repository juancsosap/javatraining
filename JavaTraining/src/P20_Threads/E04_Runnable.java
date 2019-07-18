package P20_Threads;

public class E04_Runnable {

	public static void main(String[] args) {

		Thread t1 = new Thread(new MyTask("Printer 1"));
		
		Thread t2 = new Thread(new MyTask("Printer 2"));
		
		Thread t0 = new Thread(new MyTask("Printer Main"));
		
		t1.start();
		t2.start();
		
		t0.run();
	}
	
	private static class MyTask implements Runnable {
		
		private String name;
		
		public MyTask(String name) {
			this.name = name;
		}
		
		@Override
		public void run() {
			for(int i=0; i<10; i++) {
				System.out.println(this.name + ": " + i);
			}
		}
		
	}

}
