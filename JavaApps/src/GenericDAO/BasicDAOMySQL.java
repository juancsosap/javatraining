package GenericDAO;

import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.*;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class BasicDAOMySQL<T extends Storable<T, K>, K> 
                             implements BasicDAOList<T, K>, AutoCloseable {

	protected Connection conn;
	protected Config config;
	
	public BasicDAOMySQL(String path) {
		this.config = new Config(path);
		try {
			this.conn = DriverManager.getConnection(config.get("ConnectionString"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean create(T obj) {
		try(PreparedStatement pstat = conn.prepareStatement(config.get("sql.create"))) {
			fillStatement(pstat, obj, obj.getSelector(1, 2, 3));
			int rowCount = pstat.executeUpdate();
			return rowCount > 0;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean retrive(K id, T obj) {
		try(PreparedStatement pstat = conn.prepareStatement(config.get("sql.retrive"))) {
			fillStatement(pstat, obj, obj.getSelector(1, 0, 0));
			ResultSet result = pstat.executeQuery();
			int rowCount = result.getFetchSize();
			if(rowCount > 0)
				obj.fromList(toList(result).get(0));
			return rowCount > 0;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(K id, T obj) {
		try(PreparedStatement pstat = conn.prepareStatement(config.get("sql.update"))) {
			fillStatement(pstat, obj, obj.getSelector(3, 1, 2));
			int rowCount = pstat.executeUpdate();
			return rowCount > 0;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(T obj) {
		try(PreparedStatement pstat = conn.prepareStatement(config.get("sql.delete"))) {
			fillStatement(pstat, obj, obj.getSelector(1, 0, 0));
			int rowCount = pstat.executeUpdate();
			return rowCount > 0;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public void close() throws Exception {
		this.conn.close();
	}
	
	protected PreparedStatement fillStatement(PreparedStatement pstat, T obj, Selector selector) {
		try {
			ResultSetMetaData md = pstat.getMetaData();
			
			List<Object> record = obj.toList();
			
			for(int i=1; i<=selector.size(); i++) {
				int type = md.getColumnType(i);
				if(selector.get(i) != 0)
					setArgument(selector.get(i), type, record.get(i - 1), pstat);
			}
			
			return pstat;
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	protected void setArgument(int i, int type, Object value, PreparedStatement pstat) {
		try {
			switch(type) {
				case Types.BIT:
					pstat.setBoolean(i, (Boolean) value);
					break;
				case Types.TINYINT:
				case Types.SMALLINT:
				case Types.INTEGER:
					pstat.setInt(i, (Integer) value);
					break;
				case Types.BIGINT:
					pstat.setLong(i, (Long) value);
					break;
				case Types.NUMERIC:
				case Types.DECIMAL:
					pstat.setBigDecimal(i, (BigDecimal) value);
					break;
				case Types.CHAR:
				case Types.VARCHAR:
				case Types.LONGVARCHAR:
				case Types.LONGNVARCHAR:
					pstat.setString(i, (String) value);
					break;
				case Types.REAL: 
					pstat.setFloat(i, (Float) value);
					break;
				case Types.FLOAT:
				case Types.DOUBLE:
					pstat.setDouble(i, (Double) value);
					break;
				case Types.BINARY:
				case Types.VARBINARY:
				case Types.LONGVARBINARY:
					pstat.setBytes(i, (byte[]) value);
					break;
				case Types.DATE:
					pstat.setDate(i, Date.valueOf((LocalDate) value));
					break;
				case Types.TIME:
				case Types.TIME_WITH_TIMEZONE:
					pstat.setTime(i, Time.valueOf((LocalTime) value));
					break;
				case Types.TIMESTAMP:
				case Types.TIMESTAMP_WITH_TIMEZONE:
					pstat.setTimestamp(i, Timestamp.valueOf((LocalDateTime) value));
					break;
				case Types.BLOB:
				case Types.CLOB:
				case Types.NCLOB:
					pstat.setBlob(i, (InputStream) value);
					break;
				default:
					pstat.setObject(i, value);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	protected Object getField(int i, int type, ResultSet result) {
		try {
			switch(type) {
				case Types.BIT:
					return result.getBoolean(i);
				case Types.TINYINT:
				case Types.SMALLINT:
				case Types.INTEGER:
					return result.getInt(i);
				case Types.BIGINT:
					return result.getLong(i);
				case Types.NUMERIC:
				case Types.DECIMAL:
					return result.getBigDecimal(i);
				case Types.CHAR:
				case Types.VARCHAR:
				case Types.LONGVARCHAR:
				case Types.LONGNVARCHAR:
					return result.getString(i);
				case Types.REAL: 
					return result.getFloat(i);
				case Types.FLOAT:
				case Types.DOUBLE:
					return result.getDouble(i);
				case Types.BINARY:
				case Types.VARBINARY:
				case Types.LONGVARBINARY:
					return result.getBytes(i);
				case Types.DATE:
					return result.getDate(i).toLocalDate();
				case Types.TIME:
				case Types.TIME_WITH_TIMEZONE:
					return result.getTime(i).toLocalTime();
				case Types.TIMESTAMP:
				case Types.TIMESTAMP_WITH_TIMEZONE:
					return result.getTimestamp(i).toLocalDateTime();
				case Types.BLOB:
				case Types.CLOB:
				case Types.NCLOB:
					return result.getBlob(i).getBinaryStream();
				default:
					return result.getObject(i);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	protected List<List<Object>> toList(ResultSet result) {
		List<List<Object>> table = new ArrayList<>();
		try {
			ResultSetMetaData md = result.getMetaData();
			int columnsNumber = md.getColumnCount();
			while(result.next()) {
				List<Object> record = new ArrayList<>();
				
				for(int i = 1; i <= columnsNumber; i++) {
					int type = md.getColumnType(i);
					record.add(getField(i, type, result));
				}
				
				table.add(record);
			}
			return table;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
