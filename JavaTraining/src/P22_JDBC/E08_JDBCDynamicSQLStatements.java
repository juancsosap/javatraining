package P22_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class E08_JDBCDynamicSQLStatements {

	public static void main(String[] args) throws SQLException {
		
		// Driver is required
		String connString = getConnectionString();
		try(Connection conn = DriverManager.getConnection(connString, "root", "roottoor");
			Scanner console = new Scanner(System.in)) {
			
			Statement stat = conn.createStatement();
			
			// Create Table
			stat.executeUpdate("CREATE TABLE IF NOT EXISTS users ("
					               + "id INT NOT NULL AUTO_INCREMENT UNIQUE, "
					               + "username VARCHAR(100) NOT NULL UNIQUE, "
					               + "password VARCHAR(100) NOT NULL)");
			
			System.out.println("USER REGISTRATION");
			
			System.out.print("Username: ");
			String username = console.nextLine();
			
			System.out.print("Password: ");
			String password = console.nextLine();
			
			int rowCount = stat.executeUpdate("INSERT INTO users (username, password) "
					                        + "VALUES ('" + username + "', '" + password + "')");
			
			System.out.println(rowCount + " row(s) inserted");
			
			String sql = String.format("SELECT * FROM users WHERE username = '%s' AND password = '%s'", username, password);
			ResultSet result = stat.executeQuery(sql);
			
			while(result.next()) {
				System.out.println("-----------------------------");
				System.out.println("ID: " + result.getInt("id"));
				System.out.println("Username: " + result.getString("username"));
				System.out.println("Password: " + result.getString("password"));
				System.out.println("-----------------------------");
				System.out.println();
			}
			
		}
		
	}
	
	private static String getConnectionString() {
		String driver = "jdbc:mysql";
		String host = "localhost";
		int port = 3306;
		String database = "netec";
		String options = "useSSL=false&"
		        + "useUnicode=true&"
		        + "useJDBCCompliantTimezoneShift=true&"
		        + "useLegacyDatetimeCode=false&"
		        + "serverTimezone=UTC";
		
		return String.format("%s://%s:%s/%s?%s", driver, host, port, database, options);
	}
	
}
