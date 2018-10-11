package P20_Threads;

public class E01_Introduction {

	/*
	 *     NEW       t = new Thread();
	 *    BORN       
	 *      | 
	 *      |        t.start();
	 *      |
	 *      V
	 *    READY <--- *
	 *   RUNNABLE
	 *      |
	 *      |        Thread Scheduler allocate resources
	 *      |
	 *      V
	 *   RUNNING     Under Execution of run() method
	 *  |  |  |  |  |
	 *  |  |  |  |  #
	 *  |  |  |  |
	 *  |  |  |  |   Thread.yield();
	 *  |  |  |  |
	 *  |  |  |  *
	 *  |  |  |
	 *  |  |  |      Thread.sleep(Milliseconds, Nanoseconds = 0);
	 *  |  |  |  
	 *  |  |  V
	 *  |  | SLEEP
	 *  |  |  |
	 *  |  |  |      Time Expired
	 *  |  |  |      t.interrupt();
	 *  |  |  |
	 *  |  |  *
	 *  |  |
	 *  |  |         t2.join();
	 *  |  |         t2.join(Milliseconds, Nanoseconds = 0);
	 *  |  |
	 *  |  V
	 *  | WAITING      
	 *  |  |
	 *  |  |         Waited Thread Completed
	 *  |  |         Waited Thread Interrupted 
	 *  |  |         Time Expired
	 *  |  |
	 *  |  V
	 *  |  *   
	 *  | 
	 *  |            obj.wait();
	 *  |            obj.wait(Milliseconds, Nanoseconds = 0);
	 *  | 
	 *  V    
	 *  WAITING
	 *  NOTIFY  
	 *  |
	 *  |            Receive a notify via obj.notify(); or obj.notifyAll();
	 *  |
	 *  V
	 *  *  
	 *   
	 *      #        
	 *      |
	 *      V
	 *     DEAD      run() method completed
	 * 
	 */
	
	// A thread only could be executed one time
	
}
