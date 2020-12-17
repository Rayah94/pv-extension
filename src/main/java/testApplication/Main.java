package testApplication;

import java.math.BigInteger;

import blockchain.Connector;
import blockchain.ContractHandler;
import network.MessageServer;
import network.PVClient;

public class Main {

	// geth --datadir test-chain-dir --rpc --dev --rpcapi "eth,net,web3,personal,miner"
	public static void main(String[] args) {
		
		String password = "1234";
		String mnemonic = "candy maple cake sugar pudding cream honey rich smooth crumble sweet treat"; // 0x2fe9f56859cf9f71db24ca975ebb43dc8a551b12
		String mnemonic1 = "maple cake sugar pudding cream honey rich smooth crumble sweet treat candy"; // 0x7199d0a4b96d83250e86f0e09e8b2007caa14bd9
		String mnemonic2 = "cake sugar pudding cream honey rich smooth crumble sweet treat candy maple"; // 0xf879ca17be1c3f696a7feb5845f78055163e02f8
		String mnemonic3 = "sugar pudding cream honey rich smooth crumble sweet treat candy maple cake"; // 0x15fd708972fa9af91f86f0c36f7930f1f234730d
		Connector connector = new Connector(mnemonic, password);
		//System.out.println(connector.getAccountCredentials().getAddress());
		ContractHandler handler = new ContractHandler(connector, new BigInteger("3"), new BigInteger("3"), new BigInteger("100"));
		
		System.out.println(handler.getContractAddress());
		String address = handler.getContractAddress();
		
		int[] msgPorts = {4445, 4447, 4449};
		
		Runnable client1 = new PVClient(0, mnemonic1, password, address, 3, 3, 4444, null, 4445, null);
		Runnable client2 = new PVClient(1, mnemonic2, password, address, 3, 3, 4446, null, 4447, null);
		Runnable client3 = new PVClient(2, mnemonic3, password, address, 3, 3, 4448, null, 4449, null);
		
		Runnable msgServer = new MessageServer(msgPorts);
		
		Thread msgServerThread = new Thread(msgServer);
		msgServerThread.start();
		
		Thread clientThread1 = new Thread(client1);
		Thread clientThread2 = new Thread(client2);
		Thread clientThread3 = new Thread(client3);
		clientThread1.start();
		clientThread2.start();
		clientThread3.start();
		
		/*BasicHashCommitter committer = new BasicHashCommitter();
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
		
		handler.init();
		
		handler.commitChallenge(commitmentChallenge.getCommitment());
		
		handler.commitSeed(commitmentSeed.getCommitment(), new BigInteger("1"));
		
		handler.openChallenge(commitmentChallenge.getMessage(), commitmentChallenge.getSecret());
		
		handler.openSeed(commitmentSeed.getMessage(), commitmentSeed.getSecret(), new BigInteger("1"));//*/

	}

}
