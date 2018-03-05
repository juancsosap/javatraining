package Controler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;


public class DBManager {
	
	private Connection conn;
	private Statement sql;
	
	public DBManager(String url, String user, String password) {
		try {
			this.conn = DriverManager.getConnection(url, user, password);
			this.sql = this.conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection to DB was not completed.");
		}
	}
	public DBManager(String host, int port, String db, String user, String password) {
		this("jdbc:mysql://" + host + ":" + port + "/" + db + "?useSSL=false", user, password);		
	}
	public DBManager(String configFile, String db) {
		try {
			FileReader input = new FileReader(configFile);
			BufferedReader bufferRead = new BufferedReader(input);
			
			String host = "localhost", port = "3306", user = "", password = "";
			String line = bufferRead.readLine();
			while(line != null) {
				String key = line.split(":")[0];
				String value = line.split(":")[1];
				
				if(key.equals("host")){ host = value; }
				if(key.equals("port")){ port = value; }
				if(key.equals("user")){ user = value; }
				if(key.equals("password")){ password = value; }
				line = bufferRead.readLine();
			}
			input.close();
			String url = "jdbc:mysql://" + host + ":" + port + "/" + db + "?useSSL=false";

			this.conn = DriverManager.getConnection(url, user, password);
			this.sql = this.conn.createStatement();
		} catch (IOException e) {
			System.out.println("File not fount");	
		} catch (SQLException e) {
			System.out.println("Connection to DB was not completed.");
		}
		 
	}
	
	public void writeDB(String sqlStr) {
		try {
			this.sql.executeUpdate(sqlStr);
		} catch (SQLException e) {
			System.out.println("DB Modification was not completed.");
		}
	}
	
	public ArrayList<Dictionary<String, Object>> readDB(String sqlStr) {
		try {
			ResultSet result = sql.executeQuery(sqlStr);
			ArrayList<Dictionary<String, Object>> fullResult; 
			fullResult = new ArrayList<Dictionary<String, Object>>();
			while(result.next()) {
				Dictionary<String, Object> resultDict = new Hashtable<String, Object>();
				int count = result.getMetaData().getColumnCount();
				for(int i=0; i<count; i++) {
					String key = result.getMetaData().getColumnLabel(i+1);
					Object value = result.getObject(i+1);
					resultDict.put(key, value);
				}
				fullResult.add(resultDict);
			}
			return fullResult;
		} catch (SQLException e) {
			System.out.println("DB Reading was not completed.");
			e.printStackTrace();
		}
		return null;
	}
	
	public void disconnect() {
		try {
			if(!this.conn.isClosed()) { this.conn.close(); }
		} catch (SQLException e) {
			System.out.println("Disconnection from DB was not completed.");
		}
	}

}
