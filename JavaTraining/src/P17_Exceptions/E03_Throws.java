package P17_Exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class E03_Throws {

	public static void main(String[] args) {
			
		try {
			System.out.println(fileOpen("myfile.txt"));
		} catch(RuntimeException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	private static String fileOpen(String path) throws RuntimeException {
		try {
			InputStream file = new FileInputStream(path);
			file.close();
			return "File Open Successfully";
		} catch(FileNotFoundException ex) {
			throw new RuntimeException("Error: File not Found");
		} catch(IOException ex) {
			throw new RuntimeException("Error: Closing problems");
		} catch(Exception ex) {
			throw new RuntimeException("Error: Unknown problem");
		} finally {
			System.out.println("File Openner Excecuted");
		}
	}

}
