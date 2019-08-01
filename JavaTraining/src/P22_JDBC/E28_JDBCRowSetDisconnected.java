package P22_JDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import com.mysql.cj.jdbc.MysqlDataSource;

public class E28_JDBCRowSetDisconnected {

	public static void main(String[] args) throws SQLException {
		
		RowSetFactory rsf = RowSetProvider.newFactory();
		CachedRowSet crs = rsf.createCachedRowSet();
		
		String prop = "files/config.properties";
		try(Connection conn = MyDataSource.get(prop).getConnection()) {
			ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM city LIMIT 5");
			while(rs.next()) { printRecord(rs); }
			
			System.out.println();
			
			rs.beforeFirst();
			crs.populate(rs);
			while(crs.next()) { printRecord(crs); }
			
		} catch(SQLException ex) {
			System.out.println(ex);
		}
		
		System.out.println();
		
		crs.beforeFirst();
		while(crs.next()) { printRecord(crs); }
			
	}
	
	private static void printRecord(ResultSet rs) throws SQLException {
		String text = String.format("(%,d) %s, %s, %S [%,d]", 
				rs.getInt("id"),
				rs.getString("name"),
				rs.getString("countrycode"),
				rs.getString("district"),
				rs.getInt("population")); 
		System.out.println(text);
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
