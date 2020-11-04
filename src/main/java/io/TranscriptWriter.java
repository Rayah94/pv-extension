package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TranscriptWriter {
	
	private FileWriter fileWriter;
	private boolean exists = false;
	
	/**
	 * Opens a new Writer with the given Transciptname
	 * @param transcriptname the Transscripts filename
	 */
	public TranscriptWriter(String transcriptname) {
		
		try {
			File file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\transcripts\\" + transcriptname);
			fileWriter = new FileWriter(System.getProperty("user.dir") + "\\src\\main\\resources\\transcripts\\" + transcriptname);
			exists = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Writes to the specified file name
	 *
	 * @param message the message to write
	 * @return true if successfully written
	 */
	public boolean writeTanscript(String message) {
		
		try {
			fileWriter.write(message);
			fileWriter.write("\n");
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public void close() {
		try {
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean exists() {
		return exists;
	}

}
