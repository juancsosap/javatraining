package WebScanner;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class WebScanner {
	
	private CopyOnWriteArrayList<String> urls = new CopyOnWriteArrayList<>();
	private String site, target, temp, folder, ext;
	private AtomicInteger index = new AtomicInteger();
	
	public WebScanner(String url, String target, String temp, String folder, String ext) {
		urls.add(url);
		this.site = url;
		this.target = target;
		this.temp = temp;
		this.folder = folder;
		this.ext = ext;
	}
	
	public void analize() {
		int i = index.getAndIncrement();
		if(i < urls.size()) {
			String url = urls.get(i);
			String folder = Url.getFolder(url);
			Path file = download(url, folder);
			scanUrls(url, file);
			analize();
		}
	}
	
	public Path download(String url, String folder) {
		try {
			URL website = new URL(url);
			String fileName = Url.getFileName(url);

			Path DIR = null;
			
			if(url.contains(site) && Url.getExt(url).equalsIgnoreCase("html"))
				DIR = Paths.get(this.temp + folder);

			if(url.contains(target) && ext.contains(Url.getExt(url)))
				DIR = Paths.get(this.folder + folder);
			
			if(DIR != null) {
				System.out.println("INI: " + url);
				Path target = DIR.resolve(fileName);
				
				if(Files.notExists(DIR))
					Files.createDirectories(DIR);
				
				try(InputStream in = website.openStream()){
					Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
				}
				
				return target;
			}
			
			return null;
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	public void scanUrls(String current, Path path) {
		try {
			if(path != null) {
				List<String> lines = Files.readAllLines(path);
				
				lines.stream().parallel()
				     .filter(l -> l.contains("<a"))
				     .flatMap(l -> Stream.of(l.split("[ >]")))
		             .filter(l -> l.startsWith("href"))
		             .flatMap(l -> Stream.of(l.split("[\"']")))
		             .filter(l -> !l.startsWith("href"))
		             .filter(l -> !l.startsWith("javascript"))
		             .map(l -> Url.getAbsoluteUrl(current, l))
		             .sequential()
		             .forEach(l -> urls.addIfAbsent(l));
				
				System.out.println("END: " + path);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}


