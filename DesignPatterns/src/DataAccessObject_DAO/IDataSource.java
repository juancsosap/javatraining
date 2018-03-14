package DataAccessObject_DAO;

import java.sql.Connection;

public interface IDataSource {
	
	public Connection createConnection();

}
