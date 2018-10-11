package P22_JDBC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class E17_JDBCBLOB {

	public static void main(String[] args) {
		
		/*
		 *  Large OBjects (LOB) -------> Binary LOB (BLOB) [Images/Audios/Videos]
		 *                      -------> Character LOB (CLOB/TEXT) [Documents]
		 *  
		 *  TINYBLOB   :     maximum length of 255 bytes  
		 *  BLOB       :     maximum length of 65,535 bytes  
         *  MEDIUMBLOB :     maximum length of 16,777,215 bytes  
         *  LONGBLOB   :     maximum length of 4,294,967,295 bytes  
		 *  
		 */
		
		
		// Driver is required
		String connString = getConnectionString();
		try(Connection conn = DriverManager.getConnection(connString, "root", "roottoor");
			Scanner console = new Scanner(System.in)) {
			
			conn.createStatement().executeUpdate("DROP TABLE IF EXISTS users");
			
			conn.createStatement().executeUpdate("CREATE TABLE users (" + 
					"id INT NOT NULL AUTO_INCREMENT UNIQUE, " + 
					"username VARCHAR(100) NOT NULL UNIQUE, " + 
					"password VARCHAR(100) NOT NULL," +
					"image MEDIUMBLOB)");
			
			String sqlTemplate = "INSERT INTO users (username, password, image) VALUES (?, ?, ?)";
			PreparedStatement pstat = conn.prepareStatement(sqlTemplate);
						
			System.out.println("USER REGISTRATION");
			
			while(true) {
				System.out.print("Username: ");
				String username = console.nextLine();
				
				System.out.print("Password: ");
				String password = console.nextLine();
				
				System.out.print("Image Path: ");
				String path = console.nextLine();
				
				try(InputStream image = new FileInputStream(path)){
					pstat.setString(1, username);
					pstat.setString(2, password);
					pstat.setBlob(3, image, image.available());
					
					int rowCount = pstat.executeUpdate();
					
					if(rowCount == 0)
						System.out.println("The record couldn't be created");
					else
						System.out.println("user register");
				} catch (FileNotFoundException e) {
					System.out.println("The Image path is invalid");
				} catch (IOException e) {
					System.out.println("Problems to access the image file");
				}
				
				System.out.println();
				
				System.out.print("Do you want to register another user? (yes/no): ");
				String option = console.nextLine();
				
				if(option.equalsIgnoreCase("no")) break;
			}
			
			Statement stat = conn.createStatement();
			
			ResultSet result = stat.executeQuery("SELECT * FROM users");
			
			while(result.next()) {
				System.out.println("-----------------------------");
				System.out.println("ID: " + result.getInt("id"));
				System.out.println("Username: " + result.getString("username"));
				System.out.println("Password: " + result.getString("password"));
				System.out.println("-----------------------------");
				System.out.println();
				
				Path storeFile = Paths.get("files/tempfile" + result.getInt("id") + ".jpg");
				
				try(InputStream in = result.getBlob("image").getBinaryStream();
					OutputStream out = new FileOutputStream(storeFile.toString())) {
					
					int bytes;
					byte[] buffer = new byte[in.available()];
					while((bytes = in.read(buffer)) != -1) {
						out.write(buffer, 0, bytes);
					}
				} catch (FileNotFoundException e) {
					System.out.println("Invalid Destination Path");
				} catch (IOException e) {
					System.out.println("Error accessing the files");
				}
				
			} 
			
		} catch (SQLException ex) {
			System.out.println("Problems with the Database");
		}
		
	}
	
	private static String getConnectionString() {
		String driver = "jdbc:mysql";
		String host = "localhost";
		int port = 3306;
		String database = "netec";
		String options = "useSSL=false";
		
		return String.format("%s://%s:%s/%s?%s", driver, host, port, database, options);
	}
	
}
