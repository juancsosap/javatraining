package P22_JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

public class E16_JDBCDates {

	public static void main(String[] args) throws SQLException {
		
		// Driver is required
		String connString = getConnectionString();
		try(Connection conn = DriverManager.getConnection(connString, "root", "roottoor");
			Scanner console = new Scanner(System.in)) {
			
			conn.createStatement().executeUpdate("DROP TABLE IF EXISTS users");
			
			conn.createStatement().executeUpdate("CREATE TABLE users (" + 
					"id INT NOT NULL AUTO_INCREMENT UNIQUE, " + 
					"username VARCHAR(100) NOT NULL UNIQUE, " + 
					"password VARCHAR(100) NOT NULL," +
					"register DATE)");
			
			String sqlTemplate = "INSERT INTO users (username, password, register) VALUES (?, ?, ?)";
			PreparedStatement pstat = conn.prepareStatement(sqlTemplate);
						
			System.out.println("USER REGISTRATION");
			
			while(true) {
				System.out.print("Username: ");
				String username = console.nextLine();
				
				System.out.print("Password: ");
				String password = console.nextLine();
				
				pstat.setString(1, username);
				pstat.setString(2, password);
				pstat.setDate(3, Date.valueOf(LocalDate.now()));
				
				pstat.executeUpdate();
				
				System.out.println("user register");
				
				System.out.println();
				
				System.out.print("Do you want to register another user? (yes/no): ");
				String option = console.nextLine();
				
				if(option.equalsIgnoreCase("no")) break;
			}
			
			Statement stat = conn.createStatement();
			
			ResultSet result = stat.executeQuery("SELECT * FROM users");
			
			while(result.next()) {
				System.out.println("-----------------------------");
				System.out.println("ID: " + result.getInt("id"));
				System.out.println("Username: " + result.getString("username"));
				System.out.println("Password: " + result.getString("password"));
				System.out.println("Register Date: " + result.getDate("register").toLocalDate());
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
