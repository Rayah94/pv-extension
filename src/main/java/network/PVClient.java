package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import commitment.BasicHashCommitter;
import commitment.HashCommitment;

public class PVClient implements Runnable {
	
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
	
	private int portNumberPV;
	private String hostNamePV;
	
	private int portNumberMsg;
	private String hostNameMsg;
	
	private int clientNumber;
	private String contractAddress;
	
	private String mnemonic;
	private String password;
	
	int numberOfParticipants;
	int numberOfSessions;
	
	private String transcriptPre;
	
	
	private HashCommitment challengeCommitment;
	private HashCommitment[] seedCommitments;
	
	public PVClient(int clientNumber, String mnemonic, String password, String contractAddress, int numberOfParticipants, int numberOfSessions, int portNumberPV, String hostNamePV, int portNumberMsg, String hostNameMsg) {
		this.clientNumber = clientNumber;
		this.mnemonic = mnemonic;
		this.password = password;
		this.contractAddress = contractAddress;
		this.numberOfParticipants = numberOfParticipants;
		this.numberOfSessions = numberOfSessions;
		this.portNumberPV = portNumberPV;
		this.hostNamePV = hostNamePV;
		this.portNumberMsg = portNumberMsg;
		this.hostNameMsg = hostNameMsg;
		this.transcriptPre = "test" + clientNumber;
	}
	
