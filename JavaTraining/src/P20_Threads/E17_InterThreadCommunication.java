package P20_Threads;

public class E17_InterThreadCommunication {

	public static void main(String[] args) throws InterruptedException {

		Count countSrc = new Count(200);
		Count countDst = new Count();
		
		System.out.println("Count SRC: " + countSrc.toString());
		System.out.println("Count DST: " + countDst.toString());
		
		System.out.println();
		
		System.out.println("Transfer between Counts");
		Thread t = new Thread(new CountTransfer(countSrc, countDst, 100), "D1");
		
		System.out.println();
		
		t.start();
		
		System.out.println("MAIN Locking Count SRC");
		synchronized(countSrc) {
			System.out.println("MAIN Waiting Count SRC");
			countSrc.wait(100);
		}
		System.out.println("Count SRC: " + countSrc.toString());
		
		System.out.println();
		
		System.out.println("MAIN Locking Count DST");
		synchronized(countDst) {
			System.out.println("MAIN Waiting Count DST");
			countDst.wait(100);
		}
		System.out.println("Count DST: " + countDst.toString());
		
	}
	
	private static class CountTransfer implements Runnable {

		private Count countSrc;
		private Count countDst;
		
		private int amount;
		
		public CountTransfer(Count countSrc, Count countDst, int amount) {
			this.countSrc = countSrc;
			this.countDst = countDst;
			this.amount = amount;
		}
		
		@Override
		public void run() {
			
			System.out.println("THREAD Locking Count SRC");
			synchronized(countSrc) {
				System.out.println("THREAD Withdrawing Count SRC");
				for(int i=0; i<amount; i++) {
					countSrc.withdraw(1);
				}
				System.out.println("THREAD Notifying Count SRC");
				countSrc.notify();
			}
			
			Thread.yield();
			
			System.out.println("THREAD Locking Count DST");
			synchronized(countDst) {
				System.out.println("THREAD Depositing Count SRC");
				for(int i=0; i<amount; i++) {
					countDst.deposit(1);
				}
				System.out.println("THREAD Notifying Count DST");
				countDst.notify();
			}
			
		}
		
	}
	
	private static class Count {
		
		private int money = 0;
		
		public Count(int money) {
			this.money = money;
		}
		public Count() { this(0); }
		
		public void deposit(int amount) {
			money += amount;
		}
		
		public void withdraw(int amount) {
			money -= amount;
		}
		
		public String toString() {
			return money + " USD";
		}
		
	}
	
}
