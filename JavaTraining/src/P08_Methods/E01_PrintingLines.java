package P08_Methods;

public class E01_PrintingLines {

	public static void main(String[] args) {
		printFullLine();
		System.out.println(" Listados de Ciudades y Paices");
		printFullLine();
		
		String[] cities = { "Santiago", "Lima", "Bogota", "Caracas", "Brazilia", "Buenos Aires" };
		printColumn("Ciudades", cities);
		
		String[] countries = { "Chile", "Perú", "Colombia", "Venezuela", "Brazil", "Argentina" };
		printColumn("Paices", countries);
		
		printFullLine();
		
		String[][] capitals = { {"Chile", "Santiago"},    {"Perú", "Lima"},       {"Bogota", "Colombia"}, 
				                {"Venezuela", "Caracas"}, {"Brazil", "Brazilia"}, {"Argentina", "Buenos Aires" } };
		printTable("Capitales", new String[] {"Country", "City"}, capitals);
		
		printFullLine();
	}
	
	// Method without arguments
	private static void printFullLine() {
		printLine(40);
	}
	
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
	
	private static void printColumn(String title, String[] data) {
		printLine(20);
		System.out.println("   " + title);
		printLine(20);
		printItems(data);
		printLine(20);
	}
	
	private static void printData(String[][] data) {
		for(String[] value : data)
			printRow(value);
	}
	
	private static void printRow(String[] data) {
		for(String value : data)
			System.out.printf(" %-15s", value);
		System.out.println();
	}
	
	private static void printTable(String title, String[] fields, String[][] data) {
		printLine(30);
		System.out.println(" " + title);
		printLine(30);
		printRow(fields);
		printLine(30);
		printData(data);
		printLine(30);
	}
	
}
