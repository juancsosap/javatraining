package Fundaments;

import java.util.Scanner;

public class ControlStatements {

	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		
		System.out.println("Escribe tu nombre:");
		String nombre = console.nextLine();
		
		System.out.println("Escribe tu genero (M/F):");
		String genero = console.nextLine();
		if(genero.isEmpty()) {
			System.out.println("Favor Escribe tu genero (M/F):");
			genero = console.nextLine();
		}
		System.out.println("Escribe tu edad:");
		
		int edad = -1;
		
		try {
			edad = console.nextInt();
		} catch(Exception e) {
			System.out.println("Valor no valido, la edad debe ser un entero");
		}
		
		String tipo;
		
		// < > <= >= == !=
		// && || !
		
		if(edad == -1) {
			System.out.println("No se dispone de suficiente información");
		} else {
			if(edad == 0) { tipo = "recien nacido"; }
			else if(edad < 2) { tipo = "bebe"; } 
			else if(edad < 10) { tipo = "niño"; } 
			else if(edad < 18) { tipo = "adolecente";} 
			else if(edad < 40) { tipo = "adulto"; } 
			else { tipo = "adulto mayor"; }
			
			if(genero.equals("F")) {
				if(edad > 45) {
					System.out.println("Ve ha hacerte un control de cancer de ceno");
				} else {
					System.out.println("Estas joven");
				}
			} else if(genero.equals("M") && edad > 40) {
				System.out.println("te va a doler");
			} else if(genero.equals("M") && !(edad > 40)) {
				System.out.println("te salvaste");
			}
			
			/* if(genero.equals("M")) {
			      if(edad > 40) {
				         System.out.println("te va a doler");
			      } else {
				         System.out.println("te salvaste");
			      }
			 */
			
			System.out.println("Eres un " + tipo);
			
			System.out.println("Hola " + nombre + ", tienes " + edad + " años.");			
		}
		
		
		console.close();		

	}

}







