package P22_JDBC;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.RowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class E30_JDBCJoinRowSet {

	public static void main(String[] args) throws SQLException {
		
		String prop = "files/config.properties";
		String xmlpath = "files/countrycities.xml";
		
		RowSet rs1 = MyRowSet.get(prop);
		rs1.setCommand("SELECT code, name, continent, region FROM country LIMIT 3");
		rs1.execute();
		
		RowSet rs2 = MyRowSet.get(prop);
		rs2.setCommand("SELECT countrycode, name, population FROM city");
		rs2.execute();
		
		RowSetFactory rsf = RowSetProvider.newFactory();
		JoinRowSet jrs = rsf.createJoinRowSet();
		
		jrs.addRowSet(rs1, "code");
		jrs.addRowSet(rs2, "countrycode");
		
		try(OutputStream out = new FileOutputStream(xmlpath)) {
			jrs.writeXml(out);
		} catch (IOException ex) {
			System.out.println(ex);
		}
		
		ResultSetMetaData md = jrs.getMetaData();
		
		jrs.beforeFirst();
		while(jrs.next()) {
			System.out.println("------------------");
			for(int i=1; i<=md.getColumnCount(); i++) {
				System.out.print(md.getColumnName(i) + ": ");
				System.out.print(jrs.getObject(i));
				System.out.println(" [" + md.getColumnTypeName(i) + "]");
			}
			System.out.println("------------------");
		}
		
	}
	
	private static class MyRowSet {
		
		public static RowSet get(String propPath) throws SQLException {
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
		
		private static RowSet prepareRS(Properties p) throws SQLException {
			RowSetFactory rsf = RowSetProvider.newFactory();
			
			RowSet rs = rsf.createCachedRowSet();
			rs.setUrl(p.getProperty("url"));
			rs.setUsername(p.getProperty("user"));
			rs.setPassword(p.getProperty("password"));
			return rs;
		}
		
	}

}
