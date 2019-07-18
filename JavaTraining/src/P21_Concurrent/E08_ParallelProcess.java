package P21_Concurrent;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class E08_ParallelProcess {

	public static void main(String[] args) {

		LocalDateTime ini = LocalDateTime.now();
		
		int numberThreads = Runtime.getRuntime().availableProcessors() * 16;
		
		ExecutorService pool = Executors.newFixedThreadPool(numberThreads);
		
		Path DIR = Paths.get("files", "downloads");
		
		if(Files.notExists(DIR))
			try {
				Files.createDirectories(DIR);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		
		final int MAX = 200;
		for(int i=1; i<MAX; i++) {
			String fileName = "rfc" + i + ".txt";
			String url = "https://www.rfc-editor.org/rfc/" + fileName;
			try {
				URL website = new URL(url);
				Path target = DIR.resolve(fileName);
				
				//(new Downloader(website, target)).run();
				pool.submit(new Downloader(website, target));
			} catch (MalformedURLException ex) {
				ex.printStackTrace();
			}
		}
		
		pool.shutdown();
		
		while(!pool.isTerminated()) {}
		
		LocalDateTime end = LocalDateTime.now();
		
		System.out.println();
		
		System.out.println("Total Downloaded Files: " + Downloader.completed);
		System.out.printf("Execution Time: %,.2f sg\n", (double) Duration.between(ini, end).toMillis()/1000);
		System.out.println("Number of thread used: " + numberThreads);
	}
	
	private static class Downloader implements Runnable {

		private static int count = 0;
		public static int completed = 0;
		
		private URL website;
		private Path target;
		
		public Downloader(URL website, Path target) {
			this.website = website;
			this.target = target;
		}
		
		@Override
		public void run() {
			synchronized(Downloader.class) { count++; }
			try(InputStream in = website.openStream()){
				System.out.println(count + " - Downloading: " + target.getFileName());
				Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
				System.out.println(count + " - Downloaded: " + target.getFileName());
				completed++;
			} catch (IOException ex) {
				System.out.println(count + " - Aborting: " + target.getFileName());
			}
			synchronized(Downloader.class) { count--; }
		}
		
	}
	
}
