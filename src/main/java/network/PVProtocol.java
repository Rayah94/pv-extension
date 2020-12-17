package network;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.utils.Convert.Unit;

import blockchain.Connector;
import blockchain.ContractHandler;

public class PVProtocol {
	
	private static final int INIT = 0;
	private static final int COMMIT_CHALLENGE = 1;
	private static final int COMMIT_SEED = 2;
	//private static final int TRANSCRIPT_WRITING = 3;
	private static final int OPEN_CHALLENGE = 3;
	private static final int RETURN_CHALLENGE = 4;
	private static final int OPEN_SEED = 5;
	private static final int FINNISHED = 6;
	
	private static final String INPUT_DIVIDER = ";";
	private static final String ARRAY_DIVIDER = ",";
	
	private int state = INIT;
	
	private Connector connector;
	private ContractHandler handler;
	
	//private String transcriptPrefix;
	private int numberSessions;
	private int currentRound;
	
	private BigDecimal balanceStart;
	
	public PVProtocol() {
		super();
		currentRound = 1;
	}
	
	public String processInput(String theInput) {
		String result = "";
		
		switch(state) {
		case INIT: result = init(theInput).toString(); state = COMMIT_CHALLENGE; break; // mnemonic, password, address, number sessions
		
		case COMMIT_CHALLENGE: result = commitChallenge(theInput).toString(); state = COMMIT_SEED; break; // challenge (nur com(challenge))
		
		case COMMIT_SEED: result = commitSeed(theInput).toString(); currentRound++; state = currentRound <= numberSessions ? COMMIT_SEED : OPEN_CHALLENGE; break; // session, seed (nur com(seed))
		
		//case TRANSCRIPT_WRITING: writeTranscript(theInput); result = "written"; state = OPEN_CHALLENGE; currentRound = 1; break; // session, message in a formatted way
		
		case OPEN_CHALLENGE: result = openChallenge(theInput).toString(); currentRound = 1; state = RETURN_CHALLENGE; break; // challenge, secret
		
		case RETURN_CHALLENGE: result = returnChallenge(); state = OPEN_SEED; break; // return challenge session e
		
		case OPEN_SEED: result = openSeed(theInput).toString(); currentRound++; state = currentRound < numberSessions ? OPEN_SEED : FINNISHED; break; // session, seed, secret
		
		case FINNISHED: result = "Protocol finnished"; break;
		}
		
		return result;
	}
	
	private TransactionReceipt init(String input) {
		String[] inputs = input.split(INPUT_DIVIDER);
		
		connector = new Connector(inputs[0], inputs[1]);
		handler = new ContractHandler(connector, inputs[2]);
		numberSessions = Integer.parseInt(inputs[3]);
		
		balanceStart = connector.getBalance(Unit.ETHER);
		
		return handler.init();
	}
	
	private TransactionReceipt commitChallenge(String input) {
		String[] inputs = input.split(INPUT_DIVIDER);
		String[] array = inputs[0].split(ARRAY_DIVIDER);
		
		byte[] commit = new byte[array.length];
		
		for(int i = 0; i < array.length; i++) {
			commit[i] = Byte.parseByte(array[i]);
		}
		
		try {
			while(!handler.getContract().phase().send().equals(new BigInteger("1")))	{
				Thread.sleep(100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return handler.commitChallenge(commit);
	}
	
	private TransactionReceipt commitSeed(String input) {
		String[] inputs = input.split(INPUT_DIVIDER);
		String[] array = inputs[1].split(ARRAY_DIVIDER);
		
		byte[] commit = new byte[array.length];
		
		for(int i = 0; i < array.length; i++) {
			commit[i] = Byte.parseByte(array[i]);
		}
		
		try {
			while(!handler.getContract().phase().send().equals(new BigInteger("2")))	{
				Thread.sleep(100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return handler.commitSeed(commit, new BigInteger(inputs[0]));
	}
	
	/*private void writeTranscript(String input) {
		String[] inputs = input.split(INPUT_DIVIDER);
		
		TranscriptWriter writer = new TranscriptWriter(transcriptPrefix + inputs[0]);
		writer.writeTanscript(inputs[1]);
		writer.close();
	}*/
	
	private TransactionReceipt openChallenge(String input) {
		String[] inputs = input.split(INPUT_DIVIDER);
		String[] array = inputs[1].split(ARRAY_DIVIDER);
		
		byte[] secret = new byte[array.length];
		
		for(int i = 0; i < array.length; i++) {
			secret[i] = Byte.parseByte(array[i]);
		}
		
		try {
			while(!handler.getContract().phase().send().equals(new BigInteger("3")))	{
				Thread.sleep(100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return handler.openChallenge(inputs[0], secret);
	}
	
	private String returnChallenge() {
		try {
			while(!handler.getContract().phase().send().equals(new BigInteger("4")))	{
				Thread.sleep(100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String[] challenges = handler.getChallenges();
		int result = 0;
		for(int i = 0; i < challenges.length; i++) {
			result += Integer.parseInt(challenges[i]);
		}
		result = result % numberSessions;
		return "" + result;
	}
	
	private TransactionReceipt openSeed(String input) {
		String[] inputs = input.split(INPUT_DIVIDER);
		String[] array = inputs[2].split(ARRAY_DIVIDER);
		
		byte[] secret = new byte[array.length];
		
		for(int i = 0; i < array.length; i++) {
			secret[i] = Byte.parseByte(array[i]);
		}
		
		try {
			while(!handler.getContract().phase().send().equals(new BigInteger("4")))	{
				Thread.sleep(100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		TransactionReceipt result = handler.openSeed(inputs[1], secret, new BigInteger(inputs[0]));
		
		System.out.println("Costs: " + balanceStart.subtract(connector.getBalance(Unit.ETHER)));
		
		return result;
	}
}
