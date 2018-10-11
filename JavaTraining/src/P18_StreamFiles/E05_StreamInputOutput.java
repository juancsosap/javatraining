package P18_StreamFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class E05_StreamInputOutput {

	public static void main(String[] args) {

		String DIR = "files";
		
		String srcPath = String.join(File.separator, DIR, "book.pdf");
		String dstPath = String.join(File.separator, DIR, "book.pdf.bkp");
		
		BytesFileUtils.copy(srcPath, dstPath);
		
	}
	
	private static class BytesFileUtils {
		
		public static void copy(String srcPath, String dstPath) {
			try(InputStream in = new FileInputStream(srcPath);
				OutputStream out = new FileOutputStream(dstPath)) {
				
				int dato;
				while((dato = in.read()) != -1) {
					out.write(dato);
				}
				
			} catch(FileNotFoundException ex) {
				System.out.println("File not found");
			} catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		
	}
	
}
