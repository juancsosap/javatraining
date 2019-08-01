package GenericDAO;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Config {
		
	private Properties prop = new Properties();
	
	public Config(String path) {
		try {
			InputStream in = new FileInputStream(path);
			this.prop.load(in);
		} catch (Exception ex) { 
			ex.printStackTrace();
		}
	}
	
	public String get(String key) {
		return this.prop.getProperty(key);
	}
	
}