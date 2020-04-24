package school.cesar.ppcd.av1.ex2;
import java.util.concurrent.Semaphore;

public class Main {
	public static void main(String[] args) {
		
		Semaphore mutex = new Semaphore(1);
		FakeLongTask fakeLongTask = new FakeLongTask(mutex);
		Thread threadFakeLongTask = new Thread(fakeLongTask);
		threadFakeLongTask.start();
			
		synchronized(mutex){
			try {
				System.out.println("waiting...");
				mutex.wait();
				System.out.println("done!");
			} catch (Exception e) {
				//TODO: handle exception
			}
		}
		// System.out.println("teste");
	}
}
