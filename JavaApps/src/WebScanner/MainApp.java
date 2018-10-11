package WebScanner;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class MainApp {

	public static void main(String[] args) throws Exception {
		
		Properties prop = new Properties();
		try(InputStream in = new FileInputStream("files/webscanner-config.properties")) {
			prop.load(in);
		}
		
		String url = prop.getProperty("site");
		String target = prop.getProperty("target");
		String temp = prop.getProperty("temp");
		String folder = prop.getProperty("download");
		String ext = prop.getProperty("extensions");
		
		WebScanner scan = new WebScanner(url, target, temp, folder, ext);
		scan.analize();
	}

}
