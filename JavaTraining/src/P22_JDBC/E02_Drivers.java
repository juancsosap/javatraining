package P22_JDBC;

import java.sql.Driver;

public class E02_Drivers {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Driver driver;
		
		/*
		 *  ------ Drivers Types ------
		 *  * Type-1 : JDBC - ODBC Bridge Driver
		 *    (sun.jdbc.odbc.JdbcOdbcDriver)
		 *    - It comes with the JDK 
		 *    - Database Independent Driver
		 *    - No direct communication with the Database 
		 *    - Platform Dependent Driver (Windows), because Open Database Connectivity (ODBC) only operate in Windows
		 *    - Not supported from Java 8 SE
		 *    - Bad Performance or slow operation
		 *    - Two conversions are required JAVA-ODBC and ODBC-DATABASE
		 *    - Provided by the Java Vendor (SUN/ORACLE)
		 *    
		 *    JAVA APP <----> TYPE-1 DRIVER <----> ODBC DRIVER <----> DATABASE
		 *    ------------------------------------------------        --------
		 *                        CLIENT                                 DB
		 *     
		 *  * Type-2 : Native API-Partly Java Driver
		 *    (OCI Driver use oracle14.jar [Java 1.4] for 10g, oracle6.jar [Java 6] for 11g and oracle7.jar [Java 7] for 12g)
		 *    - Direct communication with the Database
		 *    - Vendor Provider Database Specific native libraries, often developed on C/C++
		 *    - Better Performance than Type-1 Drivers
		 *    - Platform and Database Dependent Driver, because use Native Libraries compiled for a specific Platform
		 *    - Provided by the Database Vendor, then there is no garanty of by available (Not available for MySQL)
		 *    - One conversion is required, because the libraries are develop to interact directly with the Database
		 *    
		 *    JAVA APP <----> TYPE-2 DRIVER <----> LIBRARIES <----> DATABASE
		 *    ----------------------------------------------        --------
		 *                        CLIENT                               DB
		 *    
		 *  * Type-3 : All Java Network Protocol Driver
		 *    (IDS Middleware)
		 *    - No direct communication with the Database
		 *    - Platform and Database Independent
		 *    - The middleware require drivers type-1/2/4 for communication with database
		 *    - Provided by the Middleware vendor
		 *    - Centralize the communications with databases, any change is made only in the middleware and not in the clients
		 *    - Slow Performace
		 *    - Almost 2 conversions are required, one in the client and one or two in the middleware depending the driver type used
		 *    
		 *    JAVA APP <----> TYPE-3 DRIVER <----> MIDDLEWARE <----> DATABASE
		 *    -----------------------------        ----------        --------
		 *              CLIENT                         MW               DB
		 *    
		 *  * Type-4 : Pure Java Driver (Thin Driver / Native Protocol Driver)
		 *    (oracle.jdbc.OracleDriver)
		 *    - Platform Independent
		 *    - All based on java
		 *    - The implementations use the database protocol specific
		 *    - Database dependent
		 *    - Only one conversion is required
		 *    - High Performance
		 *    - Provided by the database vendor
		 *    - Wide available between databases
		 *    - Direct communication with the database
		 *    
		 *    JAVA APP <----> TYPE-4 DRIVER <----> DATABASE
		 *    -----------------------------        --------
		 *              CLIENT                        DB
		 *    
		 */
		
	}
	
}
