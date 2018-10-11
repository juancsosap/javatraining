package P22_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class E09_JDBCSQLInyection {

	public static void main(String[] args) throws SQLException {
		
		// Driver is required
		String connString = getConnectionString();
		try(Connection conn = DriverManager.getConnection(connString, "root", "roottoor");
			Scanner console = new Scanner(System.in)) {
			
			Statement stat = conn.createStatement();
						
			System.out.println("USER LOGIN");
			
			System.out.print("Username: ");
			String username = console.nextLine(); 
			
			System.out.print("Password: ");
			String password = console.nextLine(); // ' OR ''=' // ' or id=1 and ''='
			
			String sql = String.format("SELECT * FROM users WHERE username = '%s' AND password = '%s'", username, password);
			System.out.println(sql);
			
			ResultSet result = stat.executeQuery(sql);
			
			
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
		String options = "useSSL=false";
		
		return String.format("%s://%s:%s/%s?%s", driver, host, port, database, options);
	}
	
}
