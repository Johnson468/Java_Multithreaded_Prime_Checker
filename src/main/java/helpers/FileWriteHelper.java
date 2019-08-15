package helpers;

import java.io.File;
import java.io.FileWriter;

import org.pmw.tinylog.Logger;

public class FileWriteHelper implements Runnable{
	String path;
	String filePath;
	String file;
	File f;
	private Thread t;
	private String threadName = "second thread";
	int n;
	public FileWriteHelper(String path, String file, int n) {
		this.path = path;
		this.n = n;
		this.file = file;
		this.filePath = path + file;
		f = new File(filePath);
	}
	@Override
	public void run() {
		try {
			Thread t = Thread.currentThread();
			FileWriter fw = new FileWriter(f, true);
			Logger.info("Writing: {}", n);
			fw.write(String.valueOf(n) + "\n");
			fw.close();
		} catch (Exception e) {
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
