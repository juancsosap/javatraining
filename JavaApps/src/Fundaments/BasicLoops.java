package Fundaments;

import java.util.Scanner;

public class BasicLoops {

	public static void main(String[] args) {
		int[] num = {0,1,2,3,4,5,6,7,8,9};
		int a = -10;
		
		//              0123456789
		String email = "user.nuage@gmail.com";
		
		int cantidad = 0;
		int i = 0;
		do {
			if(email.charAt(i) == '@') { cantidad++; } 
			i++;
		} while(cantidad < 2 && i < email.length());
		System.out.println("Email " + ((cantidad == 1) ? "Correcto" : "Incorrecto"));
		
		int q = 0;
		for(int j = 0; q < 2 && j < email.length(); j++) {
			if(email.charAt(j) == '@') { q++; }
		}
		System.out.println("Email " + ((q == 1) ? "Correcto" : "Incorrecto"));
		/*
		for(;condicion;) {
			
		}
		
		
		
		inicio
		while(condicion){
		    instrucciones....
		    ...
		    final
		}
	
		for(inicio;condicion;final) {
			instrucciones;
		}
		*/
		
		
		
		
		
		
		
		
		
		while(true) {
			System.out.println("Hola");
			a--;
			if(a>0) { break; }
			if(a>5) { continue; }
			System.out.println("Hola");
		}
		
		do {
			System.out.println("Hola");
			a--;
		} while(a>0);
		
		
		int[] array = {0,1,2,3,4,5,6,7,8,9};
		for(int k=0; i<array.length; k++) {
			System.out.println(array[k]);
		}
		
		int w=0;
		while(w<array.length) {
			System.out.println(array[w]);
			w++;
		} 		
		
		for(int val : array) {
			System.out.println(val);
		}
		
		for(int ii=0; i<num.length; ii++) {
			System.out.println(num[ii]);
		}
		for(int v : num) {
			System.out.println(v);
		}
		int iii=0;
		while(iii<num.length) {
			System.out.println(num[iii]);
			i++;
		}
		i=0;
		do {
			System.out.println(num[i]);
			i++;
		} while(i<num.length);
		
		
		
		Scanner console = new Scanner(System.in);
		/*int numero;
		do {
			System.out.println("Dame un número entre 1 y 10");
			numero = console.nextInt();
		} while(!(numero > 0 && numero < 11));
		System.out.println("El número es: " + numero);
		
		while(!(numero > 0 && numero < 11)) {
			System.out.println("Dame un número entre 1 y 10");
			numero = console.nextInt();
		} 
		*/
		int numero=0;
		for(; !(numero > 0 && numero < 11); ) {
			System.out.println("Dame un número entre 1 y 10");
			numero = console.nextInt();
		}
		System.out.println("El número es: " + numero);
		
		console.close();
	}

}
