package P19_Annotations;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class E01_InternalAnnotations {

	public static void main(String[] args) {
		
		@SuppressWarnings("rawtypes")
		List lista = new ArrayList();
		
	}
	
	private class Printer {
		@Deprecated
		public void print(String msg) {
			System.out.print(msg + "\n");
		}
	}
	
	private class NewPrinter extends Printer {
		@Override
		public void print(String msg) {
			System.out.println(msg);
		}
	}
	
	@FunctionalInterface
	private interface Printable {
		public void print(String msg);
	}

}
