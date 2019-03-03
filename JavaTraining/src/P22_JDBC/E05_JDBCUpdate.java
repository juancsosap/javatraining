package P22_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class E05_JDBCUpdate {

	public static void main(String[] args) throws SQLException {
		
		// Driver is required
		String connString = getConnectionString();
		try(Connection conn = DriverManager.getConnection(connString, "root", "roottoor")) {
			
			Statement stat = conn.createStatement();
			
			// 4703954
			int rowCount = stat.executeUpdate("UPDATE city SET Population = 7112808 WHERE name = 'Santiago de Chile'");
			
			System.out.println(rowCount + " row(s) updated");
			
			System.out.println();
			
			// The same Statement could be used to execute different SQL statements
			ResultSet result = stat.executeQuery("SELECT * FROM city WHERE name = 'Santiago de Chile'");
			
			while(result.next()) {
				System.out.println("-----------------------------");
				System.out.println("ID: " + result.getInt("ID"));
				System.out.println("Name: " + result.getString("Name"));
				System.out.println("Country Code: " + result.getString("CountryCode"));
				System.out.println("District: " + result.getString("District"));
				System.out.printf("Population: %,d\n", result.getInt("Population"));
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
		String options = "useSSL=false&"
		        + "useUnicode=true&"
		        + "useJDBCCompliantTimezoneShift=true&"
		        + "useLegacyDatetimeCode=false&"
		        + "serverTimezone=UTC";
		
		return String.format("%s://%s:%s/%s?%s", driver, host, port, database, options);
	}
	
}
