package netec.oca.getstarted;

public class ControlBlocks {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		boolean married = true;
		if(married) {
			System.out.println("Castigado");
		}
		
		int a;
		int x = 1;
		int y = 1;
		if(x == y) {
			a = 1;
		} else {
			a = 2;
		}
		System.out.println(a);
		
		int edad = 70;
		
		if(edad < 10) {
			System.out.println("Niño");
		} else {
			if(edad < 18) {
				System.out.println("Adolecente");
			} else {
				System.out.println("Adulto");
			}
		}
		
		System.out.println(edad < 10 ? "Niño" : edad < 18 ? "Adolecente" : "Adulto");
		
		if(edad < 10) {
			System.out.println("Niño");
		} else if(edad < 18) {
			System.out.println("Adolecente");
		} else if(edad < 60) {
			System.out.println("Adulto");
		} else if(edad < 80) {
			System.out.println("Adulto Mayor");
		} else {
			System.out.println("Abuelo");
		}
		
		System.out.println(edad < 10 ? "Niño" : 
			               edad < 18 ? "Adolecente" : 
			               edad < 60 ? "Adulto" : 
			               edad < 80 ? "Adulto Mayor" : 
			            	           "Abuelo");
		
		double altura = 1;
		if(altura > 1 && altura< 1.5) {
			System.out.println("Pasa");
		} else {
			System.out.println("No Pasa");
		}
		
		if(!married) {
			System.out.println("Happy");
		}
		
		if(altura > 1 && (altura< 1.5 || married)) {
			System.out.println("Con dinero");
		}
		
		String valor = "4";
		switch(valor) {
			case "1":
				System.out.println("UNO");
				break;
			case "2":
				System.out.println("DOS");
				break;
			case "3":
				System.out.println("TRES");
				break;
			default:
				System.out.println("OTRO");
		}

		String letra = "A";
		switch(letra) {
			case "A":
		    case "E":
		    case "I":
		    case "O":
		    case "U":
				System.out.println("VOCAL");
				break;
		    case "Ñ":
		    	System.out.println("ESPAÑOL");
			default:
				System.out.println("CONSONANTE");
		}
		
		if(letra == "A" || letra == "B" || letra == "C") {
			System.out.println("ABC");
		} else if(letra == "D") {
			System.out.println("D");
		} else {
			System.out.println("EFG....");
		}

		String A;
		int GENERO = 0;
		switch(GENERO) {
			case 0:
				A = "HOMBRE";
				break;
			case 1:
				A = "MUJER";
				break;
			default:
				A = "?????";
		}
		System.out.println(A);
		
		String B;
		Genero genero = Genero.HOMBRE;
		switch(genero) {
			case HOMBRE:
				B = "HOMBRE";
				break;
			case MUJER:
				B = "MUJER";
				break;
			default:
				B = "?????";
		}
		System.out.println(B);
		
		System.out.println(Genero.MUJER);
		
		boolean open = true;
		if(open) {
			System.out.println("OPEN");
		} else {
			System.out.println("CLOSE");
		}
		
		System.out.println(open ? "OPEN" : "CLOSE");
		
		int edades = 10;
		boolean mayor;
		if(edades < 18) {
			mayor = false;
		} else {
			mayor = true;
		}
		
		mayor = !(edades < 18);
		
		
	}

}

enum Genero { HOMBRE, MUJER, OTRO }
