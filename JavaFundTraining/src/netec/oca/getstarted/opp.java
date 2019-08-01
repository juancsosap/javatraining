package netec.oca.getstarted;

public class opp {

	public static void main(String[] args) {
		
		Gente juan = new Gente("Juan", "Sosa");
		
		System.out.println(juan.nombreCompleto());
		
		Gente ana = new Gente("Ana", "Prada", false);
		
		juan.castigarse(ana);
		
		System.out.println(juan.nombreCompleto());
		System.out.println(ana.nombreCompleto());
		
		juan.crecer();
		
		System.out.println(juan.getEdad());
		
	}

}

class Gente {
	
	private String nombre;
	private String apellido;
	protected int edad = 0;
	private boolean esHombre;
	private boolean casado = false;
	
	public Gente(String nombre, String apellido, boolean esHombre) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.esHombre = esHombre;
	}
	public Gente(String nombre, String apellido) {
		this(nombre, apellido, true);
		System.out.println("Creando un Hombre");
	}
	/*public Gente() {
		this("", "", true);
	}*/
	
	public void crecer() {
		this.edad++;
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	public String nombreCompleto() {
		return this.nombre + " " + this.apellido;
	}
	
	public void castigarse(Gente pareja) {
		if(!this.esHombre) {
			this.apellido = pareja.apellido + " " + this.apellido;
		}
		this.casado = true;
		if(!pareja.esCasado()) pareja.castigarse(this);
	}
	
	public void liberarse() {
		this.casado = false;
	}
	
	public boolean esCasado() {
		return this.casado;
	}
	
}

class Padre extends Gente {
	
	private boolean feliz;

	public Padre(String nombre, String apellido) {
		super(nombre, apellido);
		this.setFeliz(true);
		this.edad = 20;
	}

	public boolean esFeliz() {
		return feliz;
	}

	public void setFeliz(boolean feliz) {
		this.feliz = feliz;
	}
	
}
