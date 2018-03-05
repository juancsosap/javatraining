package basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fileManipulation {

	private static String filePath = "";
	
	public static void main(String[] args) {
		
		setPath("src\\basic\\register.csv");
		
		read();

	}
	
	public static void setPath(String path) {
		filePath = path;
	}
	
	public static void write(String text) {
		try {
			FileWriter output = new FileWriter(filePath);
			for (int i=0; i<text.length(); i++) {
				output.write(text.charAt(i));
			}
			output.close();
		} catch (IOException e) {
			System.out.println("File not fount");;	
		}
	}
	
	public static void append(String text) {
		try {
			FileWriter output = new FileWriter(filePath, true);
			for (int i=0; i<text.length(); i++) {
				output.write(text.charAt(i));
			}
			output.close();
		} catch (IOException e) {
			System.out.println("File not fount");;	
		}
	}
	
	public static void read() {
		try {
			FileReader input = new FileReader(filePath);
			BufferedReader bufferRead = new BufferedReader(input);
			
			String line;
			do {
				line = bufferRead.readLine();
				if(line != null) {
					System.out.println(line);
				}
			} while(line != null);
			input.close();
		} catch (IOException e) {
			System.out.println("File not fount");;	
		}
	}

}
