package testApplication;

import java.math.BigInteger;

import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import blockchain.Connector;
import blockchain.ContractHandler;
import contracts.generated.Test;
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
		String mnemonic4 = "pudding cream honey rich smooth crumble sweet treat candy maple cake sugar";
		String mnemonic5 = "cream honey rich smooth crumble sweet treat candy maple cake sugar pudding";
		String mnemonic6 = "honey rich smooth crumble sweet treat candy maple cake sugar pudding cream";
		String mnemonic7 = "rich smooth crumble sweet treat candy maple cake sugar pudding cream honey";
		String mnemonic8 = "smooth crumble sweet treat candy maple cake sugar pudding cream honey rich";
		String mnemonic9 = "crumble sweet treat candy maple cake sugar pudding cream honey rich smooth ";
		String mnemonic10 = "sweet treat candy maple cake sugar pudding cream honey rich smooth crumble";
		Connector connector = new Connector(mnemonic, password);
		
		
		//System.out.println(connector.getAccountCredentials().getAddress());

		
		ContractHandler handler = new ContractHandler(connector, new BigInteger("3"), new BigInteger("10"), new BigInteger("100"));
		
		System.out.println(handler.getContractAddress());
		
		
		String address = handler.getContractAddress();
		
		int[] msgPorts = {4445, 4447, 4449};
		
		Runnable client1 = new PVClient(0, mnemonic1, password, address, 3, 10, 4444, null, 4445, null);
		Runnable client2 = new PVClient(1, mnemonic2, password, address, 3, 10, 4446, null, 4447, null);
		Runnable client3 = new PVClient(2, mnemonic3, password, address, 3, 10, 4448, null, 4449, null);
		/*
		 * Runnable client4 = new PVClient(3, mnemonic4, password, address, 3, 3, 4450, null, 4451, null);
		 * Runnable client5 = new PVClient(4, mnemonic5, password, address, 3, 3, 4452, null, 4453, null);
		 * Runnable client6 = new PVClient(5, mnemonic6, password, address, 3, 3, 4454, null, 4455, null);
		 * Runnable client7 = new PVClient(6, mnemonic7, password, address, 3, 3, 4456, null, 4457, null);
		 * Runnable client8 = new PVClient(7, mnemonic8, password, address, 3, 3, 4458, null, 4459, null);
		 * Runnable client9 = new PVClient(8, mnemonic9, password, address, 3, 3, 4460, null, 4461, null);
		 * Runnable client10 = new PVClient(9, mnemonic10, password, address, 3, 3, 4462, null, 4463, null);
		 * 
		 */
		
		Runnable msgServer = new MessageServer(msgPorts);
		
		Thread msgServerThread = new Thread(msgServer);
		msgServerThread.start();
		
		Thread clientThread1 = new Thread(client1);
		Thread clientThread2 = new Thread(client2);
		Thread clientThread3 = new Thread(client3);
		clientThread1.start();
		clientThread2.start();
		clientThread3.start();
		//*/
	}

}
