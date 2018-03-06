package P03_Strings;

public class E04_ComparingStrings {

	public static void main(String[] args) {
		
		String text1 = "TEXT";
		String text2 = new String(text1);
		String text3 = text1;
		
		System.out.println("Comparando Cadenas de Caracteres\n");
		
		System.out.println("Las Cadenas de Caracteres clonadas generan la misma Cadena: " + (text1 == text2) );
		System.out.println("Las Cadenas de Caracteres clonadas tienen los mismos valores: " + (text1.equals(text2)) );
		
		System.out.println("Las Cadenas de Caracteres copiadas son la misma Cadena: " + (text1 == text3) );
		
		// Testing the list mutability
		int hashCodeBegin = text1.hashCode();
		text1 += "TEXT";
		int hashCodeEnd = text1.hashCode();
		
		System.out.println("Las Cadenas de Caracteres son mutables: " + (hashCodeBegin == hashCodeEnd) );
		
		System.out.println("Las Cadenas de Caracteres clonadas son afectadas cuando se modifica la original: " + (text1.equals(text2)) );
		
		System.out.println("Las Cadenas de Caracteres copiadas son afectadas cuando se modifica la original: " + (text1.equals(text3)) );
		
	}

}
