package Fundaments;

import java.util.ArrayList;

public class BasicVariables {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		byte edad = 100; // 1Byte
		short distancia = 32760; // 2Bytes
		int numero = 60000; // 4Bytes
		long celulas = 1234567890; // 8Bytes
		
		float altura = 72.5F;
		double pi = 3.1415;
		
		boolean estado = true;
		
		char caracter = 't';
		
		String cadena = "Mi cadena";
		
		Integer num1 = new Integer(100);
		
		int result = edad + distancia + numero;
		
		String resultStr = result + "";
		String resultStr2 = String.valueOf(result);
		
		String number123 = "123";
		int numberInt = Integer.valueOf(number123);
		
		int result2 = distancia / edad;
		double result3 = (double) distancia / (double) edad;
		
		System.out.println(result2 + " " + result3);
		
		String nombreDeLaCasa = "Mi Casita";
		System.out.println(nombreDeLaCasa.length());
		
		String nombre_de_la_casa;
		nombre_de_la_casa = "Mi Casita"; 
		
		final String COLOR_DE_CASA = "Azul";
		
		final String COLOR_DEL_MUEBLE;
		COLOR_DEL_MUEBLE = "Azul";
		
		                 //0    1    2    3
		double[] notas = {3.4, 5.5, 7.0, 6.3};
		
		notas[2] = 6.5;
		
		System.out.println(notas[2] + " " + notas.length);
		
		int[] edades = new int[5]; 
		
		edades[0] = 10;
		edades[1] = 11;
		edades[2] = 12;
		edades[3] = 13;
		edades[4] = 14;
		
		System.out.println(edades[3]);
		
		ArrayList<String> invitados = new ArrayList<String>();
		
		invitados.add("Luis");
		invitados.add("Pepe");
		invitados.add("Juan");
		invitados.add("Maria");
		
		System.out.println(invitados.get(2) + Math.random());
		
		Object[] lista = {"Juan", "Sosa", 35, 5.5, true};
		System.out.println(((String) lista[0]).length());
		
	}

}
