package testApplication;

import java.math.BigInteger;

import blockchain.Connector;
import blockchain.ContractHandler;
import network.MessageServer;
import network.PVClient;

public class Main {

	// geth --datadir test-chain-dir --rpc --dev --rpcapi "eth,net,web3,personal,miner"
	// eth.sendTransaction({from:eth.coinbase, to:"0x2fe9f56859cf9f71db24ca975ebb43dc8a551b12", value: web3.toWei(1, "ether")})
	// eth.sendTransaction({from:eth.coinbase, to:"0x7199d0a4b96d83250e86f0e09e8b2007caa14bd9", value: web3.toWei(1, "ether")})
	
	public static void main(String[] args) {
		
		String password = "1234";
		String mnemonic = "candy maple cake sugar pudding cream honey rich smooth crumble sweet treat"; // 0x2fe9f56859cf9f71db24ca975ebb43dc8a551b12
		String mnemonic1 = "maple cake sugar pudding cream honey rich smooth crumble sweet treat candy"; // 0x7199d0a4b96d83250e86f0e09e8b2007caa14bd9
		String mnemonic2 = "cake sugar pudding cream honey rich smooth crumble sweet treat candy maple"; // 0xf879ca17be1c3f696a7feb5845f78055163e02f8
		String mnemonic3 = "sugar pudding cream honey rich smooth crumble sweet treat candy maple cake"; // 0x15fd708972fa9af91f86f0c36f7930f1f234730d
		String mnemonic4 = "pudding cream honey rich smooth crumble sweet treat candy maple cake sugar"; // 0x42158522f0059205c09a9bb603199b37e38a2b2f
		String mnemonic5 = "cream honey rich smooth crumble sweet treat candy maple cake sugar pudding"; // 0xa70ed10efa1465c4f8ae2e5421866bf9a0546b0d
		String mnemonic6 = "honey rich smooth crumble sweet treat candy maple cake sugar pudding cream"; // 0x5afb97afd1be809a2ec719e90b9cec6b4a99cb7c
		String mnemonic7 = "rich smooth crumble sweet treat candy maple cake sugar pudding cream honey"; // 0x5a48f615d3bc3b27323f9e0354f85669e18a1a7c
		String mnemonic8 = "smooth crumble sweet treat candy maple cake sugar pudding cream honey rich"; // 0x21295ecbfac2e401b8cc13251be1966b081ad51b
		String mnemonic9 = "crumble sweet treat candy maple cake sugar pudding cream honey rich smooth "; // 0x21eb4dc8c65ccf10f235961bbc4565c442e3aee1
		String mnemonic10 = "sweet treat candy maple cake sugar pudding cream honey rich smooth crumble"; // 0xdf080fee0de40c24181b8e523923b1d7f83652de
		Connector connector = new Connector(mnemonic, password);
		
		
		//System.out.println(connector.getAccountCredentials().getAddress());

		
		ContractHandler handler = new ContractHandler(connector, new BigInteger("3"), new BigInteger("100"), new BigInteger("10000"));
		
		System.out.println(handler.getContractAddress());
		
		
		String address = handler.getContractAddress();
		
		int[] msgPorts = {4445, 4447, 4449};
		
		Runnable client1 = new PVClient(0, mnemonic1, password, address, 3, 100, 4444, null, 4445, null);
		Runnable client2 = new PVClient(1, mnemonic2, password, address, 3, 100, 4446, null, 4447, null);
		Runnable client3 = new PVClient(2, mnemonic3, password, address, 3, 100, 4448, null, 4449, null);
		Runnable client4 = new PVClient(3, mnemonic4, password, address, 10, 100, 4450, null, 4451, null);
		Runnable client5 = new PVClient(4, mnemonic5, password, address, 10, 100, 4452, null, 4453, null);
		Runnable client6 = new PVClient(5, mnemonic6, password, address, 10, 100, 4454, null, 4455, null);
		Runnable client7 = new PVClient(6, mnemonic7, password, address, 10, 100, 4456, null, 4457, null);
		Runnable client8 = new PVClient(7, mnemonic8, password, address, 10, 100, 4458, null, 4459, null);
		Runnable client9 = new PVClient(8, mnemonic9, password, address, 10, 100, 4460, null, 4461, null);
		Runnable client10 = new PVClient(9, mnemonic10, password, address, 10, 100, 4462, null, 4463, null);
		
		Runnable msgServer = new MessageServer(msgPorts);
		
		Thread msgServerThread = new Thread(msgServer);
		msgServerThread.start();
		
		Thread clientThread1 = new Thread(client1);
		Thread clientThread2 = new Thread(client2);
		Thread clientThread3 = new Thread(client3);
		Thread clientThread4 = new Thread(client4);
		Thread clientThread5 = new Thread(client5);
		Thread clientThread6 = new Thread(client6);
		Thread clientThread7 = new Thread(client7);
		Thread clientThread8 = new Thread(client8);
		Thread clientThread9 = new Thread(client9);
		Thread clientThread10 = new Thread(client10);
		
		clientThread1.start();
		clientThread2.start();
		clientThread3.start();
		/*clientThread4.start();
		clientThread5.start();
		clientThread6.start();
		clientThread7.start();
		clientThread8.start();
		clientThread9.start();
		clientThread10.start();
		//*/
	}

}
