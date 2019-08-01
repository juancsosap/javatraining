package netec.oca.getstarted;

public class Program {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		System.out.println("Hello World");
		
		PersonaNew p1 = new PersonaNew();
		
		p1.nombre = "Ju";
		
		p1.nombre = p1.nombre + "an";
		
		PersonaNew p2 = new PersonaNew();
		
		p2.nombre = "Juan";
		
		System.out.println(p1.nombre.equals(p2.nombre));
		
		byte l = (byte) p1.nombre.length();
		
		p1.nombre.equals(p2.nombre);
		
		// p1.nombre == p2.nombre;
		
		p1.nombre.equalsIgnoreCase(p2.nombre);
		
		p1.nombre.substring(1, 3);
		
		int c = p1.nombre.charAt(2);
		
		System.out.println(c);
		
		p1.nombre.compareTo(p2.nombre);
		
		p1.nombre.indexOf('a');
		
		p1.nombre.lastIndexOf('a');
		
		p1.nombre.isEmpty();
		
		p1.nombre.toLowerCase();
		
		p1.nombre.toUpperCase();
		
		String.valueOf(true);
		
	}

}

class PersonaNew {
	
	String nombre;
	
}



