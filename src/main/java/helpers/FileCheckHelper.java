package helpers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.pmw.tinylog.Logger;

public class FileCheckHelper implements Runnable {

	String threadName = "yeet";
	private Thread t;
	String filePath;
	
	public FileCheckHelper(String path, String fileName) {
		String filePath = path + fileName;
		this.filePath = filePath;
		
	}
	/**
	 * Checks for the existance of, or sets up the files needed for this application
	 */
	@Override
	public void run() {
		Logger.info("Checking file: {} in thread: {}", filePath, t.getId());
		File f = new File(filePath);
		if (f.exists() && f.isFile()) {
			return;
		}
		try {
			FileWriter fw = new FileWriter(f);
			fw.write(String.valueOf(1));
			fw.close();
		} catch (IOException e) {
			Logger.error(e.getMessage());
		}	
		
	}
	public void start() {
		if ( t == null) {
			t = new Thread (this, threadName);
			t.start();
		}
	}

}
