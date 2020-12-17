package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Random;

import commitment.BasicHashCommitter;
import commitment.HashCommitment;
import io.TranscriptWriter;

public class PVClient implements Runnable {
	
	private static final String INPUT_DIVIDER = ";";
	private static final String ARRAY_DIVIDER = ",";
	
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
	
	static final int sessionRounds = 5;
	
	private String transcriptPre;
	
	
	private HashCommitment challengeCommitment;
	private HashCommitment[] seedCommitments;
	
	private long start;
	
	public PVClient(int clientNumber, String mnemonic, String password, 
			String contractAddress, int numberOfParticipants, int numberOfSessions, 
			int portNumberPV, String hostNamePV, int portNumberMsg, String hostNameMsg) {
		
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
			start = System.currentTimeMillis();
			System.out.println("Client" + this.clientNumber + " starts");
			
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
	        	String fromClient = mnemonic + INPUT_DIVIDER + password + INPUT_DIVIDER + contractAddress + INPUT_DIVIDER + numberOfSessions;
	        	System.out.println("Client" + this.clientNumber + " sending init");
	        	outPV.println(fromClient);
	        	inPV.readLine();
	        	System.out.println("Client" + this.clientNumber + " got init");
	        	
	        	// sample challenge and send to PVserver
	        	challengeCommitment = sampleChallenge();
	        	fromClient = challengeCommitment.toString(INPUT_DIVIDER, ARRAY_DIVIDER).split(INPUT_DIVIDER)[0];
	        	System.out.println("Client" + this.clientNumber + " sending commit Challenge: " + challengeCommitment.getMessage());
	        	outPV.println(fromClient);
	        	//System.out.println("Client" + clientNumber + " got from PVServer: " + inPV.readLine());
	        	inPV.readLine();
	        	System.out.println("Client" + this.clientNumber + " send challenge");
	        	
	        	// sample seed and send to PVserver
	        	seedCommitments = sampleSeeds();
	        	System.out.println("Client" + this.clientNumber + " sending commits");
	        	for(int i = 0; i < this.numberOfSessions; i++) {
	        		fromClient = i + INPUT_DIVIDER + seedCommitments[i].toString(INPUT_DIVIDER, ARRAY_DIVIDER).split(INPUT_DIVIDER)[0];
	        		//System.out.println("Client" + clientNumber + " sending to PVServer: " + fromClient);
		        	outPV.println(fromClient);
		        	//System.out.println("Client" + clientNumber + " got from PVServer: " + inPV.readLine());
		        	inPV.readLine();
		        	
	        	}
	        	System.out.println("Client" + this.clientNumber + " sent seeds");
	        	
	        	// do jointly for each session x times of interaction with the other parties
	        	System.out.println("Client" + this.clientNumber + " starts transcript");
	        	String[] transcripts = new String[numberOfSessions];
	        	for(int i = 0; i < numberOfSessions; i++) {
	        		Random random = new Random(Integer.parseInt(seedCommitments[i].getMessage()));
	        		String transcript = "";
	        		String[] msgs = new String[numberOfParticipants];
	        		for(int j = 0; j < sessionRounds; j++) {
	        			// send own message
	        			int next = random.nextInt();
	        			String myMessage = this.clientNumber + INPUT_DIVIDER + next;
	        			msgs[this.clientNumber] = next + "";
	        			outMsg.println(myMessage);
	        			
	        			// receive other messages
	        			for(int m = 0; m < numberOfParticipants - 1; m++) {
	        				String[] incoming = inMsg.readLine().split(INPUT_DIVIDER);
	        				msgs[Integer.parseInt(incoming[0])] = incoming[1];
	        			}
	        			
	        			// save msgs for writing
	        			for(int m = 0; m < numberOfParticipants; m++) {
	        				transcript += msgs[m];
	        				
	        				if(m == (numberOfParticipants - 1)) {
	        					transcript += System.lineSeparator();
	        				} else {
	        					transcript += ARRAY_DIVIDER;
	        				}
	        			}
	        		}
	        		// write transcript of session i
	        		TranscriptWriter writer = new TranscriptWriter(transcriptPre + this.clientNumber + i);
	        		writer.writeTanscript(transcript);
	        		writer.close();
	        		transcripts[i] = transcript;
	        	}
	        	
	        	outMsg.println("FINNISH");
	        	/*
	        	// check transcript of others
	        	for(int i = 0; i < numberOfSessions; i++) {
	        		// send own transcript
	        		outMsg.println(this.clientNumber + INPUT_DIVIDER + transcripts[i]);
	        		for( int m = 0; m < numberOfParticipants - 1; m++) {
	        			String[] incoming = inMsg.readLine().split(INPUT_DIVIDER);
	        			
	        			if(!transcripts[i].equals(incoming[1])) {
	        				System.out.println("Transcripts not the same: Client" + this.clientNumber + "got:" + System.lineSeparator() + transcripts[i]);
	        				System.out.println("Client" + incoming[0] + "got: " + System.lineSeparator() + incoming[1]);
	        			}
	        		}
	        	} */
	        	System.out.println("Client" + this.clientNumber + " did transcripts");
	        	
	        	
	        	// open challenge commitments
	        	fromClient = challengeCommitment.toString(INPUT_DIVIDER, ARRAY_DIVIDER).split(INPUT_DIVIDER)[2] + INPUT_DIVIDER + challengeCommitment.toString(INPUT_DIVIDER, ARRAY_DIVIDER).split(INPUT_DIVIDER)[1];
	        	System.out.println("Client" + this.clientNumber + " sending open challenge");
	        	outPV.println(fromClient);
	        	//System.out.println("Client" + clientNumber + " got from PVServer: " + inPV.readLine());
	        	inPV.readLine();
	        	System.out.println("Client" + this.clientNumber + " opened challenge");
	        	
	        	// receive challenge
	        	fromClient = "Receive challenge";
	        	System.out.println("Client" + this.clientNumber + " receive challenge");
	        	outPV.println(fromClient);
	        	String challenge = inPV.readLine();
	        	System.out.println("Client" + clientNumber + " got from PVServer Challenge: " + challenge);
	        	int calcSession = Integer.parseInt(challenge);
	        	System.out.println("Client" + this.clientNumber + " received challenge");
	        	
	        	// open seeds for all sessions except challenge session
	        	System.out.println("Client" + this.clientNumber + " open seeds");
	        	for(int i = 0; i < this.numberOfSessions; i++) {
	        		if(i != calcSession) {
	        			fromClient = i + INPUT_DIVIDER + seedCommitments[i].toString(INPUT_DIVIDER, ARRAY_DIVIDER).split(INPUT_DIVIDER)[2] + INPUT_DIVIDER + seedCommitments[i].toString(INPUT_DIVIDER, ARRAY_DIVIDER).split(INPUT_DIVIDER)[1];
	        			//System.out.println("Client" + clientNumber + " sending to PVServer: " + fromClient);
			        	outPV.println(fromClient);
			        	//System.out.println("Client" + clientNumber + " got from PVServer: " + inPV.readLine());
			        	inPV.readLine();
	        		}
	        	}
	        	
	        	System.out.println("Client" + this.clientNumber + " finnished!");
	        	outPV.println("Protocol finnished");
	        	System.out.println("Client" + this.clientNumber + " took "+ (System.currentTimeMillis()- start)/1000 + " seconds");

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
		SecureRandom random = new SecureRandom();
		int challenge = random.nextInt(this.numberOfSessions);
		
		BasicHashCommitter committer = new BasicHashCommitter();
		HashCommitment commit = committer.commit(("" + challenge)
				.getBytes(StandardCharsets.UTF_8));
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
}
