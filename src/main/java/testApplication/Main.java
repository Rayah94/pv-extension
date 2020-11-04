package testApplication;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.gas.DefaultGasProvider;

import blockchain.Connector;
import blockchain.ContractHandler;
import commitment.BasicHashCommitter;
import commitment.HashCommitment;
import contracts.generated.Test;
import io.TranscriptWriter;

public class Main {

	public static void main(String[] args) {
		
		String password = "1234";
		String mnemonic = "candy maple cake sugar pudding cream honey rich smooth crumble sweet treat";
		
		TranscriptWriter writer = new TranscriptWriter("contract.txt");
		//Connector connector = new Connector(mnemonic, password);
		BasicHashCommitter committer = new BasicHashCommitter();
		//ContractHandler handler = new ContractHandler(connector, new BigInteger("1"), new BigInteger("1"), new BigInteger("10000"));

		//writer.writeTanscript(handler.getContractAddress());
		writer.close();
		
		String challenge = "3";
		HashCommitment commitmentChallenge = committer.commit(challenge.getBytes(StandardCharsets.UTF_8));
		commitmentChallenge.setMessage(challenge);
		
		String seed = "12345";
		HashCommitment commitmentSeed = committer.commit(seed.getBytes(StandardCharsets.UTF_8));
		byte[] arr = seed.getBytes(StandardCharsets.UTF_8);
		for(int i = 0; i < arr.length; i++) {
			System.out.println(Byte.toString(arr[i]));
		}
		
		commitmentSeed.setMessage(seed);
		
		/*handler.init();
		
		handler.commitChallenge(commitmentChallenge.getCommitment());
		
		handler.commitSeed(commitmentSeed.getCommitment(), new BigInteger("1"));
		
		handler.openChallenge(commitmentChallenge.getMessage(), commitmentChallenge.getSecret());
		
		handler.openSeed(commitmentSeed.getMessage(), commitmentSeed.getSecret(), new BigInteger("1"));*/

	}

}
