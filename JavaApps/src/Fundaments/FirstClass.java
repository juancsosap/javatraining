package Fundaments;

public class FirstClass {

	public static void main(String[] args) {
		
		Persona pepe1 = new Persona("Pepe");
		Persona pepe2 = new Persona("Pepe");
		Persona juan = new Persona("Juan");
		System.out.println(pepe1);
		System.out.println(pepe2);
		System.out.println(juan);
		System.out.println(pepe1.equals(pepe2));

	}

}

class Moneda {
	
	private static int cantidad = 0;
	
	public void ganar() {
		Moneda.cantidad++;
	}
	
	public void gastar() {
		Moneda.cantidad--;
	}
	
	public static int contar() {
		return Moneda.cantidad;
	}
	
	public static boolean estaLleno() {
		return Moneda.cantidad > 100;
	}
}



class Persona {
	
	private String nombre;
	private int id;
	
	private static int counter = 0;
	
	public Persona(String nombre) {
		counter++;
		this.setNombre(nombre);
		this.id = counter;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return "Persona: " + this.id + " : " + this.getNombre();
	}
	
	public boolean equals(Object otra) {
		return this.nombre.equals(((Persona) otra).getNombre()); 
	}
	
}