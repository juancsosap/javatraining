package P22_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class E10_JDBCPreparedStatement {

	public static void main(String[] args) throws SQLException {
		
		/*  SQL QUERY EXECUTION - LIFE CYCLE
		 * 
		 *            SQL Query                                                           
		 *  JAVA -------------------> DATABASE ------> COMPILATION --------> TOKENIZATION  
		 *   APP <-------------------  ENGINE              |    ^                 |
		 *            ResultSet           ^                |    |                 |  Stream of Tokens
		 *               or               |                |    | Optimized       V
		 *           UpdateCount          |                |    | Query        PARSING
		 *                                |                |    | Tree            |
		 *                                |                |    |                 |  Query Tree
		 *                                |                |    |                 V
		 *                                |                |    ---------- QUERY OPTIMIZATION
		 *                                |                |
		 *                                |                V                                                 
		 *                                ------------ EXECUTION
		 *                                                 
		 */ 
		
		
		// Driver is required
		String connString = getConnectionString();
		try(Connection conn = DriverManager.getConnection(connString, "root", "roottoor");
			Scanner console = new Scanner(System.in)) {
			
			// Compile Query
			// As prepared statement is pre-configured with a specific SQL statement, can not be used to execute another SQL statement
			PreparedStatement pstat = conn.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
						
			System.out.println("USER REGISTRATION");
			
			while(true) {
				System.out.print("Username: ");
				String username = console.nextLine();
				
				System.out.print("Password: ");
				String password = console.nextLine();
				
				pstat.setString(1, username);
				pstat.setString(2, password);
				
				// Execute Query
				int rowCount = pstat.executeUpdate();
				
				System.out.println(rowCount + " row(s) inserted");
				
				System.out.println();
				
				System.out.print("Do you want to register another user? (yes/no): ");
				String option = console.nextLine();
				
				if(option.equalsIgnoreCase("no")) break;
			}
			
			Statement stat = conn.createStatement();
			
			// Compile and Execute Query
			ResultSet result = stat.executeQuery("SELECT * FROM users");
			
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
