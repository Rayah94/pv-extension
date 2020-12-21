package blockchain;

import java.math.BigInteger;

import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.response.PollingTransactionReceiptProcessor;
import org.web3j.tx.response.TransactionReceiptProcessor;

import contracts.generated.PVContract;

public class ContractHandler {
	
	private Connector connector;
	private PVContract contract;
	
	private BigInteger numberOfParticipants;
	
	
	public ContractHandler(Connector connector, String address) {
		this.connector = connector;
		contract = connector.loadContract(address);
		try {
			numberOfParticipants = contract.n().send();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Builds a new Contract handler which directly deploys a new PVContract to the local blockchain
	 * @param connector connector object
	 * @param numberOfParticipants
	 * @param sessions
	 * @param timeOffset
	 */
	public ContractHandler(Connector connector, BigInteger numberOfParticipants, BigInteger sessions, BigInteger timeOffset) {
		this.connector = connector;
		try {
			contract = connector.deployContract(numberOfParticipants, sessions, timeOffset);
			this.numberOfParticipants = numberOfParticipants;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public TransactionReceipt init() {
		TransactionReceipt txReceipt = null;
		try {
			//TransactionReceipt receipt = contract.init().send();
			txReceipt = contract.init().send();
			//String txHash = receipt.getTransactionHash();
			
			//TransactionReceiptProcessor receiptProcessor =
	                new PollingTransactionReceiptProcessor(connector.getWeb3j(), TransactionManager.DEFAULT_POLLING_FREQUENCY,
	                        TransactionManager.DEFAULT_POLLING_ATTEMPTS_PER_TX_HASH);

			//txReceipt = receiptProcessor.waitForTransactionReceipt(txHash);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return txReceipt;
	}
	
	public TransactionReceipt commitChallenge(byte[] commit) {
		TransactionReceipt txReceipt = null;
		try {
			//TransactionReceipt receipt = contract.commitChallenge(commit).send();
			txReceipt = contract.commitChallenge(commit).send();
			//String txHash = receipt.getTransactionHash();
			
			//TransactionReceiptProcessor receiptProcessor =
	                new PollingTransactionReceiptProcessor(connector.getWeb3j(), TransactionManager.DEFAULT_POLLING_FREQUENCY,
	                        TransactionManager.DEFAULT_POLLING_ATTEMPTS_PER_TX_HASH);

			//txReceipt = receiptProcessor.waitForTransactionReceipt(txHash);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return txReceipt;
	}
	
	public TransactionReceipt commitSeed(byte[] commit, BigInteger session) {
		TransactionReceipt txReceipt = null;
		try {
			//TransactionReceipt receipt = contract.commitSeed(commit, session).send();
			txReceipt = contract.commitSeed(commit, session).send();
			//String txHash = receipt.getTransactionHash();
			
			//TransactionReceiptProcessor receiptProcessor =
	                new PollingTransactionReceiptProcessor(connector.getWeb3j(), TransactionManager.DEFAULT_POLLING_FREQUENCY,
	                        TransactionManager.DEFAULT_POLLING_ATTEMPTS_PER_TX_HASH);

			//txReceipt = receiptProcessor.waitForTransactionReceipt(txHash);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return txReceipt;
	}
	
	public TransactionReceipt openChallenge(String open, byte[] secret) {
		TransactionReceipt txReceipt = null;
		try {
			//TransactionReceipt receipt = contract.openChallenge(open, secret).send();
			txReceipt = contract.openChallenge(open, secret).send();
			//String txHash = receipt.getTransactionHash();
			
			//TransactionReceiptProcessor receiptProcessor =
	                new PollingTransactionReceiptProcessor(connector.getWeb3j(), TransactionManager.DEFAULT_POLLING_FREQUENCY,
	                        TransactionManager.DEFAULT_POLLING_ATTEMPTS_PER_TX_HASH);

			//txReceipt = receiptProcessor.waitForTransactionReceipt(txHash);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return txReceipt;
	}
	
	public TransactionReceipt openSeed(String open, byte[] secret, BigInteger session) {
		TransactionReceipt txReceipt = null;
		try {
			//TransactionReceipt receipt = contract.openSeed(open, secret, session).send();
			txReceipt = contract.openSeed(open, secret, session).send();
			//String txHash = receipt.getTransactionHash();
			
			//TransactionReceiptProcessor receiptProcessor =
	                new PollingTransactionReceiptProcessor(connector.getWeb3j(), TransactionManager.DEFAULT_POLLING_FREQUENCY,
	                        TransactionManager.DEFAULT_POLLING_ATTEMPTS_PER_TX_HASH);

			//txReceipt = receiptProcessor.waitForTransactionReceipt(txHash);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return txReceipt;
	}
	
	public String[] getChallenges() {
		int n = numberOfParticipants.intValueExact();
		String[] challenges = new String[n];
		
		for (Integer i = 0; i < n; i++) {
			try {
				challenges[i] = contract.challengeCommitments(contract.adresses(new BigInteger(i.toString())).send()).send().component2();
				System.out.println(challenges[i]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return challenges;
	}
	
	/**
	 * Returns the contract address of the deployed contract
	 * @return address of contract
	 */
	public String getContractAddress() {
		return contract.getContractAddress();
	}
	
	public PVContract getContract() {
		return contract;
	}

}
