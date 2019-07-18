package P22_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E15_JDBCBatchStatement {

public static void main(String[] args) throws SQLException {
		
		// Driver is required
		String connString = getConnectionString();
		try(Connection conn = DriverManager.getConnection(connString, "root", "roottoor");
			Scanner console = new Scanner(System.in)) {
			
			List<User> users = getUsers();
			
			LocalDateTime ini, fin;
			
			System.out.println("USER REGISTRATION");
			
			conn.createStatement().executeUpdate("TRUNCATE TABLE users");
			System.out.println();

			Statement stat;
			
			System.out.println("With Statement");
			
			ini = LocalDateTime.now();
			
			stat = conn.createStatement();
			
			for(User user : users) {
				String sqltemplate = "INSERT INTO users (username, password) VALUES ('%s', '%s')";
				String sql = String.format(sqltemplate, user.username, user.password);
				
				stat.executeUpdate(sql);
			}
			
			fin = LocalDateTime.now();
			
			System.out.printf("Time Required: %,d msg\n", Duration.between(ini, fin).toMillis());

			conn.createStatement().executeUpdate("TRUNCATE TABLE users");
			System.out.println();
			
			System.out.println("With Batch Statement");
			
			ini = LocalDateTime.now();
			
			stat = conn.createStatement();
			
			for(User user : users) {
				String sqltemplate = "INSERT INTO users (username, password) VALUES ('%s', '%s')";
				String sql = String.format(sqltemplate, user.username, user.password);
				
				stat.addBatch(sql);
			}
			
			stat.executeBatch();
			
			fin = LocalDateTime.now();
			
			System.out.printf("Time Required: %,d msg\n", Duration.between(ini, fin).toMillis());

			conn.createStatement().executeUpdate("TRUNCATE TABLE users");
			System.out.println();
			
			PreparedStatement pstat;
			
			System.out.println("With PrepareStatement");
			
			ini = LocalDateTime.now();
			
			pstat = conn.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
			
			for(User user : users) {
				pstat.setString(1, user.username);
				pstat.setString(2, user.password);
				
				pstat.executeUpdate();
			}
			
			fin = LocalDateTime.now();
			
			System.out.printf("Time Required: %,d msg\n", Duration.between(ini, fin).toMillis());

			conn.createStatement().executeUpdate("TRUNCATE TABLE users");
			System.out.println();
			
			System.out.println("With Batch PrepareStatement");
			
			ini = LocalDateTime.now();
			
			pstat = conn.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
			
			for(User user : users) {
				pstat.setString(1, user.username);
				pstat.setString(2, user.password);
				
				pstat.addBatch();
			}
			
			pstat.executeBatch();
			
			fin = LocalDateTime.now();
			
			System.out.printf("Time Required: %,d msg\n", Duration.between(ini, fin).toMillis());
				
		}
		
	}

	private static class User {
		
		public String username;
		public String password;
		
		public User(String u, String p) {
			this.username = u;
			this.password = p;
		}
		
	}

	private static List<User> getUsers(){
		List<User> users = new ArrayList<>();
		for(int i=0; i<1000; i++) {
			users.add(new User("user" + i, "pass" + i));
		}
		return users;
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
