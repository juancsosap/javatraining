package P22_JDBC;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.RowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class E29_JDBCWebRowSet {

	public static void main(String[] args) throws SQLException {
		
		String prop = "files/config.properties";
		String xmlpath = "files/world.xml";
		
		WebRowSet rs1 = MyRowSet.get(prop);
		
		rs1.setCommand("SELECT * FROM city LIMIT 5");
		rs1.execute();
		
		while(rs1.next()) { printRecord(rs1); }
		
		System.out.println();
		
		try(OutputStream out = new FileOutputStream(xmlpath)) {
			rs1.writeXml(out);
		} catch (IOException ex) {
			System.out.println(ex);
		}
		
		WebRowSet rs2 = MyRowSet.get(prop);
		
		try(InputStream in = new FileInputStream(xmlpath)) {
			rs2.readXml(in);
		} catch (IOException ex) {
			System.out.println(ex);
		}
		
		while(rs2.next()) { printRecord(rs2); }
		
		
		
		
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
		
		public static WebRowSet get(String propPath) throws SQLException {
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
		
		private static WebRowSet prepareRS(Properties p) throws SQLException {
			RowSetFactory rsf = RowSetProvider.newFactory();
			
			WebRowSet rs = rsf.createWebRowSet();
			rs.setUrl(p.getProperty("url"));
			rs.setUsername(p.getProperty("user"));
			rs.setPassword(p.getProperty("password"));
			return rs;
		}
		
	}

}
