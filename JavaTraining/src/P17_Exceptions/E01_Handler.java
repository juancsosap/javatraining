package P17_Exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class E01_Handler {

	public static void main(String[] args) {
		
		/*
		 *                            
		 *  Throwable -> Exception -> RuntimeException -> ArithmeticException
		 *                                             -> ...
		 *                         -> SQLException     -> SQLClientInfoException
		 *                                             -> ...                    
		 *                         -> IOException      -> FileNotFoundException
		 *                                             -> ... 
		 *            -> Error
		 */
		
		Scanner console = new Scanner(System.in);
		
		String strIn1 = console.nextLine();
		Integer intIn1 = Integer.parseInt(strIn1); 
		System.out.println(intIn1);
		
		try {
			String strIn2 = console.nextLine();
			Integer intIn2 = Integer.parseInt(strIn2); 
			System.out.println(intIn2);
		} catch(NumberFormatException ex) {
			System.out.println("Invalid Input");
		} catch(RuntimeException ex) {
			System.out.println("RT Error: " + ex.getMessage());
		} catch(Exception ex) {
			System.out.println("UD Error: " + ex.getMessage());
		}
		
		try {
			InputStream file = new FileInputStream("myfile.txt"); 
			file.close();
		} catch(FileNotFoundException ex) {
			System.out.println("File not Found");
		} catch(IOException ex) {
			System.out.println("Closing Error");
		} catch(Exception ex) {
			System.out.println("UD Error: " + ex.getMessage());
		}
		
		console.close();
		
	}

}
