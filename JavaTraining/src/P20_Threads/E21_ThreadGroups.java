package P20_Threads;

import java.util.Arrays;

public class E21_ThreadGroups {

	/*
	 *  System Thread Group
	 *  -> Finalizer Thread
	 *  -> Reference Handler Thread
	 *  -> Signal Dispatcher Thread
	 *  -> Attack Listener Thread 
	 * 
	 *  Main Thread Group (main <- system)
	 *  -> Main Thread
	 *  -> ... other Threads
	 *  
	 *  ... Other Thread Groups (xxxx <- main)
	 *  -> ... more Threads
	 *  
	 */
	
	public static void main(String[] args) throws InterruptedException {

		Runnable task = () -> {
			Thread t = Thread.currentThread();
			String name = t.getName();
			int priority = t.getPriority();
			System.out.println("Thread Name: " + name);
			System.out.println("Thread Priority: " + priority);
			
			ThreadGroup tg = t.getThreadGroup();
			String group = tg.getName();
			int grouppriority = tg.getMaxPriority();
			System.out.println("Thread Group Name: " + group);
			System.out.println("Thread Group Max Priority: " + grouppriority);
			
			ThreadGroup tpg = tg.getParent();
			String parentgroup = tpg.getName();
			System.out.println("Parent Thread Group Name: " + parentgroup);
			int activethreads = tpg.activeCount(); 
			System.out.println("Active Threads: " + activethreads);
			Thread[] tl = new Thread[activethreads];
			tpg.enumerate(tl);
			Arrays.asList(tl).forEach(th -> System.out.println("> " + th.toString() + "(" + th.isDaemon() + ")"));
			int activegroups = tpg.activeGroupCount(); 
			System.out.println("Active Groups: " + activegroups);
			ThreadGroup[] gl = new ThreadGroup[activegroups];
			tpg.enumerate(gl);
			Arrays.asList(gl).forEach(thg -> System.out.println("> " + thg.toString() + "(" + thg.isDaemon() + ")"));
			
			if(!name.equals("main"))
				try {
					Thread.sleep(1_000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
		};
		
		ThreadGroup tg0 = new ThreadGroup("ThreadGroup-0");
		ThreadGroup tg1 = new ThreadGroup(tg0, "ThreadGroup-1");
		
		Thread[] threads = new Thread[5]; 
		
		threads[0] = new Thread(task);
		threads[1] = new Thread(tg0, task);
		threads[2] = new Thread(tg1, task);
		
		tg1.setMaxPriority(3);
		
		threads[3] = new Thread(tg1, task);
		threads[4] = new Thread(tg1, task);
		
		threads[4].setPriority(7);
		
		for(Thread th : threads) {
			th.start();
			Thread.sleep(10);
			
			System.out.println();
		}
		
		task.run();
		
		System.out.println();
		
		Thread.currentThread().getThreadGroup().getParent().list();
		
	}
	
}
