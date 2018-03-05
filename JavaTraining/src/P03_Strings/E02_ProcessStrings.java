package P03_Strings;

public class E02_ProcessStrings {

	public static void main(String[] args) {
		
		String msg = "Don Quijote de la Mancha ​ es una novela escrita por el español Miguel \n"
				   + "de Cervantes Saavedra. Publicada su primera parte con el título de El \n"
				   + "ingenioso hidalgo don Quijote de la Mancha a comienzos de 1605, es la \n"
				   + "obra más destacada de la literatura española y una de las principales \n"
				   + "de la literatura universal.";
		
		System.out.println(msg);
		
		System.out.println();
		
		System.out.println("Caracteres      : " + msg.length());
		System.out.println("Palabras        : " + msg.split(" ").length);
		System.out.println("Titulo          : " + "Don Quijote".toUpperCase());
		System.out.println("Estilo          : " + "Novela".toLowerCase());
		System.out.println("Año en Texto    : Caracter Nro " + msg.indexOf("1605"));
		System.out.println("Lugar           : " + msg.substring(18, 24));
		System.out.println("Primer Caracter : " + msg.charAt(0) + "(" + msg.codePointAt(0) + ")");
		
		System.out.println();
		
		String author1 = "      Miguel de Cervantes Saavedra     ";
		System.out.printf("(%d) %s%n", author1.length(), author1);
		
		String author2 = author1.trim();
		System.out.printf("(%d) %s%n", author2.length(), author2);
		
		System.out.println();
		
		String author3 = author2.toLowerCase();
		
		System.out.println("Iguales      : " + author2.equals(author3));
		System.out.println("Casi Iguales : " + author2.equalsIgnoreCase(author3));
		
	}

}
