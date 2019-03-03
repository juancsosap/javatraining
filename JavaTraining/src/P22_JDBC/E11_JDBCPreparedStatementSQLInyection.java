package P22_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class E11_JDBCPreparedStatementSQLInyection {

	public static void main(String[] args) throws SQLException {
		
		// Driver is required
		String connString = getConnectionString();
		try(Connection conn = DriverManager.getConnection(connString, "root", "roottoor");
			Scanner console = new Scanner(System.in)) {
			
			PreparedStatement pstat = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
						
			System.out.println("USER LOGIN");
			
			System.out.print("Username: ");  
			String username = console.nextLine(); 
			pstat.setString(1, username);
			
			System.out.print("Password: ");
			String password = console.nextLine(); // ' OR ''=' // ' or id=1 and ''='
			pstat.setString(2, password);
			
			ResultSet result = pstat.executeQuery();
			
			if(result.next()) {
				System.out.println("Access Granted");
				System.out.println("-----------------------------");
				System.out.println("ID: " + result.getInt("id"));
				System.out.println("Username: " + result.getString("username"));
				System.out.println("Password: " + result.getString("password"));
				System.out.println("-----------------------------");
				System.out.println();
			} else
				System.out.println("Access Denied");
			
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
