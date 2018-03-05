package Fundaments;

import java.util.Scanner;

import javax.swing.JOptionPane;

@SuppressWarnings("all")
public class Operators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a0 = 1;
		int a1 = 2;
		int a2 = 3;
		int a3 = 4;
		
		String a = "";
		
		a += a3;
		a += a2;
		a += a1;
		a += a0;
		
		// Constant of Base
		final int md = 16;
		
		System.out.println("Número en base " + md + ": " + a);
		
		int b = 0;
		
		b += a3; 
		b *= md;
		b += a2; 
		b *= md;
		b += a1; 
		b *= md;
		b += a0;
		
		System.out.println("Número en base 10: " + b);
		
		int m = b;
		
		int n0 = m % md;
		m /= md;

		int n1 = m % md;
		m /= md;

		int n2 = m % md;
		m /= md;

		int n3 = m % md;
		m /= md;

		System.out.println(""+n3+n2+n1+n0);
		
		// Refundición  
		int sqrt = (int) Math.round( Math.sqrt(b) );
		
		System.out.println("SQRT del Número: " + sqrt);
		
		int pow = (int) Math.pow( (double) sqrt, 2);
		
		
		System.out.println("Aprox. Número Original: " + pow);
		
		String email = "correo@dominio.com";
		char at = email.charAt(6);
		int longitud = email.length();
		int atIndex = email.indexOf('@');
		String nick = email.substring(0, atIndex);
		String dominio1 = email.substring(atIndex+1);
		String dominio2 = email.substring(atIndex+1,longitud);
		boolean igual = dominio1.equals(dominio2);
		
		System.out.println("Email: "+nick + at + dominio2);
		
		System.out.printf("%1.2f", Math.sqrt(5));
		System.out.println("");
		
		Scanner console = new Scanner(System.in);
		
		System.out.print("Nombre: ");
		String nombre =console.nextLine();
		
		System.out.print("Apellido: ");
		String apellido =console.nextLine();
		
		System.out.println("Gracias " + nombre + " " + apellido);
		
		int edad = Integer.parseInt(JOptionPane.showInputDialog("Ups, necesito tu edad tambien..."));
		
		System.out.print(nombre + " " + apellido + ", tienes " + edad + " años. ");
		
		if(edad < 18) {
			System.out.println("Eres menor de edad.");
		} else if(edad > 100) {
			System.out.println("Y aun estas vivo!!!!.");
		} else {
			System.out.println("Eres mayor de edad.");
		}
		 
	}

}
