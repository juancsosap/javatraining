package P17_Exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class E04_Resources {

	public static void main(String[] args) {
				
		try(Scanner console = new Scanner(System.in)){
		
			String strIn1 = console.nextLine();
			Integer intIn1 = Integer.parseInt(strIn1); 
			System.out.println(intIn1);
			
		} catch(NumberFormatException ex) {
			System.out.println("Invalid Input");
		} catch(RuntimeException ex) {
			System.out.println("RT Error: " + ex.getMessage());
		} catch(Exception ex) {
			System.out.println("UD Error: " + ex.getMessage());
		}
		
		System.out.println();
		
		try(InputStream file = new FileInputStream("myfile.txt")) {
			System.out.println("File Opened");
		} catch(FileNotFoundException ex) {
			System.out.println("File not Found");
		} catch(IOException ex) {
			System.out.println("Closing Error");
		} catch(Exception ex) {
			System.out.println("UD Error: " + ex.getMessage());
		}
		
		System.out.println();
		
		try(InputStream file = new FileInputStream("myfile.txt");
			Scanner console = new Scanner(System.in)){
			
			System.out.println("File Opened");
				
			String strIn1 = console.nextLine();
			Integer intIn1 = Integer.parseInt(strIn1); 
			System.out.println(intIn1);
			
		} catch(NumberFormatException ex) {
			System.out.println("Invalid Input");
		} catch(RuntimeException ex) {
			System.out.println("RT Error: " + ex.getMessage());
		} catch(FileNotFoundException ex) {
			System.out.println("File not Found");
		} catch(IOException ex) {
			System.out.println("Closing Error");
		} catch(Exception ex) {
			System.out.println("UD Error: " + ex.getMessage());
		}
		
		System.out.println();
		
		try(Printer p = new Printer()){
			p.print("Message");
		} catch (Exception e) {
			System.out.println("Printing Error");
		}
		
	}
	
	private static class Printer implements AutoCloseable {

		public Printer() {
			System.out.println("Turnning On the Printer");
		}
		
		public void print(String msg) {
			System.out.println("Printing: " + msg);
		}
		
		@Override
		public void close() throws Exception {
			System.out.println("Turnning Off the Printer");
		}
		
	}

}
