package P18_StreamFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class E12_LongFileReadWrite {

	public static void main(String[] args) {

		String DIR = "files";
		
		String srcPathB = String.join(File.separator, DIR, "book.pdf");
		String dstPathB = String.join(File.separator, DIR, "book.pdf.bkp");
		
		BytesFileUtils.copy(srcPathB, dstPathB);
		
		String srcPathC = String.join(File.separator, DIR, "book.txt");
		String dstPathC = String.join(File.separator, DIR, "book.txt.bkp");
		
		CharacterFileUtils.copy(srcPathC, dstPathC);
		
	}
	
	private static class BytesFileUtils {
		
		public static void copy(String srcPath, String dstPath) {
			try(InputStream in = new FileInputStream(srcPath);
				OutputStream out = new FileOutputStream(dstPath)) {
				
				sleep(1);
				
				int bytes, totalBytes = 0, loops = 0;
				byte[] buffer = new byte[1024];
				while((bytes = in.read(buffer)) != -1) {
					out.write(buffer, 0, bytes);
					totalBytes += bytes;
					loops++;
				}
				System.out.printf("Total: %,.2f MB\n", (double) totalBytes/1024/1024);
				System.out.printf("Loops: %,d\n", loops);
				
			} catch(FileNotFoundException ex) {
				System.out.println("File not found");
			} catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		
	}
	
	private static class CharacterFileUtils {
		
		public static void copy(String srcPath, String dstPath) {
			try(Reader in = new FileReader(srcPath);
			    Writer out = new FileWriter(dstPath)) {
				
				sleep(1);
				
				int chars, totalChars = 0, loops = 0;
				char[] buffer = new char[1024];
				while((chars = in.read(buffer)) != -1) {
					out.write(buffer, 0, chars);
					totalChars += chars;
					loops++;
				}
				System.out.printf("Total: %,.2f MC\n", (double) totalChars/1024/1024);
				System.out.printf("Loops: %,d\n", loops);
				
			} catch(FileNotFoundException ex) {
				System.out.println("File not found");
			} catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		
	}
	
	private static void sleep(long milis) {
		try { Thread.sleep(milis); } catch (Exception e) {}
	}

}
