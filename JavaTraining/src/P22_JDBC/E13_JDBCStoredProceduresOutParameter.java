package P22_JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class E13_JDBCStoredProceduresOutParameter {

	public static void main(String[] args) throws SQLException {
		
		// Driver is required
		String connString = getConnectionString();
		try(Connection conn = DriverManager.getConnection(connString, "root", "roottoor");
			Scanner console = new Scanner(System.in)) {
			
			// Create Procedure
			
			/*
			 *  DELIMITER //
			 *  
			 *  CREATE PROCEDURE GetEmail(IN idPerson INT, OUT email CHAR(100))
			 *  BEGIN 
			 *    SELECT CONCAT(LOWER(name), '.', LOWER(surname), '\@mycompany.com') INTO email FROM person WHERE id=idPerson; 
			 *  END //
			 *  
			 *  DELIMITER ;
			 * 
			 */
			
			System.out.println("GET EMAIL");
			
			System.out.print("Id Person: ");
			int id = Integer.parseInt(console.nextLine());
						
			CallableStatement cstat = conn.prepareCall("{call GetEmail(?, ?)}");
			
			cstat.setInt(1, id);
			
			cstat.registerOutParameter(2, Types.VARCHAR);
			
			cstat.execute();
			
			String email = cstat.getString(2);
			
			System.out.println("Email: " + email);
			
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
