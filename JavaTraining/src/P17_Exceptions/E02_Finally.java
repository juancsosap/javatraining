package P17_Exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class E02_Finally {

	public static void main(String[] args) {
			
		System.out.println(fileOpen("myfile.txt"));
		
	}
	
	private static String fileOpen(String path) {
		try {
			InputStream file = new FileInputStream(path);
			file.close();
			return "File Open Successfully";
		} catch(FileNotFoundException ex) {
			return "Error: File not Found";
		} catch(IOException ex) {
			return "Error: Closing problems";
		} catch(Exception ex) {
			return "Error: Unknown problem";
		} finally {
			System.out.println("File Openner Excecuted");
		}
	}

}
