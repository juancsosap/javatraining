package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection implements AutoCloseable {

    private final Connection conn;
    private final Config config;
    
    private static DBConnection instance = null;
    
    private DBConnection() throws SQLException {
    	this.config = Config.load("config.properties");
        this.conn = DriverManager.getConnection(this.config.get("url"), this.config.getProperties());
    }
    
    public static DBConnection get() throws SQLException {
        if(instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }    
    
	@Override
    public void close() throws Exception {
        if(!this.conn.isClosed()) {
            this.conn.close();
        }
    }
	
	public ResultSet executeQuery(String sql, Object ... datos) throws SQLException {
        PreparedStatement stat = this.conn.prepareStatement(sql);
        for(int i=0; i<datos.length; i++) {
            stat.setObject(i+1, datos[i]);
        }
        return stat.executeQuery();
    }

    public int executeUpdate(String sql, Object ... datos) throws SQLException {
        PreparedStatement stat = this.conn.prepareStatement(sql);
        for(int i=0; i<datos.length; i++) {
            stat.setObject(i+1, datos[i]);
        }
        return stat.executeUpdate();
    }
	
}
