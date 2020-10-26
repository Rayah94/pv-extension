package testApplication;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

import blockchain.Connector;
import blockchain.ContractHandler;
import commitment.BasicHashCommitter;
import commitment.HashCommitment;
import io.TranscriptWriter;

public class Main {

	public static void main(String[] args) {
		
		String password = "1234";
		String mnemonic = "candy maple cake sugar pudding cream honey rich smooth crumble sweet treat";
		
		TranscriptWriter writer = new TranscriptWriter("contract");
		Connector connector = new Connector(mnemonic, password);
		BasicHashCommitter committer = new BasicHashCommitter();
		ContractHandler handler = new ContractHandler(connector, new BigInteger("1"), new BigInteger("10000"));
		handler.init();

		writer.writeTanscript(handler.getContractAddress());
		writer.close();
			
		HashCommitment commitmentChallenge = committer.commit("3".getBytes(StandardCharsets.UTF_8));
		handler.commitChallenge(commitmentChallenge.getCommitment(), new BigInteger("1"));
		
		HashCommitment commitmentSeed = committer.commit("12345".getBytes(StandardCharsets.UTF_8));
		handler.commitSeed(commitmentSeed.getCommitment(), new BigInteger("1"));
		
		handler.openChallenge(commitmentChallenge.getMessage(), commitmentChallenge.getSecret(), new BigInteger("1"));
		
		handler.openSeed(commitmentSeed.getMessage(), commitmentSeed.getSecret(), new BigInteger("1"));

	}

}
