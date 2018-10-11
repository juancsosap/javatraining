package P22_JDBC;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class E25_JDBCRowSet {

	// There are implementations from DB Vendors and Java Vendor (ORACLE/SUN)
	
	/*
	 *  RowSet
	 *  - By default Scrollable
	 *  - By default Updateable
	 *  - Is Serializable (ResultSet isn't)
	 *  - Could be accessed with Connected o Disconnected state with the DB 
	 *    (ResultSet require be Connected)
	 *    
	 *  Types
	 *  * Connected RowSets (JdbcRowSet(I))
	 *    - Not Serializable
	 *    - DB Connection required
	 *     
	 *  * Disconnected RowSets (CachedRowSet(I) / WebRowSet(I) / JoinRowSet(I) / FilterRowSet(I))
	 *    - Serializable
	 *    - Not DB Connection required
	 *    
	 *  ResultSet(I) <-- RowSet(I) <-- JdbcRowSet(I)
	 *                             <-- CachedRowSet(I) <-- WebRowSet(I) <-- JoinRowSet(I)
	 *                                                                  <-- FilteredRowSet(I)
	 *                                                                  
	 *  Was introduced on Java 1.4 but require to use DB Vendor implementations Class names
	 *  But from Java 1.7 the process was simplified
	 *                                                   
	 */
	
	public static void main(String[] args) throws SQLException {
		
		RowSetFactory rsf = RowSetProvider.newFactory();
		
		RowSet rs = rsf.createJdbcRowSet();
		System.out.println(rs.getClass().getName());
		
		JdbcRowSet jdbcrs = rsf.createJdbcRowSet();
		System.out.println(jdbcrs.getClass().getName());
		
		CachedRowSet crs = rsf.createCachedRowSet();
		System.out.println(crs.getClass().getName());
		
		WebRowSet wrs = rsf.createWebRowSet();
		System.out.println(wrs.getClass().getName());
		
		JoinRowSet jrs = rsf.createJoinRowSet();
		System.out.println(jrs.getClass().getName());
		
		FilteredRowSet frs = rsf.createFilteredRowSet();
		System.out.println(frs.getClass().getName());
		
	}

}
