package commitment;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

import org.bouncycastle.crypto.Commitment;
import org.bouncycastle.crypto.Committer;

public class BasicHashCommitter implements Committer {
	
	private MessageDigest digest;
	
	public BasicHashCommitter() {
		try {
			digest = MessageDigest.getInstance("SHA-256");
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Commitment commit(byte[] message) {
		byte[] nonce = new byte[32];
		new SecureRandom().nextBytes(nonce);
		byte[] adding = calculateAdding(message, nonce);
		
		byte[] commitment = digest.digest(adding);
		
		
		return new Commitment(nonce, commitment);
	}

	@Override
	public boolean isRevealed(Commitment commitment, byte[] message) {
		byte[] adding = calculateAdding(message, commitment.getSecret());
		
		return Arrays.equals(commitment.getCommitment(), digest.digest(adding));
	}
	
	private byte[] calculateAdding(byte[] message, byte[] nonce) {
		byte[] adding = new byte[message.length];
		
		for(int i = 0; i < message.length; i++) {
			adding[i] = (byte) (message[i] + nonce[i % nonce.length]);
		}
		
		return adding;
	}

}
