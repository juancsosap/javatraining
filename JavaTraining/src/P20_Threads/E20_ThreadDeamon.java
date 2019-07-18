package P20_Threads;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.StandardWatchEventKinds.*;

public class E20_ThreadDeamon {

	public static void main(String[] args) throws Exception {

		Path DIR = Paths.get("files");
		DirectoryWatcher.Listener client = new  DirectoryListener();
		DirectoryWatcher watcher = new DirectoryWatcher(DIR, client);
		
		watcher.setDaemon(true);
		watcher.start();
		
		Thread.sleep(1);
		
		Path file = DIR.resolve("myfile.test");
		
		if(Files.exists(file))
			Files.delete(file);
		
		Files.createFile(file);			
		
		List<String> lines = Arrays.asList("Testing File", "Remove It");
		Files.write(file, lines);
		
		watcher.shutdown();
		 
	}
	
	private static class DirectoryListener implements DirectoryWatcher.Listener {

		@Override
		public void receive(String eventKind, Path file) {
			System.out.println("Event: " + eventKind);
			System.out.println("Element: " + file.toString());
			System.out.println();
		}
		
	}
	
	private static class DirectoryWatcher extends Thread {
		
		private boolean enable = false;
		private WatchService watcher;
		
		private Listener client;
		private Path path;
		
		public DirectoryWatcher(Path path, Listener client) throws IOException {
			this.client = client;
			this.path = path;
		}
		
		public void run() {
			if(!this.enable)  {
				System.out.println("Starting Watcher ...");
				this.enable = true;
				try {
					this.watcher = FileSystems.getDefault().newWatchService();
					this.path.register(this.watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
					deamon();
				} catch (IOException | InterruptedException ex) {
					ex.printStackTrace();
				} 
			} else
				System.out.println("Watcher is already started");
		}
		
		public void shutdown() throws IOException {
			if(this.enable) {
				this.enable = false;
			} else
				throw new IOException("Watcher wasn't started still");
		}
		
		public void deamon() throws IOException, InterruptedException {
			while(this.enable) {
				
				// Wait until some event arrive
				WatchKey key = this.watcher.take();
				
				List<WatchEvent<?>> events = key.pollEvents();
				
				for(WatchEvent<?> event : events) {
					Kind<?> eventType = event.kind();
					Path file = (Path) event.context();
					this.client.receive(eventType.name(), file);
				}
				
				if(!key.reset()) break;
			}
			this.watcher.close();
		}
		
		public interface Listener {
			
			public void receive(String eventKind, Path file);
			
		}
		
	}

}
