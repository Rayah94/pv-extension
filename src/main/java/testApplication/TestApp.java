package testApplication;

import network.MessageClient;
import network.MessageServer;
import network.PVClient;
import network.PVServer;

public class TestApp {

	public static void main(String[] args) {
		/*Runnable server1 = new PVServer(4444);
		Runnable server2 = new PVServer(4445);
		Runnable server3 = new PVServer(4446);
		
		Thread serverThread1 = new Thread(server1);
		serverThread1.start();
		
		Thread serverThread2 = new Thread(server2);
		serverThread2.start();
		
		Thread serverThread3 = new Thread(server3);
		serverThread3.start();
		
		Runnable client = new PVClient(4444, null, "0");
		
		Thread clientThread = new Thread(client);
		clientThread.start();*/
		
		int[] ports = {4444, 4445};
		
		Runnable server = new MessageServer(ports);
		
		Thread serverThread = new Thread(server);
		serverThread.start();
		
		Runnable client0 = new MessageClient(ports[0], 0);
		Runnable client1 = new MessageClient(ports[1], 1);
		
		Thread clientThread0 = new Thread(client0);
		clientThread0.start();
		
		Thread clientThread1 = new Thread(client1);
		clientThread1.start();
	}

}
