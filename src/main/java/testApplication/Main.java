package testApplication;

import java.nio.charset.StandardCharsets;

import org.bouncycastle.crypto.Commitment;

import commitment.BasicHashCommitter;

public class Main {

	public static void main(String[] args) {
		
		System.out.println(System.getProperty("user.dir"));

		BasicHashCommitter committer = new BasicHashCommitter();
		
		Commitment com = committer.commit("Meine Nachricht ist sehr lang".getBytes(StandardCharsets.UTF_8));
		System.out.println(com.getCommitment());
		
		System.out.println("Revealed? " + committer.isRevealed(com, "Meine Nachricht ist sehr lang".getBytes(StandardCharsets.UTF_8)));
	}

}
