package P22_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class E07_JDBCExecute {

	public static void main(String[] args) throws SQLException {
		
		// Driver is required
		String connString = getConnectionString();
		try(Connection conn = DriverManager.getConnection(connString, "root", "roottoor");
			Scanner console = new Scanner(System.in)) {
			
			System.out.println("SQL Command:");
			String sql = console.nextLine();
			
			System.out.println();
			
			Statement stat = conn.createStatement();
			
			boolean isQuery = stat.execute(sql);
			
			if(isQuery) {
				ResultSet result = stat.getResultSet();
				ResultSetMetaData md = result.getMetaData();
				
				int colCount = md.getColumnCount();
				
				while(result.next()) {
					System.out.println("-----------------------------");
					for(int i=1; i<=colCount; i++) {
						System.out.println(md.getColumnName(i) + ": " + result.getObject(i) + " (" + md.getColumnTypeName(i) + ")");
					}
					System.out.println("-----------------------------");
					System.out.println();
				}
			} else {
				int rowCount = stat.getUpdateCount();
				
				System.out.println(rowCount + " row(s) updated");
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
