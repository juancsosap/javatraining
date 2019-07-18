package P01_Console;

public class E01_MyFirstMessage {

	public static void main(String[] args) {
		
		// Printing info in the console
		System.out.print("Saludos, Bienvenido a su primera aplicación. ");
		
		// Printing info in the console with implicit new line
		System.out.println("Espero que este experiencia de programación sea de su agrado.");
		
		// Printing info in the console with explicit new line
		System.out.print("Algunas consideraciones que deben tener en cuenta son:\n\n");
		
		// Printing info in the console with TAB
		System.out.println("\t■ 1. Practique todos los conocimiento adquiridos");
		System.out.println("\t" + '\u25A0' + " 2. Investigue en Internet y complemente su conocimiento");
		System.out.println("\t\u25A0 " + 3 + ". Tenga mente abierta para aprender conocimientos núevos\n");
				
		System.out.println("Y recuerde: "
				   + "\"Los grandes conocimientos engendran las grandes dudas.\" "
				   + "Aristóteles."); 
		
		System.out.println();
		System.out.println("Para mayor información puede referirse a la "
				   + "documentación oficial de Java en:\n"
				   + "\u25BA https://docs.oracle.com/javase/8/docs/api/");
		
		System.out.println("\nEl listado completo de los caractéres y codigos en UTF-8 están "
		           + "disponibles en el CharMap o vía el link:\n"
		           + "\u25BA http://www.fileformat.info/info/charset/UTF-8/list.htm");

		
	}

}
