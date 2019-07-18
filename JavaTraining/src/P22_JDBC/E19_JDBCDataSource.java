package P22_JDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class E19_JDBCDataSource {

	public static void main(String[] args) throws SQLException {
		
		// Use Java Naming and Directory (JNDI) API
		
		/*
		 * * Basic Implementation (
		 *   - Generate Standard Connection objects like DriverManager
		 *   
		 * * Connection Pooling Implementation
		 *   - Participate in a Connection Pooling working with a 
		 *     middle-tier connection pooling manager
		 * 
		 * * Distributed Transaction Implementation
		 *   - Use Distributed transactions working with a 
		 *     middle-tier transaction manager 
		 *   - Could participate in a Connection Pooling working with a 
		 *     middle-tier connection pooling manager
		 * 
		 */
		DataSource ds = MyDataSource.get();
		
		try(Connection conn = ds.getConnection()) {
			
			Statement stat = conn.createStatement();
			
			ResultSet result = stat.executeQuery("SELECT * FROM city where CountryCode = 'CHL' LIMIT 10");
			
			while(result.next()) {
				System.out.println("-----------------------------");
				System.out.println("ID: " + result.getInt("ID"));
				System.out.println("Name: " + result.getString("Name"));
				System.out.println("Country Code: " + result.getString("CountryCode"));
				System.out.println("District: " + result.getString("District"));
				System.out.println("Population: " + result.getInt("Population"));
				System.out.println("-----------------------------");
				System.out.println();
			}
			
		}
	}
	
	private static class MyDataSource {
		
		public static DataSource get() {
			MysqlDataSource mds = new MysqlDataSource();
			mds.setURL(Config.get("url"));
			mds.setUser(Config.get("user"));
			mds.setPassword(Config.get("password"));
			mds.setRequireSSL(false);
			return mds;
		}
		
	}
	
	private static class Config {
		
		private static Properties p = new Properties();
		
		static {
			try {
				InputStream in = new FileInputStream("files/config.properties");
				p.load(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static String get(String key) {
			return p.getProperty(key);
		}
		
	}
	
}
