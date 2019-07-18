package P22_JDBC;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class E06_JDBCMetadata {

	public static void main(String[] args) throws SQLException {
		
		// Driver is required
		String connString = getConnectionString();
		try(Connection conn = DriverManager.getConnection(connString, "root", "roottoor")) {
			
			DatabaseMetaData dbmd = conn.getMetaData();
			
			ResultSet tables = dbmd.getTables(null, null, null, null);
			
			ResultSetMetaData mdt = tables.getMetaData();
			
			int colCountT = mdt.getColumnCount();
			
			while(tables.next()) {
				System.out.println("#############################");
				for(int i=1; i<=colCountT; i++) {
					System.out.println(mdt.getColumnName(i) + ": " + tables.getObject(i));
				}
				System.out.println("#############################");
				System.out.println();
			}
			
			ResultSet columns = dbmd.getColumns(null, null, "city", null);
			
			ResultSetMetaData mdc = columns.getMetaData();
			
			int colCountC = mdc.getColumnCount();
			
			while(columns.next()) {
				System.out.println("*****************************");
				for(int i=1; i<=colCountC; i++) {
					System.out.println(mdc.getColumnName(i) + ": " + columns.getObject(i));
				}
				System.out.println("*****************************");
				System.out.println();
			}
			
			Statement stat = conn.createStatement();
			
			ResultSet result = stat.executeQuery("SELECT * FROM city LIMIT 10");
			
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
