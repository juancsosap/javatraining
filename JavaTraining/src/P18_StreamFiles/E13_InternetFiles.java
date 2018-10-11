package P18_StreamFiles;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class E13_InternetFiles {

	public static void main(String[] args) throws IOException {

		Path DIR = Paths.get("files", "downloads");
		
		if(Files.notExists(DIR))
			Files.createDirectories(DIR);
		
		try {
			URL website = new URL("https://www.rfc-editor.org/rfc/rfc4949.txt");
			Path target = DIR.resolve("rfc4949.txt");
			System.out.println(target);
			try(InputStream in = website.openStream()){
				Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		}
		
	}

}
