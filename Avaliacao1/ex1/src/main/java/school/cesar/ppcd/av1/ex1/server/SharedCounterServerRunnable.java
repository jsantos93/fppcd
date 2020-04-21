package school.cesar.ppcd.av1.ex1.server;

import java.net.Socket;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Semaphore;

public class SharedCounterServerRunnable implements Runnable {
	private final Socket client;
	private static Semaphore mutex = new Semaphore(1);
	private static int valor = 0;
	public SharedCounterServerRunnable(final Socket client) {
		this.client = client;
	}

	public void run() {
		while (true) {
			try {
				mutex.acquire();
				try{
					int valorAtual = valor;
					valor++;
					String nome = Thread.currentThread().getName();
					System.out.println(nome + " : " + valorAtual);
				} finally{
					mutex.release();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
