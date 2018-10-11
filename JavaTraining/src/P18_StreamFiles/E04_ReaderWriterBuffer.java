package P18_StreamFiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class E04_ReaderWriterBuffer {

	public static void main(String[] args) {

		String DIR = "files";
		
		String srcPath = String.join(File.separator, DIR, "myFile.txt");
		String dstPath = String.join(File.separator, DIR, "myFile.txt.bkp");
		
		CharacterFileUtils.copy(srcPath, dstPath);
		
	}
	
	private static class CharacterFileUtils {
		
		public static void copy(String srcPath, String dstPath) {
			try(Reader in = new FileReader(srcPath);
			    BufferedReader inBuffer = new BufferedReader(in);
				Writer out = new FileWriter(dstPath);
				BufferedWriter outBuffer = new BufferedWriter(out)) {
				
				String line;
				while((line = inBuffer.readLine()) != null) {
					outBuffer.write(line + "\n");
				}
				
			} catch(FileNotFoundException ex) {
				System.out.println("File not found");
			} catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		
	}
	
}
