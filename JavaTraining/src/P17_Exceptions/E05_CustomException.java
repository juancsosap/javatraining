package P17_Exceptions;

public class E05_CustomException {

	public static void main(String[] args) throws PrintingException {
				
		try(Printer p = new Printer()){
			p.print("Message");
		} catch (Exception e) {
			throw new PrintingException("Printing Error");
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
	
	@SuppressWarnings("serial")
	private static class PrintingException extends Exception { 
		
		public PrintingException(String message) {
			super(message);
		}
		
	}

}
