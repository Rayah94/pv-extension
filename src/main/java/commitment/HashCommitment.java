package commitment;

import org.bouncycastle.crypto.Commitment;

public class HashCommitment extends Commitment {
	
	private byte[] message;

	public HashCommitment(byte[] secret, byte[] commitment, byte[] message) {
		super(secret, commitment);
	}

	public byte[] getMessage() {
		return message;
	}

	public void setMessage(byte[] message) {
		this.message = message;
	}

}