	public void run() {       
	        // start own PVServer
	        Runnable pvServer = new PVServer(portNumberPV);
	        Thread server = new Thread(pvServer);
	        server.start();
	 
	        try (
	        	// connect to PVServer
	            Socket pvSocket = new Socket(hostNamePV, portNumberPV);
	            PrintWriter outPV = new PrintWriter(pvSocket.getOutputStream(), true);
	            BufferedReader inPV = new BufferedReader(
	                new InputStreamReader(pvSocket.getInputStream()));
	        		
	        	// connect to MsgServer
	        	Socket msgSocket = new Socket(hostNameMsg, portNumberMsg);
	        	PrintWriter outMsg = new PrintWriter(msgSocket.getOutputStream(), true);
	        	BufferedReader inMsg = new BufferedReader(
	        		new InputStreamReader(msgSocket.getInputStream()));
	        ) {
	        	System.out.println("Client" + clientNumber + " got from PVServer: " + inPV.readLine());
	        	System.out.println("Client" + clientNumber + " got from MsgServer: " + inMsg.readLine());
	        	
	        	// send init to PVserver
	        	String fromClient = mnemonic + INPUT_DIVIDER + password + INPUT_DIVIDER + contractAddress + INPUT_DIVIDER + transcriptPre + INPUT_DIVIDER + numberOfSessions;
	        	System.out.println("Client" + clientNumber + " sending to PVServer: " + fromClient);
	        	outPV.println(fromClient);
	        	System.out.println("Client" + clientNumber + " got from PVServer: " + inPV.readLine());
	        	
	        	// sample challenge and send to PVserver
	        	challengeCommitment = sampleChallenge();
	        	fromClient = challengeCommitment.toString(INPUT_DIVIDER, ARRAY_DIVIDER).split(INPUT_DIVIDER)[0];
	        	System.out.println("Client" + clientNumber + " sending to PVServer: " + fromClient);
	        	outPV.println(fromClient);
	        	System.out.println("Client" + clientNumber + " got from PVServer: " + inPV.readLine());
	        	
	        	// sample seed and send to PVserver
	        	seedCommitments = sampleSeeds();
	        	for(int i = 0; i < this.numberOfSessions; i++) {
	        		fromClient = i + INPUT_DIVIDER + seedCommitments[i].toString(INPUT_DIVIDER, ARRAY_DIVIDER).split(INPUT_DIVIDER)[0];
	        		System.out.println("Client" + clientNumber + " sending to PVServer: " + fromClient);
		        	outPV.println(fromClient);
		        	System.out.println("Client" + clientNumber + " got from PVServer: " + inPV.readLine());
	        	}
	        	
	        	// do jointly for each session x times of interaction with the other parties
	        	//TODO
	        	// check transcript of others
	        	//TODO
	        	// sign Transcript + session + contract Address
	        	//TODO
	        	// open challenge commitments
	        	fromClient = challengeCommitment.toString(INPUT_DIVIDER, ARRAY_DIVIDER).split(INPUT_DIVIDER)[2] + INPUT_DIVIDER + challengeCommitment.toString(INPUT_DIVIDER, ARRAY_DIVIDER).split(INPUT_DIVIDER)[1];
	        	System.out.println("Client" + clientNumber + " sending to PVServer: " + fromClient);
	        	outPV.println(fromClient);
	        	System.out.println("Client" + clientNumber + " got from PVServer: " + inPV.readLine());
	        	
	        	// receive challenge
	        	fromClient = "Receive challenge";
	        	System.out.println("Client" + clientNumber + " sending to PVServer: " + fromClient);
	        	outPV.println(fromClient);
	        	String challenge = inPV.readLine();
	        	System.out.println("Client" + clientNumber + " got from PVServer: " + challenge);
	        	int calcSession = Integer.parseInt(challenge);
	        	
	        	// open seeds for all sessions except challenge session
	        	for(int i = 0; i < this.numberOfSessions; i++) {
	        		if(i != calcSession) {
	        			fromClient = i + INPUT_DIVIDER + seedCommitments[i].toString(INPUT_DIVIDER, ARRAY_DIVIDER).split(INPUT_DIVIDER)[2] + INPUT_DIVIDER + seedCommitments[i].toString(INPUT_DIVIDER, ARRAY_DIVIDER).split(INPUT_DIVIDER)[1];
	        			System.out.println("Client" + clientNumber + " sending to PVServer: " + fromClient);
			        	outPV.println(fromClient);
			        	System.out.println("Client" + clientNumber + " got from PVServer: " + inPV.readLine());
	        		}
	        	}
	        	
	        	
	        	
	        	
	            BufferedReader stdIn =
	                new BufferedReader(new InputStreamReader(System.in));
	            String fromServer;
	            String fromUser;
	            String console;
	 
	            while ((fromServer = inPV.readLine()) != null) {
	                System.out.println("Server: " + fromServer);
	                if (fromServer.equals("Protocol finnished"))
	                    break;
	                 
	                fromUser = nextStep();
	                console = stdIn.readLine();
	                if (fromUser != null) {
	                    System.out.println("Client: " + fromUser);
	                    System.out.println("Console: " + console);
	                    outPV.println(fromUser);
	                }
	            }
	        } catch (UnknownHostException e) {
	            System.err.println("Don't know about host " + hostNamePV);
	            System.exit(1);
	        } catch (IOException e) {
	            System.err.println("Couldn't get I/O for the connection to " +
	                hostNamePV);
	            System.exit(1);
	        }
	 }
	
	private HashCommitment sampleChallenge() {
		Random random = new Random();
		int challenge = random.nextInt(this.numberOfSessions);
		
		BasicHashCommitter committer = new BasicHashCommitter();
		HashCommitment commit = committer.commit(("" + challenge).getBytes(StandardCharsets.UTF_8));
		commit.setMessage("" + challenge);
		return commit;
	}
	
	private HashCommitment[] sampleSeeds() {
		Random random = new Random();
		HashCommitment[] commits = new HashCommitment[this.numberOfSessions];
		BasicHashCommitter committer = new BasicHashCommitter();
		
		for(int i = 0; i < this.numberOfSessions; i++) {
			int seed = random.nextInt();
			commits[i] = committer.commit(("" + seed).getBytes(StandardCharsets.UTF_8));
			commits[i].setMessage("" + seed);
		}
		
		return commits;
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
