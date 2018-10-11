package Introduction;

public class C01 {
	
	String titulo;

	public static void main(String[] args) {
		
		Persona.cantidad = 0;
		
		Persona p1 = new Persona();
		p1.nombre = "Juan";
		p1.apellido = "Sosa";
		
		Persona.cantidad += 1;
		
		Persona p2 = new Persona();
		p2.nombre = "Ana";
		p2.apellido = "Prada";
		
		Persona.cantidad += 1;
		
		System.out.println(Persona.cantidad);
		System.out.println(p2.nombreCompleto());
		
		C01 obj = new C01();
		obj.titulo = "Introducción a Java";
		
		System.out.println(Persona.obtenerCantidad());
		
	}
	
	
	static class Persona {
		String nombre;
		String apellido;
		static int cantidad;
		
		String nombreCompleto() {
			return nombre + " " + apellido;
		}
		
		static String obtenerCantidad() {
			return "Hay " + cantidad + " personas";
		}
		
	}
	
	
}
