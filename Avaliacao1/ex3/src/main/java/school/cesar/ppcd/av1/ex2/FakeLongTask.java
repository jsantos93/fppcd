package school.cesar.ppcd.av1.ex2;

import static school.cesar.ppcd.av1.ex2.Util.nap;
import java.util.concurrent.Semaphore;

public class FakeLongTask implements Runnable {
	// private boolean done = false;
	private static final long ONE_MINUTE = 60 * 1000;
	private Semaphore mutex; 

	public FakeLongTask(Semaphore mutex) {
		this.mutex = mutex;
	}

	public void run() {
		try {
			synchronized(mutex){
				nap(ONE_MINUTE);
				mutex.notify();
			}
			
		} catch (Exception e) {

		}
		
		
	}
	// public boolean isDone() {
	// 	return done;
	// }
}
