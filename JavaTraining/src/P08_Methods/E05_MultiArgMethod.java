package P08_Methods;

public class E05_MultiArgMethod {

	public static void main(String[] args) {
		printer(true, "First", "Second", "...", "...", "...", "...", "...", "...", "Nineth", "Tenth");
		
		System.out.println();
		
		String[] numStr = {"One", "Two", "...", "...", "...", "...", "...", "...", "Nine", "Ten"};
		printer(true, numStr);
		
		System.out.println();
		
		printer(true, 1, "Uno", 2.0, "Dos", '3', "Tres", true);
		
		System.out.println();
		
		int[] numInt = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		printer(true, numInt);
		
	}
	
	// The Variable Length Arguments are optional and must be at the end
	private static void printer(boolean index, String ...texts) {
		int i=1;
		for(String text : texts) {
			if(index) System.out.printf("%-2s ", i++);
			System.out.println(text);
		}
	}
	
	private static void printer(boolean index, Object ...objs) {
		int i=1;
		for(Object obj : objs) {
			if(index) System.out.printf("%-2s ", i++);
			System.out.println(obj);
		}
	}

}
