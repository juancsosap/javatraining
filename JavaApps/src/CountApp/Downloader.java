package CountApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class Downloader {

	public static String download(String url) throws IOException {
		
		URL website = new URL(url);
		try(InputStream in = website.openStream();
			Reader inRead = new InputStreamReader(in);
			BufferedReader inBuffer = new BufferedReader(inRead)){
			
			StringBuilder output = new StringBuilder();
			String line;
			while((line = inBuffer.readLine()) != null) {
				output.append(line + "\n");
			}
			return output.toString();
		}
		
	}
	
}
