package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MessageClient implements Runnable {
	
	int id;
	
	int portNumber;
	String hostName;
	
	public MessageClient(int portNumber, int id) {
		this.portNumber = portNumber;
		this.id = id;
		this.hostName = null;
	}

	@Override
	public void run() {
 
        try (
            Socket pvSocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(pvSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(pvSocket.getInputStream()));
        ) {
            String fromServer;
            String fromUser;
 
            while ((fromServer = in.readLine()) != null) {
                System.out.println("Client" + id + " got from Server: " + fromServer);
                
                try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
                fromUser = "" + Math.random();
                
                if (fromUser != null) {
                    System.out.println("Client" + id +" is sending: " + fromUser);
                    out.println(fromUser);
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        }
	}

}
