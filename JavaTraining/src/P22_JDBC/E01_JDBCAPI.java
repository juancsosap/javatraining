package P22_JDBC;

import java.sql.*;
import javax.sql.*;

public class E01_JDBCAPI {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// Java Data Base Connectivity (JDBC)
		
		// JAVA APP <----> JDBC <----> DATABASE
		//                Driver
		//              Connection
		//               Statement
		//               ResultSet
		
		// JDBC API
		Driver driver;
		Connection conn;
		DatabaseMetaData dbmd;
		Statement stat;
		PreparedStatement pstat;
		CallableStatement cstat;
		ResultSet rs;
		ResultSetMetaData rsmd;
		
		DriverManager dman;
		Date date;
		Time time;
		Timestamp times;
		Types types;
		
		// JDBC API 2
		DataSource ds;
		RowSet rws;
		RowSetListener rsl;
		RowSetMetaData rwsmd;
		RowSetEvent rse;
		ConnectionEvent ce;
		
	}

}
