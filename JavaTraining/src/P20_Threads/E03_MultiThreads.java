package P20_Threads;

public class E03_MultiThreads {

	public static void main(String[] args) {

		Thread t1 = new MyThread("Printer 1");
		
		Thread t2 = new MyThread("Printer 2");
		
		Thread t0 = new MyThread("Printer Main");
		
		t1.start();
		t2.start();
		
		t0.run();
		
	}
	
	private static class MyThread extends Thread {
		
		private String name;
		
		public MyThread(String name) {
			super(name);
			this.name = name;
		}
		
		@Override
		public void run() {
			for(int i=0; i<10; i++) {
				this.name = Thread.currentThread().getName();
				System.out.println(this.name + ": " + i);
			}
		}
		
	}

}
