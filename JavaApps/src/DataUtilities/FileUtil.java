package DataUtilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtil {
	
	private String filePath;
	
	public FileUtil(String path) {
		this.filePath = path;
	}
	
	public void writeLine(String text, boolean append) {
		try {
			FileWriter output = new FileWriter(this.filePath, append);
			output.write(text + "\r\n");
			output.close();
		} catch (IOException e) {
			System.out.println("File not found");;	
		}
	}
	
	public void writeFile(ArrayList<String> lines, boolean append) {
		try {
			FileWriter output = new FileWriter(this.filePath, append);
			for(int i=0; i<lines.size(); i++) {
				output.write(lines.get(i) + "\r\n");
			}
			output.close();
		} catch (IOException e) {
			System.out.println("File not found");;	
		}
	}
	
	public void writeLine(String text) {
		this.writeLine(text, false);
	}
	
	public void appendLine(String text) {
		this.writeLine(text, true);
	}
	
	public String readLine(int index) {
		String line = "";
		try {
			FileReader input = new FileReader(this.filePath);
			BufferedReader bufferRead = new BufferedReader(input);
			int i = 0;
			do {
				line = bufferRead.readLine();
				if(i == index) { break; }
				i++;
			} while(line != null);
			input.close();
		} catch (IOException e) {
			System.out.println("File not fount");;	
		}
		return line;
	}
	
	public ArrayList<String> readFile() { 
		ArrayList<String> lines = new ArrayList<String>();
		try {
			FileReader input = new FileReader(this.filePath);
			BufferedReader bufferRead = new BufferedReader(input);
			
			String line;
			do {
				line = bufferRead.readLine();
				if(line != null) {
					lines.add(line);
				}
			} while(line != null);
			
			input.close();
		} catch (IOException e) {
			System.out.println("File not fount");;	
		}
		return lines;
	}

}
