package P20_Threads;

public class E13_ThreadSynchronizedBlock {

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
				count.deposit(1);
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
				count.withdraw(1);
			}
		}
		
	}
	
	private static class Count {
		
		private int money = 0;
		
		public void deposit(int amount) {
			synchronized(this) {
				money += amount;
			}
			//String name = Thread.currentThread().getName();
			//System.out.println(name + " : " + money + " USD");
		}
		
		public void withdraw(int amount) {
			synchronized(this) {
				money -= amount;
			}
			//String name = Thread.currentThread().getName();
			//System.out.println(name + " : " + money + " USD");
		}
		
		public String toString() {
			return money + " USD";
		}
		
	}
	
}
