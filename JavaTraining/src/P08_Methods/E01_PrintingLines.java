package P08_Methods;

public class E01_PrintingLines {

	public static void main(String[] args) {
		printFullLine();
		System.out.println(" Listados de Ciudades y Paices");
		printFullLine();
		
		String[] cities = { "Santiago", "Lima", "Bogota", "Caracas", "Brazilia", "Buenos Aires" };
		printTable("Ciudades", cities);
		
		String[] countries = { "Chile", "Perú", "Colombia", "Venezuela", "Brazil", "Argentina" };
		printTable("Paices", countries);
		
		printFullLine();
	}
	
	// Method without arguments
	private static void printFullLine() {
		printLine(40);
	}
	
	// Overloading Method
	private static void printLine(int length) {
		String line = "";
		for(int i = 0; i < length; i++)
			line += "-";
		System.out.println(line);
	}
	
	private static void printItem(String item) {
		System.out.println(" > " + item);
	}
	
	private static void printItems(String[] items) {
		for(String item : items)
			printItem(item);
	}
	
	private static void printTable(String title, String[] data) {
		printLine(20);
		System.out.println("   " + title);
		printLine(20);
		printItems(data);
		printLine(20);
	}
	
}
