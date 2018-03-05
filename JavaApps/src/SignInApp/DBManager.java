package SignInApp;

import DataUtilities.MySQLUtil;

class DBManager extends MySQLUtil {
	
	private static final String URL = "localhost";
	private static final String USER = "root";
	private static final String PASS = "roottoor";
	private static final String PORT = "3306";
	
	public DBManager(String db) {
		super(DBManager.USER, DBManager.PASS, db, DBManager.URL, DBManager.PORT);
	}
	
	public void insertData(String name, String surname, String age) {
		String[] fields = {"name", "surname", "age"};
		String[] values = {name, surname, age};
		this.sqlInsert("person", fields, values);
	}
	
	public String[] selectData(String id) {
		String[] fields = {"name", "surname", "age"};
		String[] condFields = {"id"};
		String[] condValues = {id};
		String[][] result = this.sqlSelect("person", fields, condFields, condValues);
		return (result.length > 0) ? result[0] : null;
	}
	
	public boolean uniqueData(String name, String surname) {
		String[] fields = {"name", "surname"};
		String[] values = {name, surname};
		
		int rows = this.sqlSelect("person", fields, 
				                  fields, values).length;
		return (rows == 0);
	}
	
}