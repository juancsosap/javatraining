package P20_Threads;

public class E12_ThreadSynchronizedStaticMethod {

	public static void main(String[] args) throws InterruptedException {

		Count count1 = new Count();
		Count count2 = new Count();
		
		Thread t0 = new Thread(new CountDeposit(count1, 100), "D1");
		Thread t1 = new Thread(new CountWithdraw(count1, 50), "W1");
		
		Thread t2 = new Thread(new CountDeposit(count2, 80), "D2");
		Thread t3 = new Thread(new CountWithdraw(count2, 20), "W2");
		
		t0.start();
		t1.start();
		t2.start();
		t3.start();
		
		t0.join();
		t1.join();
		t2.join();
		t3.join();
		
		System.out.println();
		
		System.out.println("Count1 : " + count1.toString());
		System.out.println("Count2 : " + count2.toString());

	}
	
	private static class CountDeposit implements Runnable {

		private Count count;
		private int amount;
		
		public CountDeposit(Count count, int amount) {
			this.count = count;
			this.amount = amount;
		}
		
		@Override
		public void run() {
			for(int i=0; i<amount; i++) {
				Count.deposit(count, 1);
			}
		}
		
	}

	private static class CountWithdraw implements Runnable {

		private Count count;
		private int amount;
		
		public CountWithdraw(Count count, int amount) {
			this.count = count;
			this.amount = amount;
		}
		
		@Override
		public void run() {
			for(int i=0; i<amount; i++) {
				Count.withdraw(count, 1);
			}
		}
		
	}
	
	private static class Count {
		
		public int money = 0;
		
		public synchronized static void deposit(Count count, int amount) {
			count.money += amount;
			//String name = Thread.currentThread().getName();
			//System.out.println(name + " : " + count.money + " USD");
		}
		
		public synchronized static void withdraw(Count count, int amount) {
			count.money -= amount;
			//String name = Thread.currentThread().getName();
			//System.out.println(name + " : " + count.money + " USD");
		}
		
		public String toString() {
			return money + " USD";
		}
		
	}
	
}
