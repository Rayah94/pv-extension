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
	
	/**
	 * 
	 * @param divider
	 * @param arrayDivider
	 * @return commitment, secret, message
	 */
	public String toString(String divider, String arrayDivider) {
		String result = "";
		byte[] secret = getSecret();
		byte[] commitment = getCommitment();
		
		for(int i = 0; i < commitment.length; i++) {
			result += commitment[i];
			if(i + 1 != commitment.length) {
				result += arrayDivider;
			}
		}
		result += divider;
		for(int i = 0; i < secret.length; i++) {
			result += secret[i];
			if(i + 1 != secret.length) {
				result += arrayDivider;
			}
		}
		result += divider;
		result += getMessage();
		
		return result;
	}

}
