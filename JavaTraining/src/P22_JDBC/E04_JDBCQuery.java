package P22_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class E04_JDBCQuery {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		// Driver is required for load and registration of it
		// Not required from Java 6 / JDBC 4.0, because it's autoloaded from the info in the file 
		// 'META-INF/services/java.sql.Driver' inside the jar file, then could be omitted
		Class.forName("com.mysql.jdbc.Driver");
		
		String connString = getConnectionString();
		try(Connection conn = DriverManager.getConnection(connString)) {
			
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
	
	private static String getConnectionString() {
		String driver = "jdbc:mysql";
		String host = "localhost";
		int port = 3306;
		String database = "World";
		String user = "root";
		String password = "roottoor";
		String options = "useSSL=false&user=" + user + "&password=" + password;
		
		return String.format("%s://%s:%s/%s?%s", driver, host, port, database, options);
	}
	
}
