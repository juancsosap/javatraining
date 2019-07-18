package netec.oca.getstarted;

public class POO {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		System.out.println(Persona.getCounter());
		
		Persona juan = new Persona("Juan Carlos");
		Persona pepe = new Persona(new String("Pepe"));
		
		Persona carlos = juan.clone();
		
		juan.name = "Jhon";
		
		juan.id = -300;
		
		Persona jhon = new Persona(juan);
		
		System.out.println(juan.equals(pepe));
		
		System.out.println(juan);
		System.out.println(pepe);
		System.out.println(carlos);
		
		System.out.println(juan.hashCode());
		
		System.out.println(Persona.getCounter());
		
		// Persona.last_id = 100;
		
		Persona maria = new Persona("Maria");
		
		System.out.println(maria);
		
	}

}

class Persona {
	private static int last_id = 0;
	
	int id;
	String name;
	public Persona(String name) {
		this.name = name;
		this.id = ++Persona.last_id;
	}
	public Persona() {
		this.name = "";
	}
	public Persona(Persona per) {
		this.name = per.name;
	}
	
	public static int getCounter() {
		return Persona.last_id;
	}
	
	@Override
	public boolean equals(Object otro) {
		Persona otra_persona = (Persona) otro;
		return this.name.equals(otra_persona.name);
	}

	public boolean equals(Persona otro) {
		return this.name.equals(otro.name);
	}

	@Override
	public String toString() {
		return this.id + " : " + this.name;
	}
	
	public Persona clone() {
		return new Persona(this.name);
	}
	
}