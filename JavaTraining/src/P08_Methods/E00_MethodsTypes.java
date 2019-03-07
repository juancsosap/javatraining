package P08_Methods;

public class E00_MethodsTypes {

	public static void main(String[] args) {
		
		printLine();
		
		printEmptyBox();
		printEmptyBox();
		
		printLine();
		
		printFullBox('A');
		printFullBox('B');
		
		printLine();
		
		System.out.println(getBox(5));
		
	}
	
	// Not input argument and no return value (void) 
	private static void printLine() {
		System.out.println("\n---------------------------\n");
	}
	
	// Input argument and no return value (void) 
	private static void printFullBox(char content) {
		System.out.println(" ------- ");
		System.out.println("|       |");
		System.out.println("|   " + content + "   |");
		System.out.println("|       |");
		System.out.println(" ------- ");
	}
	
	// Method calling another methods 
	private static void printEmptyBox() {
		printFullBox(' ');
	}
	
	// Not input argument and one return value (String) 
	private static String getLine() {
		return " ------- ";
	}
	
	// One input argument and one return value (char) 
	private static String getBox(int size) {
		String result = "";
		for(int i=0; i<size; i++) {
			result += getLine() + "\n";
		}
		return result;
	}

}
