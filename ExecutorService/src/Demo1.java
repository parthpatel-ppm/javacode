import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Demo1 {

	public static void main(String[] args) {

		// create pool
		// core count
		int corecount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(corecount);
        
        /*ExecutorService service = Executors.newCachedThreadPool();
        ScheduledExecutorService service1 = Executors.newScheduledThreadPool(10);
        service1.schedule(new Task(),10 , TimeUnit.SECONDS );
        service1.scheduleAtFixedRate(new Task(), 10, 15, TimeUnit.SECONDS);
        service1.scheduleWithFixedDelay(new Task(), 10, 15, TimeUnit.SECONDS); */
        
        //submit tasks
        for(int i=0;i<100;i++) {
        	service.execute(new Task());
        }
		//System.out.println("Thread Name:" + Thread.currentThread().getName());

	}
    static class Task implements Runnable {
    	public void run() {
    		System.out.println("Thread Name:" + Thread.currentThread().getName());
    	}
    }
}
