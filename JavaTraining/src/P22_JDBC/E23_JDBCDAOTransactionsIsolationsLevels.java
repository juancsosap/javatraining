package P22_JDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class E23_JDBCDAOTransactionsIsolationsLevels {

	/*
     *  TRANSACTION_NONE (0)
     *  - Transactions Not supported
     *  
     *  TRANSACTION_READ_UNCOMMITTED (1)
     *  - Transactions Supported
     *  
     *  TRANSACTION_READ_COMMITTED (2)
     *  - Transactions Supported
     *  - Prevented Dirty Reads Isolation Transactions Problem
     *  
     *  TRANSACTION_REPEATABLE_READ (4)
     *  - Transactions Supported
     *  - Prevented Dirty Reads Isolation Transactions Problem
     *  - Prevented Non-Repeatable Reads Isolation Transactions Problem
     *  
     *  TRANSACTION_SERIALIZABLE (8)
     *  - Transactions Supported
     *  - Prevented Dirty Reads Isolation Transactions Problem
     *  - Prevented Non-Repeatable Reads Isolation Transactions Problem
	 *  - Prevented Phantom Reads Isolation Transactions Problem
	 *  
	 *  Oracle Database only support 2 (default) and 8 Transaction Isolation Levels
	 *  MySql Database only support 1, 2, 4 (default) and 8 Transaction Isolation Levels 
	 *  SQLServer Database only support 1, 2 (default), 4 and 8 Transaction Isolation Levels
	 */
	
	public static void main(String[] args) {
		
		String prop = "files/config_netec.properties";
		
		try(Connection conn = MyDataSource.get(prop).getConnection()){
			System.out.println("Default: " + getTransactionIsolationLevel(conn));
			
			conn.createStatement().executeUpdate("TRUNCATE TABLE person");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try(Connection conn = MyDataSource.get(prop).getConnection()){
			conn.setTransactionIsolation(Connection.TRANSACTION_NONE);
			System.out.println(getTransactionIsolationLevel(conn));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try(Connection conn1 = MyDataSource.get(prop).getConnection();
			Connection conn2 = MyDataSource.get(prop).getConnection()){
			
			conn1.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
			conn1.setAutoCommit(false);
			DAO<Person> db1 = new DAOPerson(conn1);
			
			conn2.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
			conn2.setAutoCommit(false);
			DAO<Person> db2 = new DAOPerson(conn2);
			
			System.out.println(getTransactionIsolationLevel(conn1));
			
			db1.create(Person.builder().id(1).name("Juan").surname("Sosa").age(36).build());
			
			System.out.println("Before Commit");
			db2.retriveAll().forEach(System.out::println);
			
			conn1.commit();
			
			System.out.println("After Commit");
			db2.retriveAll().forEach(System.out::println);
			
			conn2.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try(Connection conn1 = MyDataSource.get(prop).getConnection();
			Connection conn2 = MyDataSource.get(prop).getConnection()){
			
			conn1.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			conn1.setAutoCommit(false);
			DAO<Person> db1 = new DAOPerson(conn1);
			
			conn2.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			conn2.setAutoCommit(false);
			DAO<Person> db2 = new DAOPerson(conn2);
			
			System.out.println(getTransactionIsolationLevel(conn1));
			
			db1.create(Person.builder().id(2).name("Ana").surname("Prada").age(35).build());
			
			System.out.println("Before Commit");
			db2.retriveAll().forEach(System.out::println);
			
			conn1.commit();
			
			System.out.println("After Commit");
			db2.retriveAll().forEach(System.out::println);
			
			conn2.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try(Connection conn1 = MyDataSource.get(prop).getConnection();
			Connection conn2 = MyDataSource.get(prop).getConnection()){
			
			conn1.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
			conn1.setAutoCommit(false);
			DAO<Person> db1 = new DAOPerson(conn1);
			
			conn2.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
			conn2.setAutoCommit(false);
			DAO<Person> db2 = new DAOPerson(conn2);
			
			System.out.println(getTransactionIsolationLevel(conn1));
			
			System.out.println("Before Add");
			db2.retriveAll().forEach(System.out::println);
			
			db1.create(Person.builder().id(3).name("Beatriz").surname("Bonilla").age(55).build());
			
			System.out.println("Before Commit");
			db2.retriveAll().forEach(System.out::println);
			
			conn1.commit();
			
			System.out.println("After Commit");
			db2.retriveAll().forEach(System.out::println);
			
			conn2.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try(Connection conn1 = MyDataSource.get(prop).getConnection();
			Connection conn2 = MyDataSource.get(prop).getConnection()){
			
			conn1.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			conn1.setAutoCommit(false);
			DAO<Person> db1 = new DAOPerson(conn1);
			
			conn2.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			conn2.setAutoCommit(false);
			DAO<Person> db2 = new DAOPerson(conn2);
			
			System.out.println(getTransactionIsolationLevel(conn1));
			
			System.out.println("Before Add");
			db2.retriveAll().forEach(System.out::println);
			
			db1.create(Person.builder().id(4).name("Sarah").surname("Ahumada").age(15).build());
			
			System.out.println("Before Commit");
			db2.retriveAll().forEach(System.out::println);
			
			conn1.commit();
			
			System.out.println("After Commit");
			db1.retriveAll().forEach(System.out::println);
			
			System.out.println("After Commit");
			db2.retriveAll().forEach(System.out::println);
			
			conn2.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static String getTransactionIsolationLevel(Connection conn) throws SQLException {
		int level = conn.getTransactionIsolation();
		switch(level) {
			case Connection.TRANSACTION_SERIALIZABLE:
				return "TRANSACTION_SERIALIZABLE (" + level + ")";
			case Connection.TRANSACTION_REPEATABLE_READ:
				return "TRANSACTION_REPEATABLE_READ (" + level + ")";
			case Connection.TRANSACTION_READ_COMMITTED:
				return "TRANSACTION_READ_COMMITTED (" + level + ")";
			case Connection.TRANSACTION_READ_UNCOMMITTED:
				return "TRANSACTION_READ_UNCOMMITTED (" + level + ")";
			default:
				return "TRANSACTION_NONE (" + level + ")";
		}
	}
	
	private static class Person {
		
		public int id; 
		public String name;
		public String surname;
		public int age; 
		
		@Override
		public String toString() {
			return String.format("(%,d) %s, %s [%,d]", id, surname.toUpperCase(), name, age);
		}
		
		public static PersonBuilder builder() {
			return new PersonBuilder();
		}
		
		@SuppressWarnings("unused")
		public PersonBuilder rebuild() {
			return new PersonBuilder(this);
		}
		
		public static class PersonBuilder {
			
			private Person person;
			
			public PersonBuilder() {
				this.person = new Person(); 
			}
			
			public PersonBuilder(Person p) {
				this.person = p; 
			}
			
			public PersonBuilder id(int id) {
				this.person.id = id;
				return this;
			}
			
			public PersonBuilder name(String name) {
				this.person.name = name;
				return this;
			}
			
			public PersonBuilder surname(String surname) {
				this.person.surname = surname;
				return this;
			}
			
			public PersonBuilder age(int age) {
				this.person.age = age;
				return this;
			}
			
			public Person build() {
				return person;
			}
			
		}
		
	}
	
	private static interface DAO<T> {
		public void create(T dato) throws SQLException;
		public T retrive(int id) throws SQLException;
		public List<T> retriveAll(int limit, int offset) throws SQLException;
		public List<T> retriveAll() throws SQLException;
		public void update(T dato) throws SQLException;
		public void delete(int id) throws SQLException;
	}
	
	private static class DAOPerson implements DAO<Person> {

		private Connection conn;
		
		public DAOPerson(Connection conn) throws SQLException {
			this.conn = conn;
		}
		
		@Override
		public void create(Person dato) throws SQLException {
			String sql = "INSERT INTO person (id, name, surname, age) "
					   + "VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, dato.id);
			ps.setString(2, dato.name);
			ps.setString(3, dato.surname);
			ps.setInt(4, dato.age);
			
			ps.executeUpdate();
		}
		
		@Override
		public Person retrive(int id) throws SQLException {
			String sql = "SELECT * FROM person "
					   + "WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				return Person.builder().id(rs.getInt("id"))
						               .name(rs.getString("name"))
						               .surname(rs.getString("surname"))
						               .age(rs.getInt("age"))
						               .build();
			else
				return null;
		}
		
		@Override
		public List<Person> retriveAll(int limit, int offset) throws SQLException {
			String sql = "SELECT * FROM person "
					   + "LIMIT ?, ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, offset);
			ps.setInt(2, limit);
			
			ResultSet rs = ps.executeQuery();
			
			List<Person> people = new ArrayList<>();
			while(rs.next()) {
				people.add(Person.builder().id(rs.getInt("id"))
			                               .name(rs.getString("name"))
			                               .surname(rs.getString("surname"))
			                               .age(rs.getInt("age"))
			                               .build());
			}
			
			return people;
		}
		
		@Override
		public List<Person> retriveAll() throws SQLException { 
			return this.retriveAll(10, 0); 
		}
			
		@Override
		public void update(Person dato) throws SQLException {
			String sql = "UPDATE person "
					   + "SET name=?, surname=?, age=? "
					   + "WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, dato.name);
			ps.setString(2, dato.surname);
			ps.setInt(3, dato.age);
			ps.setInt(4, dato.id);
			
			ps.executeUpdate();
		}
		
		@Override
		public void delete(int id) throws SQLException {
			String sql = "DELETE FROM person "
					   + "WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
		}
		
	}
	
	private static class MyDataSource {
		
		public static DataSource get(String propPath) {
			try {
				InputStream in = new FileInputStream(propPath);
				Properties p = new Properties();
				p.load(in);
				return prepareDS(p);
			} catch (IOException e) {
				System.out.println("Error loading Properties File");
				return null;
			}
		}
		
		private static DataSource prepareDS(Properties p) {
			MysqlDataSource mds = new MysqlDataSource();
			mds.setURL(p.getProperty("url"));
			mds.setUser(p.getProperty("user"));
			mds.setPassword(p.getProperty("password"));
			return mds;
		}
		
	}
		
}
