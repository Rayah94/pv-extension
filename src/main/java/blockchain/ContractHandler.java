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
	
	public ContractHandler(Connector connector, BigInteger numberOfParticipants, BigInteger timeOffset) {
		this.connector = connector;
		try {
			contract = connector.deployContract(numberOfParticipants, timeOffset);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ContractHandler(Connector connector, String address) {
		this.connector = connector;
		contract = connector.loadContract(address);
	}
	
	public TransactionReceipt init() {
		TransactionReceipt txReceipt = null;
		try {
			TransactionReceipt receipt = contract.init().send();
			String txHash = receipt.getTransactionHash();
			
			TransactionReceiptProcessor receiptProcessor =
	                new PollingTransactionReceiptProcessor(connector.getWeb3j(), TransactionManager.DEFAULT_POLLING_FREQUENCY,
	                        TransactionManager.DEFAULT_POLLING_ATTEMPTS_PER_TX_HASH);

			txReceipt = receiptProcessor.waitForTransactionReceipt(txHash);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return txReceipt;
	}
	
	public TransactionReceipt commitChallenge(byte[] commit, BigInteger session) {
		TransactionReceipt txReceipt = null;
		try {
			TransactionReceipt receipt = contract.commitChallenge(commit, session).send();
			String txHash = receipt.getTransactionHash();
			
			TransactionReceiptProcessor receiptProcessor =
	                new PollingTransactionReceiptProcessor(connector.getWeb3j(), TransactionManager.DEFAULT_POLLING_FREQUENCY,
	                        TransactionManager.DEFAULT_POLLING_ATTEMPTS_PER_TX_HASH);

			txReceipt = receiptProcessor.waitForTransactionReceipt(txHash);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return txReceipt;
	}
	
	public TransactionReceipt commitSeed(byte[] commit, BigInteger session) {
		TransactionReceipt txReceipt = null;
		try {
			TransactionReceipt receipt = contract.commitSeed(commit, session).send();
			String txHash = receipt.getTransactionHash();
			
			TransactionReceiptProcessor receiptProcessor =
	                new PollingTransactionReceiptProcessor(connector.getWeb3j(), TransactionManager.DEFAULT_POLLING_FREQUENCY,
	                        TransactionManager.DEFAULT_POLLING_ATTEMPTS_PER_TX_HASH);

			txReceipt = receiptProcessor.waitForTransactionReceipt(txHash);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return txReceipt;
	}
	
	public TransactionReceipt openChallenge(byte[] open, byte[] secret, BigInteger session) {
		TransactionReceipt txReceipt = null;
		try {
			TransactionReceipt receipt = contract.openChallenge(open, secret, session).send();
			String txHash = receipt.getTransactionHash();
			
			TransactionReceiptProcessor receiptProcessor =
	                new PollingTransactionReceiptProcessor(connector.getWeb3j(), TransactionManager.DEFAULT_POLLING_FREQUENCY,
	                        TransactionManager.DEFAULT_POLLING_ATTEMPTS_PER_TX_HASH);

			txReceipt = receiptProcessor.waitForTransactionReceipt(txHash);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return txReceipt;
	}
	
	public TransactionReceipt openSeed(byte[] open, byte[] secret, BigInteger session) {
		TransactionReceipt txReceipt = null;
		try {
			TransactionReceipt receipt = contract.openSeed(open, secret, session).send();
			String txHash = receipt.getTransactionHash();
			
			TransactionReceiptProcessor receiptProcessor =
	                new PollingTransactionReceiptProcessor(connector.getWeb3j(), TransactionManager.DEFAULT_POLLING_FREQUENCY,
	                        TransactionManager.DEFAULT_POLLING_ATTEMPTS_PER_TX_HASH);

			txReceipt = receiptProcessor.waitForTransactionReceipt(txHash);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return txReceipt;
	}
	
	public String getContractAddress() {
		return contract.getContractAddress();
	}

}
