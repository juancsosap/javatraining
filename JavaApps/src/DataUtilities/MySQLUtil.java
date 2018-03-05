package DataUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MySQLUtil {
	
	private final String DRIVER = "jdbc:mysql";
	
	private String user, password, fullURL, db;
	
	public MySQLUtil(String user, String password, String db, String url, String port) {
		this.setDB(db, url, port);
		this.setUser(user, password);
	}
	
	public void setUser(String user, String password) {
		this.user = user;
		this.password = password;
	}
	
	public void setDB(String db, String url, String port) {
		this.db = db;
		this.fullURL = this.DRIVER + "://" + url + ":" + port + "/";
	}
	
	public void setDB(String db, String url) {
		this.setDB(db, url, "3306");
	}
	
	private String getURL(String url, String db) {
		return url + db + "?useSSL=false";
	}
	
	public void sqlInsert(String table, String[] fields, String[] values) {
		if(fields.length == values.length) {
			try {
				Connection connection = DriverManager.getConnection(this.getURL(this.fullURL, this.db) , this.user, this.password);
				Statement sql = connection.createStatement();
				
				String sqlStr, fieldsStr = "", valuesStr = "";
				
				String[] types = this.getDataTypes(table, fields, sql);
				
				for(int i=0; i<fields.length; i++) {
					fieldsStr += fields[i];
					fieldsStr += i<fields.length-1 ? ", " : "";
					
					valuesStr += types[i].equals("char") ? "'" + values[i] + "'" : values[i];
					valuesStr += i<values.length-1 ? ", " : "";
				}
				
				sqlStr = "INSERT INTO " + table + " (" + fieldsStr + ") VALUES (" + valuesStr + ")";
				System.out.println(sqlStr);
				sql.executeUpdate(sqlStr);
				
				connection.close();
			} catch (SQLException e) {
				System.out.println("DB Connection Failed : Insert");
				e.printStackTrace();
			}
		} else {
			System.out.println("Fields and Values Arrays length don't match");
		}
	}
	
	public void sqlUpdate(String table, String[] condFields, String[] condValues, String[] fields, String[] values) {
		if(fields.length == values.length && condFields.length == condValues.length) {
			try {
				Connection connection = DriverManager.getConnection(this.getURL(this.fullURL, this.db) , this.user, this.password);
				Statement sql = connection.createStatement();
				
				String sqlStr, setStr = "", whereStr = "";
				
				String[] types = this.getDataTypes(table, fields, sql);
				String[] condTypes = this.getDataTypes(table, condFields, sql);
				
				for(int i=0; i<fields.length; i++) {
					setStr += fields[i] + " = " + (types[i].equals("char") ? "'" + values[i] + "'" : values[i]);
					setStr += i<fields.length-1 ? ", " : "";
				}
				
				for(int i=0; i<condFields.length; i++) {
					whereStr += condFields[i] + " = " + (condTypes[i].equals("char") ? "'" + condValues[i] + "'" : condValues[i]);
					whereStr += i<condFields.length-1 ? " AND " : "";
				}
				
				sqlStr = "UPDATE " + table + " SET " + setStr + " WHERE " + whereStr;
				System.out.println(sqlStr);
				sql.executeUpdate(sqlStr);
				
				connection.close();
			} catch (SQLException e) {
				System.out.println("DB Connection Failed : Update");
				e.printStackTrace();
			}
		} else {
			System.out.println("Fields and Values Arrays length don't match");
		}
	}
	
	public String[][] sqlSelect(String table, String[] fields, String[] condFields, String[] condValues) {
		if(condFields.length == condValues.length) {
			try {
				Connection connection = DriverManager.getConnection(this.getURL(this.fullURL, this.db), this.user, this.password);
				Statement sql = connection.createStatement();
				
				String sqlStr, whereStr = "", fieldsStr = "";
				
				String[] condTypes = this.getDataTypes(table, condFields, sql);
				
				for(int i=0; i<fields.length; i++) {
					fieldsStr += fields[i];
					fieldsStr += i<fields.length-1 ? ", " : "";
				}
				
				for(int i=0; i<condFields.length; i++) {
					whereStr += condFields[i] + " = " + (condTypes[i].equals("char") ? "'" + condValues[i] + "'" : condValues[i]);
					whereStr += i<condFields.length-1 ? " AND " : "";
				}
				
				sqlStr = "SELECT " + fieldsStr + " FROM " + table + " WHERE " + whereStr;
				System.out.println(sqlStr);
				ResultSet result = sql.executeQuery(sqlStr);
				
				ArrayList<String> fullResult = new ArrayList<String>();
				while(result.next()) {
					for(int i=0; i<fields.length; i++) {
						fullResult.add(result.getString(fields[i]));
					}
				}
				
				connection.close();
				
				int columns = fields.length;
				int rows = fullResult.size()/columns;
				System.out.println(columns + " " + rows);
				String[][] resultArray = new String[rows][columns];
				
				// 3 ROWS / 5 COLUMNS
				// A B C D E F G H I J K  L  M  N  O
				// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14
				
				// 0 1 2 3 4  I
				// A B C D E  J=0
				// F G H I J  J=1
				// K L M N O  J=2
				
				for(int i=0; i<columns; i++) {
					for(int j=0; j<rows; j++) {
						resultArray[j][i] = fullResult.get(j * columns + i);
					}
				}
				
				return resultArray;
			} catch (SQLException e) {
				System.out.println("DB Connection Failed : Select");
				e.printStackTrace();
			}
		} else {
			System.out.println("Fields and Values Arrays length don't match");
		}
		return null;
	}
	
	private String[] getDataTypes(String table, String[] fields, Statement sql) {
		try {
			
			String sqlStr = "SELECT data_type FROM information_schema.columns " +
		                    "WHERE table_schema = '" + this.db + "' AND " +
		                    "table_name = '" + table + "' AND ";
			
			String columnsStr = "";
			for(int i=0; i<fields.length; i++) {
				columnsStr += "column_name = '" + fields[i] + "'";
				columnsStr += i<fields.length-1 ? " OR " : "";
			}
			sqlStr += "(" + columnsStr + ")";
			System.out.println(sqlStr);
			ResultSet result = sql.executeQuery(sqlStr);
				
			ArrayList<String> fullResult = new ArrayList<String>();
			while(result.next()) {
				fullResult.add(result.getString("data_type"));
			}
			
			String[] resultArray = new String[fullResult.size()];
			
			for(int i=0; i<fullResult.size(); i++) {
				resultArray[i] = fullResult.get(i);
			}
			
			return resultArray;
			
		} catch (SQLException e) {
			System.out.println("DB Connection Failed : GetDataTypes");
			e.printStackTrace();
			return null;
		}
	}

}
