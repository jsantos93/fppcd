package school.cesar.ppcd.av1.ex1.server;

import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Semaphore;

public class SharedCounterServerRunnable implements Runnable {
	private final Socket client;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	private static final byte[] INC = new byte[] { 'I' };
	private static Semaphore mutex = new Semaphore(1);
	private static int valor = 0;
	public SharedCounterServerRunnable(final Socket client) throws IOException{
		this.client = client;
		this.dataInputStream = new DataInputStream(client.getInputStream());
		this.dataOutputStream = new DataOutputStream(client.getOutputStream());
	}

	public void run() {
		try {
			while(true){
				if(this.dataInputStream.read(INC) == 1){
					try {
						mutex.acquire();
						int valorAtual = valor;
						valor++;
						this.dataOutputStream.writeInt(valorAtual);
						mutex.release();
						TimeUnit.SECONDS.sleep(1);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
