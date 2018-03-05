package P08_Methods;

public class E02_DefaultValues {

	public static void main(String[] args) {
		printData("Juan", "Sosa", "12.234.567-8", 35, true);
		printData("Juan", "Sosa", "12.234.567-8", 35);
		printData("Juan", "Sosa", "12.234.567-8");
		printData("Juan", "Sosa");
		printData("Juan");
		printData();
	}
	
	private static void printData(String name, String surname, String rut, int age, boolean authorized) {
		System.out.println("-----------------------------------");
		if(!name.isEmpty()) System.out.println("Nombre: " + name);
		if(!surname.isEmpty()) System.out.println("Apellido: " + surname);
		if(!rut.isEmpty()) System.out.println("RUT: " + rut);
		if(age > 0) System.out.println("Edad: " + age);
		
		if(authorized) System.out.println("ACCESO AUTORIZADO");
		else System.out.println("ACCESO RESTRINGIDO");
		
		System.out.println("-----------------------------------\n");
	}
	private static void printData(String name, String surname, String rut, int age) { printData(name, surname, rut, age, false); }
	private static void printData(String name, String surname, String rut) { printData(name, surname, rut, 0, false); }
	private static void printData(String name, String surname) { printData(name, surname, "", 0, false); }
	private static void printData(String name) { printData(name, "", "", 0, false); }
	private static void printData() { printData("", "", "", 0, false); }

}
