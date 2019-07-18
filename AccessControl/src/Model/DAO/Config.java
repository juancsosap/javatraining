package Model.DAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
 
    private Properties p = new Properties();
		
    private static Config instance = null;
    
    private Config(String path) { //
    	try {
            InputStream in = new FileInputStream(path);
            p.load(in);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static Config load(String path) {
    	if(instance == null) {
    		instance = new Config(path);
    	}
    	return instance;
    }
    
    public String get(String key) {
        return p.getProperty(key);
    }

    public Properties getProperties() {
        return (Properties) p.clone();
    }
    
}
