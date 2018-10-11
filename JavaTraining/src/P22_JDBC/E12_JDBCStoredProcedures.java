package P22_JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class E12_JDBCStoredProcedures {

	public static void main(String[] args) throws SQLException {
		
		// Statement(I) <---- PreparedStatement(I) <---- CallableStatement(I)
		
		// Driver is required
		String connString = getConnectionString();
		try(Connection conn = DriverManager.getConnection(connString, "root", "roottoor");
			Scanner console = new Scanner(System.in)) {
			
			// Create Procedure
			
			/*
			 *  DELIMITER //
			 *  
			 *  CREATE PROCEDURE AddUser(IN user CHAR(100), IN pass CHAR(100)) 
			 *  BEGIN 
			 *    INSERT INTO users (username, password) VALUES (user, pass); 
			 *  END //
			 *  
			 *  DELIMITER ;
			 * 
			 */
			
			System.out.println("USER REGISTRATION");
			
			System.out.print("Username: ");
			String username = console.nextLine();
			
			System.out.print("Password: ");
			String password = console.nextLine();
			
			CallableStatement cstat = conn.prepareCall("{call AddUser(?, ?)}");
			
			cstat.setString(1, username);
			cstat.setString(2, password);
			
			int rowCount = cstat.executeUpdate();
			
			System.out.println(rowCount + " row(s) inserted");
			
			PreparedStatement pstat = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
			
			pstat.setString(1, username);
			pstat.setString(2, password);
			
			ResultSet result = pstat.executeQuery();
			
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
