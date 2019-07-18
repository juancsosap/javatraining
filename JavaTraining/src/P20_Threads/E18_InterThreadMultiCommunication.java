package P20_Threads;

public class E18_InterThreadMultiCommunication {

	public static void main(String[] args) throws InterruptedException {

		Product product = new Product();
		
		Thread tp = new Thread(new Producer(product));
		
		Thread tc1 = new Thread(new Consumer(product, "Consumer 1"));
		Thread tc2 = new Thread(new Consumer(product, "Consumer 2"));
		Thread tc3 = new Thread(new Consumer(product, "Consumer 3"));
		Thread tc4 = new Thread(new Consumer(product, "Consumer 4"));
		
		tp.start();
		
		tc1.start();
		tc2.start();
		tc3.start();
		tc4.start();
		
	}
	
	private static class Product {
		
		public String value;
		
	}
	
	private static class Producer implements Runnable {

		private Product product;
		
		public Producer(Product product) {
			this.product = product;
		}
		
		@Override
		public void run() {
			
			synchronized(product) {
				product.value = "Message";
				product.notifyAll();
			}
			
		}
		
	}

	private static class Consumer implements Runnable {

		private Product product;
		private String name;
		
		public Consumer(Product product, String name) {
			this.product = product;
			this.name = name;
		}
		
		@Override
		public void run() {
			
			synchronized(product) {
				
				if(product.value == null) {
					try {
						product.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				System.out.println(product.value + " : " + name);
				
			}
			
		}
		
	}
	
}
