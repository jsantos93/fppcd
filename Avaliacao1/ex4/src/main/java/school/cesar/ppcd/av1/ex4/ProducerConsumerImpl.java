package school.cesar.ppcd.av1.ex4;

import java.util.List;
import java.util.LinkedList;

public class ProducerConsumerImpl implements ProducerConsumer {

	private List<SomeRequest> queue = new LinkedList();
	private final int BUFFER_SIZE = 2;

	public synchronized void produce(SomeRequest request) {
		while (this.queue.size() == this.BUFFER_SIZE) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.queue.add(request);
		if (this.queue.size() == 1) {
			notifyAll();
		}

	}

	public synchronized SomeRequest consume() {
		while (this.queue.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(this.queue.size() == this.BUFFER_SIZE){
			notifyAll();
		}
	  
		return this.queue.remove(0);
		
	}

}
