package P08_Methods;

public class E05_MultiArgMethod {

	public static void main(String ... args) {
		printer(false, "First", "Second", "...", "...", "...", "...", "...", "...", "Nineth", "Tenth");
		
		System.out.println();
		
		String[] numStr = {"One", "Two", "...", "...", "...", "...", "...", "...", "Nine", "Ten"};
		printer(true, numStr);
		
		System.out.println();
		
		printer(true, 1, "Uno", 2.0, "Dos", '3', "Tres", true);
		
		System.out.println();
		
		int[] numInt = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		printer(true, numInt, "Otro Object");

		System.out.println();

		printer(true);
	}
	
	// The Variable Length Arguments are optional and must be at the end
	private static void printer(boolean index, String ... texts) {
		System.out.println("String Printer");
		int i=1;
		for(String text : texts) {
			if(index) System.out.printf("%-2s ", i++);
			System.out.println(text);
		}
	}
	
	private static void printer(boolean index, Object ... objs) {
		System.out.println("Object Printer");
		int i=1;
		for(Object obj : objs) {
			if(index) System.out.printf("%-2s ", i++);
			System.out.println(obj);
		}
	}

}
