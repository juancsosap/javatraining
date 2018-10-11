package P22_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class E14_JDBCMetadata {

	public static void main(String[] args) throws SQLException {
		
		// Driver is required
		String connString = getConnectionString();
		try(Connection conn = DriverManager.getConnection(connString, "root", "roottoor");
			Scanner console = new Scanner(System.in)) {
			
			String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			System.out.println("USER REGISTRATION");
			
			while(true) {
				String[] data = new String[2];
				
				System.out.print("Username: ");
				data[0] = console.nextLine();
				
				System.out.print("Password: ");
				data[1] = console.nextLine();
				
				ParameterMetaData pmd = pstat.getParameterMetaData();
				
				int count = pmd.getParameterCount();
				
				for(int i=1; i<=count; i++) {
					pstat.setString(i, data[i-1]);
				}
				
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
		String options = "useSSL=false";
		
		return String.format("%s://%s:%s/%s?%s", driver, host, port, database, options);
	}
	
}
