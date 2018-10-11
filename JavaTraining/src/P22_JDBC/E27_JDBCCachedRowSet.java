package P22_JDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class E27_JDBCCachedRowSet {

	public static void main(String[] args) throws SQLException {
		
		String prop = "files/config.properties";
		CachedRowSet rs = MyRowSet.get(prop);
		
		rs.setCommand("SELECT * FROM city LIMIT 5");
		rs.execute();
		
		while(rs.next()) { printRecord(rs); }
		
		System.out.println();
		
		while(rs.previous()) { printRecord(rs); }
		
		System.out.println();
		
		if(rs.absolute(3)) { printRecord(rs); }
		if(rs.first()) { printRecord(rs); }
		if(rs.last()) { printRecord(rs); }
		
	}
	
	private static void printRecord(RowSet rs) throws SQLException {
		String text = String.format("(%,d) %s, %s, %S [%,d]", 
				rs.getInt("id"),
				rs.getString("name"),
				rs.getString("countrycode"),
				rs.getString("district"),
				rs.getInt("population")); 
		System.out.println(text);
	}
	
	private static class MyRowSet {
		
		public static CachedRowSet get(String propPath) throws SQLException {
			try {
				InputStream in = new FileInputStream(propPath);
				Properties p = new Properties();
				p.load(in);
				return prepareRS(p);
			} catch (IOException e) {
				System.out.println("Error loading Properties File");
				return null;
			}
		}
		
		private static CachedRowSet prepareRS(Properties p) throws SQLException {
			RowSetFactory rsf = RowSetProvider.newFactory();
			
			CachedRowSet rs = rsf.createCachedRowSet();
			rs.setUrl(p.getProperty("url"));
			rs.setUsername(p.getProperty("user"));
			rs.setPassword(p.getProperty("password"));
			return rs;
		}
		
	}

}
