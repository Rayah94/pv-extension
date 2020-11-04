package commitment;

import org.bouncycastle.crypto.Commitment;

public class HashCommitment extends Commitment {
	
	private String message;

	public HashCommitment(byte[] secret, byte[] commitment) {
		super(secret, commitment);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
