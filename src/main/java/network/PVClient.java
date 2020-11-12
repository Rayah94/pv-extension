package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

import commitment.BasicHashCommitter;
import commitment.HashCommitment;

public class PVClient {
	
	private static final int INIT = 0;
	private static final int COMMIT_CHALLENGE = 1;
	private static final int COMMIT_SEED = 2;
	private static final int TRANSCRIPT_WRITING = 3;
	private static final int OPEN_CHALLENGE = 4;
	private static final int RETURN_CHALLENGE = 5;
	private static final int OPEN_SEED = 6;
	private static final int FINNISHED = 7;
	
	private static final String INPUT_DIVIDER = ";";
	private static final String ARRAY_DIVIDER = ",";
	
	private static int state = INIT;
	
	public static void main(String[] args) throws IOException {
         
	        /*if (args.length != 2) {
	            System.err.println(
	                "Usage: java EchoClient <host name> <port number>");
	            System.exit(1);
	        }*/
	 
	        //String hostName = args[0];
	        //int portNumber = Integer.parseInt(args[1]);
	        String hostName = null;
	        int portNumber = 4444;
	 
	        try (
	            Socket pvSocket = new Socket(hostName, portNumber);
	            PrintWriter out = new PrintWriter(pvSocket.getOutputStream(), true);
	            BufferedReader in = new BufferedReader(
	                new InputStreamReader(pvSocket.getInputStream()));
	        ) {
	            BufferedReader stdIn =
	                new BufferedReader(new InputStreamReader(System.in));
	            String fromServer;
	            String fromUser;
	            String console;
	 
	            while ((fromServer = in.readLine()) != null) {
	                System.out.println("Server: " + fromServer);
	                if (fromServer.equals("Protocol finnished"))
	                    break;
	                 
	                fromUser = nextStep();
	                console = stdIn.readLine();
	                if (fromUser != null) {
	                    System.out.println("Client: " + fromUser);
	                    System.out.println("Console: " + console);
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
	
	private static String nextStep() {
		String password = "1234";
		String mnemonic = "candy maple cake sugar pudding cream honey rich smooth crumble sweet treat";
		String contractAddress = "0xbfa021d5c973d0a3c5ab9a4d6605689ab3af50ca";
		String transcriptPre = "test";
		String sessions = "1";
		String challenge = "1";
		String seed = "12345";
		HashCommitment commitment;
		BasicHashCommitter committer;
		
		switch(state) {
		case INIT: state = COMMIT_CHALLENGE; return mnemonic + INPUT_DIVIDER + password + INPUT_DIVIDER + contractAddress + INPUT_DIVIDER + transcriptPre + INPUT_DIVIDER + sessions;
		case COMMIT_CHALLENGE: state = COMMIT_SEED; committer = new BasicHashCommitter(); commitment = committer.commit(challenge.getBytes(StandardCharsets.UTF_8)); return commitment.toString(INPUT_DIVIDER, ARRAY_DIVIDER).split(INPUT_DIVIDER)[0];
		case COMMIT_SEED: state = TRANSCRIPT_WRITING; committer = new BasicHashCommitter(); commitment = committer.commit(seed.getBytes(StandardCharsets.UTF_8)); return sessions + INPUT_DIVIDER + commitment.toString(INPUT_DIVIDER, ARRAY_DIVIDER).split(INPUT_DIVIDER)[0];
		case TRANSCRIPT_WRITING: state = OPEN_CHALLENGE; return sessions + INPUT_DIVIDER + "bvalblab";
		case OPEN_CHALLENGE: state = RETURN_CHALLENGE; committer = new BasicHashCommitter(); commitment = committer.commit(challenge.getBytes(StandardCharsets.UTF_8)); commitment.setMessage(challenge); return commitment.toString(INPUT_DIVIDER, ARRAY_DIVIDER).split(INPUT_DIVIDER)[2] + INPUT_DIVIDER + commitment.toString(INPUT_DIVIDER, ARRAY_DIVIDER).split(INPUT_DIVIDER)[1];
		case RETURN_CHALLENGE: state = OPEN_SEED; return "";
		case OPEN_SEED: state = FINNISHED; committer = new BasicHashCommitter(); commitment = committer.commit(seed.getBytes(StandardCharsets.UTF_8)); return sessions + INPUT_DIVIDER + commitment.toString(INPUT_DIVIDER, ARRAY_DIVIDER).split(INPUT_DIVIDER)[2] + INPUT_DIVIDER + commitment.toString(INPUT_DIVIDER, ARRAY_DIVIDER).split(INPUT_DIVIDER)[1];
		case FINNISHED:
		default: return "Ende";
		}
	}
}
