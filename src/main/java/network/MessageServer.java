package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MessageServer implements Runnable {
	
	private int[] portNumbers;
	private ServerSocket[] serverSockets;
	private Socket[] clientSockets;
	private PrintWriter[] outWriter;
	private BufferedReader[] inReader;
	

	/**
	 * Builds a new msg Server listening to the ports and accepting the first connection
	 * @param portNumbers array of the ports
	 */
	public MessageServer(int[] portNumbers) {
		this.portNumbers = portNumbers;
		serverSockets = new ServerSocket[portNumbers.length];
		clientSockets = new Socket[portNumbers.length];
		outWriter = new PrintWriter[portNumbers.length];
		inReader = new BufferedReader[portNumbers.length];
	}
	
	@Override
	public void run() {
		
		try {
			// start all sockets
			for (int i = 0; i < portNumbers.length; i++) {
				serverSockets[i] = new ServerSocket(portNumbers[i]);
			}
			for (int i = 0; i < portNumbers.length; i++) {
				clientSockets[i] = serverSockets[i].accept();
			}
			for (int i = 0; i < portNumbers.length; i++) {
				outWriter[i] =
	                    new PrintWriter(clientSockets[i].getOutputStream(), true);
	            inReader[i] = new BufferedReader(
	                    new InputStreamReader(clientSockets[i].getInputStream()));
	            
	            outWriter[i].println("Connected!");
			}
			
			// broadcast all messages
			boolean running = true;
			while(running) {
				
				for(int i = 0; i < portNumbers.length; i++) {
					String input = "";
					try {
					input = inReader[i].readLine();
					} catch(IOException closed) {
						continue;
					}
					
					if(input.equals("FINNISH")) {
						outWriter[i].close();
						inReader[i].close();
						clientSockets[i].close();
						serverSockets[i].close();
					}
					
					for(int j = 0; j < portNumbers.length; j++) {
						if(j != i) {
							outWriter[j].println(input);
						}
					}
				}
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
