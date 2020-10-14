package blockchain;

import java.math.BigDecimal;

import org.web3j.crypto.Bip32ECKeyPair;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.MnemonicUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;

public class Connector {
	
	private Credentials accountCredentials;
	private Web3j web3j;
	
	public Connector() {
		
	}
	
	public Connector(String mnemonic, String password) {
		initiate(mnemonic, password);
	}
	
	public void initiate(String mnemonic, String password) {
		  //Derivation path wanted: // m/44'/60'/0'/0
		  int[] derivationPath = {44 | Bip32ECKeyPair.HARDENED_BIT, 60 | Bip32ECKeyPair.HARDENED_BIT, 0 | Bip32ECKeyPair.HARDENED_BIT, 0,0};

		  // Generate a BIP32 master keypair from the mnemonic phrase
		  Bip32ECKeyPair masterKeypair = Bip32ECKeyPair.generateKeyPair(MnemonicUtils.generateSeed(mnemonic, password));

		  // Derived the key using the derivation path
		  Bip32ECKeyPair  derivedKeyPair = Bip32ECKeyPair.deriveKeyPair(masterKeypair, derivationPath);

		  // Load the wallet for the derived key
		  accountCredentials = Credentials.create(derivedKeyPair);
		  web3j = Web3j.build(new HttpService("http://localhost:8545"));
	}
	
	public BigDecimal getBalance(Convert.Unit unit) {
		BigDecimal result = new BigDecimal(0);
		try {
			result = Convert.fromWei(web3j.ethGetBalance(accountCredentials.getAddress(), DefaultBlockParameterName.LATEST).send().getBalance().toString(), unit);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error while getting Balance of Account: " + accountCredentials.getAddress());
		}
		return result;
	}
	
	//TODO implement loading a the contract
	
	public Credentials getAccountCredentials() {
		return accountCredentials;
	}
	
	public Web3j getWeb3j() {
		return web3j;
	}
	
}
