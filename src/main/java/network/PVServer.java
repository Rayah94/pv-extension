package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.web3j.utils.Convert.Unit;

import blockchain.Connector;

public class PVServer implements Runnable {
	int portNumber;
	
	public PVServer(int portNumber) {
		this.portNumber = portNumber;
	}

    public void run() {
        
        try ( 
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out =
                    new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            ) {
            
                String inputLine, outputLine;
                
                // Initiate conversation with client
                PVProtocol pvp = new PVProtocol();
                out.println("Connected!");

                while ((inputLine = in.readLine()) != null) {
                    outputLine = pvp.processInput(inputLine);
                    out.println(outputLine);
                    if (outputLine.equals("Protocol finnished")) {
                    	Connector connector = pvp.getConnector();
                    	System.out.println("Costs: " + connector.balance.subtract(connector.getBalance(Unit.GWEI)));
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
                System.out.println(e.getMessage());
            }
        
    }
}
