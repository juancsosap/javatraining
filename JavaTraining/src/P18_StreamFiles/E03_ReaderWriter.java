package P18_StreamFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class E03_ReaderWriter {

	public static void main(String[] args) {

		String DIR = "files";
		
		String path = String.join(File.separator, DIR, "myFile.txt");
		String text = "Java is a set of computer software and specifications\n"
				+ "developed by James Gosling at Sun Microsystems, which was\n"
				+ "later acquired by the Oracle Corporation, that provides a\n"
				+ "system for developing application software and deploying\n"
				+ "it in a cross-platform computing environment.\n";
		
		CharacterFileUtils.write(text, path, true);
		CharacterFileUtils.read(path);
		
	}
	
	private static class CharacterFileUtils {
		
		public static void write(String text, String path, boolean append) {
			try(Writer out = new FileWriter(path, append)) {
				out.write(text);
				try {
					Thread.sleep(10_000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				out.write(text);
			} catch(FileNotFoundException ex) {
				System.out.println("File not found");
			} catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		
		public static void read(String path) {
			try(Reader in = new FileReader(path)) {
				int c;
				while((c = in.read()) != -1) {
					System.out.print((char) c);
				}
			} catch(FileNotFoundException ex) {
				System.out.println("File not found");
			} catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		
	}
	
}
