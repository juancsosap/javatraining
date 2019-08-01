package P22_JDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class E24_JDBCResultSetTypes {

	/*
	 *  ResultSet Types
	 *  * Based on Operation Mode
	 *    - READ_ONLY
	 *    - UPDATABLE
	 *  
	 *  * Based on Cursor Movement Type
	 *    - FORWARD_ONLY
	 *    - SCROLL
	 *      > SCROLL_SENSITIVE
	 *      > SCROLL_INSENSITIVE
	 * 
	 *  * Based on Holdability
	 *    - HOLD_CURSORS_OVER_COMMIT
	 *    - CLOSE_CURSORS_AT_COMMIT
	 */
	
	public static void main(String[] args) {
		
		String prop = "files/config_netec.properties";
		
		try(Connection conn = MyDataSource.get(prop).getConnection()) {
			conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			
			System.out.println("DEFAULT RESULTSET TYPE");
			Statement stat = conn.createStatement();
			System.out.println("Type: " + getResultSetType(stat));
			
			stat.executeUpdate("TRUNCATE TABLE person");
			
			stat.executeUpdate("INSERT INTO person (id, name, surname, age) "
			        + "VALUES (1, 'Juan', 'Sosa', 36)");
			stat.executeUpdate("INSERT INTO person (id, name, surname, age) "
			        + "VALUES (2, 'Ana', 'Prada', 35)");
			stat.executeUpdate("INSERT INTO person (id, name, surname, age) "
			        + "VALUES (3, 'Beatriz', 'Bonilla', 62)");
	
			ResultSet rs = stat.executeQuery("SELECT * FROM person");
			
			while(rs.next()) { printRecord(rs); }
			while(rs.previous()) { printRecord(rs); }
			
		} catch(SQLException ex) {
			System.out.println(ex);
		}
		
		System.out.println();
		
		try(Connection conn = MyDataSource.get(prop).getConnection();
			Connection conn1 = MyDataSource.get(prop).getConnection()) {
			conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			conn1.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			
			System.out.println("SCROLL INSENSITIVE RESULTSET TYPE");
			Statement stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					                              ResultSet.CONCUR_READ_ONLY,
					                              ResultSet.CLOSE_CURSORS_AT_COMMIT);
			System.out.println("Type: " + getResultSetType(stat));
			
			stat.executeUpdate("TRUNCATE TABLE person");
			
			stat.executeUpdate("INSERT INTO person (id, name, surname, age) "
			        + "VALUES (1, 'Juan', 'Sosa', 36)");
			stat.executeUpdate("INSERT INTO person (id, name, surname, age) "
			        + "VALUES (2, 'Ana', 'Prada', 35)");
			stat.executeUpdate("INSERT INTO person (id, name, surname, age) "
			        + "VALUES (3, 'Beatriz', 'Bonilla', 62)");
	
			ResultSet rs = stat.executeQuery("SELECT * FROM person");
			
			while(rs.next()) { printRecord(rs); }
			while(rs.previous()) { printRecord(rs); }
			
			conn1.createStatement().executeUpdate("UPDATE person "
					+ "SET name='Juan Carlos' WHERE id=1");
			
			if(rs.first()) { printRecord(rs); }
				
		} catch(SQLException ex) {
			System.out.println(ex);
		}
		
		System.out.println();

		try(Connection conn = MyDataSource.get(prop).getConnection();
			Connection conn1 = MyDataSource.get(prop).getConnection()) {
			conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			conn1.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			
			System.out.println("SCROLL SENSITIVE RESULTSET TYPE");
			Statement stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					                              ResultSet.CONCUR_READ_ONLY,
					                              ResultSet.CLOSE_CURSORS_AT_COMMIT);
			System.out.println("Type: " + getResultSetType(stat));
			
			stat.executeUpdate("TRUNCATE TABLE person");
			
			stat.executeUpdate("INSERT INTO person (id, name, surname, age) "
			        + "VALUES (1, 'Juan', 'Sosa', 36)");
			stat.executeUpdate("INSERT INTO person (id, name, surname, age) "
			        + "VALUES (2, 'Ana', 'Prada', 35)");
			stat.executeUpdate("INSERT INTO person (id, name, surname, age) "
			        + "VALUES (3, 'Beatriz', 'Bonilla', 62)");
	
			ResultSet rs = stat.executeQuery("SELECT * FROM person");
			
			while(rs.next()) { printRecord(rs); }
			while(rs.previous()) { printRecord(rs); }
			
			conn1.createStatement().executeUpdate("UPDATE person "
					+ "SET name='Juan Carlos' WHERE id=1");
			
			if(rs.first()) { printRecord(rs); }
		
		} catch(SQLException ex) {
			System.out.println(ex);
		}

		System.out.println();
		
		try(Connection conn = MyDataSource.get(prop).getConnection()) {
			
			System.out.println("DEFAULT RESULTSET CONCURRENT MODE");
			Statement stat = conn.createStatement();
			System.out.println("Concurrent Mode: " + getResultSetConcurrencyMode(stat));
			
			stat.executeUpdate("TRUNCATE TABLE person");
			
			stat.executeUpdate("INSERT INTO person (id, name, surname, age) "
			        + "VALUES (1, 'Juan', 'Sosa', 36)");
			stat.executeUpdate("INSERT INTO person (id, name, surname, age) "
			        + "VALUES (2, 'Ana', 'Prada', 35)");
			stat.executeUpdate("INSERT INTO person (id, name, surname, age) "
			        + "VALUES (3, 'Beatriz', 'Bonilla', 62)");
	
			ResultSet rs = stat.executeQuery("SELECT * FROM person");
			
			while(rs.next()) { printRecord(rs); }
			
			if(rs.first()) { 
				rs.updateString("name", "Juan Carlos");
				printRecord(rs);
			}
	
		} catch(SQLException ex) {
			System.out.println(ex);
		}

		System.out.println();
		
		try(Connection conn = MyDataSource.get(prop).getConnection()) {
			
			System.out.println("UPDATABLE RESULTSET CONCURRENT MODE");
			Statement stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                  ResultSet.CONCUR_UPDATABLE,
                                                  ResultSet.CLOSE_CURSORS_AT_COMMIT);
			System.out.println("Concurrent Mode: " + getResultSetConcurrencyMode(stat));
			
			stat.executeUpdate("TRUNCATE TABLE person");
			
			stat.executeUpdate("INSERT INTO person (id, name, surname, age) "
			        + "VALUES (1, 'Juan', 'Sosa', 36)");
			stat.executeUpdate("INSERT INTO person (id, name, surname, age) "
			        + "VALUES (2, 'Ana', 'Prada', 35)");
			stat.executeUpdate("INSERT INTO person (id, name, surname, age) "
			        + "VALUES (3, 'Beatriz', 'Bonilla', 62)");
	
			ResultSet rs = stat.executeQuery("SELECT * FROM person");
			
			while(rs.next()) { printRecord(rs); }
			
			if(rs.first()) { 
				rs.updateString("name", "Juan Carlos");
				printRecord(rs);
			}
			
		} catch(SQLException ex) {
			System.out.println(ex);
		}

		System.out.println();
		
		try(Connection conn = MyDataSource.get(prop).getConnection()) {
			
			System.out.println("DEFAULT RESULTSET HOLDABILITY");
			Statement stat = conn.createStatement();
			System.out.println("Holdability: " + getResultSetHoldability(stat));
			
			stat.executeUpdate("TRUNCATE TABLE person");
			
			stat.executeUpdate("INSERT INTO person (id, name, surname, age) "
			        + "VALUES (1, 'Juan', 'Sosa', 36)");
			stat.executeUpdate("INSERT INTO person (id, name, surname, age) "
			        + "VALUES (2, 'Ana', 'Prada', 35)");
			stat.executeUpdate("INSERT INTO person (id, name, surname, age) "
			        + "VALUES (3, 'Beatriz', 'Bonilla', 62)");
	
			ResultSet rs = stat.executeQuery("SELECT * FROM person");
			
			while(rs.next()) { printRecord(rs); }
			
			stat.executeUpdate("UPDATE person SET name='Juan Carlos' WHERE id=1");
			
			if(rs.first()) { printRecord(rs); }
			
		} catch(SQLException ex) {
			System.out.println(ex);
		}

		System.out.println();
		
		try(Connection conn = MyDataSource.get(prop).getConnection()) {
			
			System.out.println("HOLD CURSOR RESULTSET HOLDABILITY");
			Statement stat = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                                                  ResultSet.CONCUR_READ_ONLY,
                                                  ResultSet.CLOSE_CURSORS_AT_COMMIT);
			System.out.println("Holdability: " + getResultSetHoldability(stat));
			
			stat.executeUpdate("TRUNCATE TABLE person");
			
			stat.executeUpdate("INSERT INTO person (id, name, surname, age) "
			        + "VALUES (1, 'Juan', 'Sosa', 36)");
			stat.executeUpdate("INSERT INTO person (id, name, surname, age) "
			        + "VALUES (2, 'Ana', 'Prada', 35)");
			stat.executeUpdate("INSERT INTO person (id, name, surname, age) "
			        + "VALUES (3, 'Beatriz', 'Bonilla', 62)");
	
			ResultSet rs = stat.executeQuery("SELECT * FROM person");
			
			while(rs.next()) { printRecord(rs); }
			
			stat.executeUpdate("UPDATE person SET name='Juan Carlos' WHERE id=1");
			
			if(rs.first()) { printRecord(rs); }
			
		} catch(SQLException ex) {
			System.out.println(ex);
		}

	}
	
	private static void printRecord(ResultSet rs) throws SQLException {
		String text = String.format("(%,d) %s, %s [%,d]", 
				rs.getInt("id"),
				rs.getString("surname").toUpperCase(),
				rs.getString("name"),
				rs.getInt("age")); 
		System.out.println(text);
	}
	
	
	private static String getResultSetType(Statement stat) throws SQLException {
		int type = stat.getResultSetType();
		switch(type) {
			case ResultSet.TYPE_SCROLL_INSENSITIVE:
				return "TYPE_SCROLL_INSENSITIVE (" + type + ")";
			case ResultSet.TYPE_SCROLL_SENSITIVE:
				return "TYPE_SCROLL_SENSITIVE (" + type + ")";
			default:
				return "TYPE_FORWARD_ONLY (" + type + ")";
		}
	}
	
	private static String getResultSetConcurrencyMode(Statement stat) throws SQLException {
		int mode = stat.getResultSetConcurrency();
		switch(mode) {
			case ResultSet.CONCUR_UPDATABLE:
				return "CONCUR_UPDATABLE (" + mode + ")";
			default:
				return "CONCUR_READ_ONLY (" + mode + ")";
		}
	}
	
	private static String getResultSetHoldability(Statement stat) throws SQLException {
		int hold = stat.getResultSetHoldability();
		switch(hold) {
			case ResultSet.HOLD_CURSORS_OVER_COMMIT:
				return "HOLD_CURSORS_OVER_COMMIT (" + hold + ")";
			default:
				return "CLOSE_CURSORS_AT_COMMIT (" + hold + ")";
		}
	}
	
	private static class MyDataSource {
		
		public static DataSource get(String propPath) {
			try {
				InputStream in = new FileInputStream(propPath);
				Properties p = new Properties();
				p.load(in);
				return prepareDS(p);
			} catch (IOException e) {
				System.out.println("Error loading Properties File");
				return null;
			}
		}
		
		private static DataSource prepareDS(Properties p) {
			MysqlDataSource mds = new MysqlDataSource();
			mds.setURL(p.getProperty("url"));
			mds.setUser(p.getProperty("user"));
			mds.setPassword(p.getProperty("password"));
			return mds;
		}
		
	}
	
}
