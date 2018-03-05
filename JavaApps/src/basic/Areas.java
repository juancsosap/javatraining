package basic;

import java.util.*;


public class Areas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner console = new Scanner(System.in);
		
		System.out.println("Elige una figura geometrica:\n");
		System.out.println("1. Cuadrado");
		System.out.println("2. Rectangulo");
		System.out.println("3. Triangulo");
		System.out.println("4. Circulo\n");
		
		boolean isReady = false;
		while(!isReady) {
			System.out.print("Opción: ");
			int figura = console.nextInt();
			isReady = true;
			
			switch (figura) {
				case 1: //Cuadrado
					System.out.print("Lado: ");
					double lado = console.nextDouble();
					double area = Math.pow(lado, 2);
					System.out.print("El área del Cuadrado es ");
					System.out.printf("%1.4f",area);
					System.out.println("");
					break;
				case 2: // Rectangulo
					System.out.print("Base: ");
					double base = console.nextDouble();
					System.out.print("Altura: ");
					double altura = console.nextDouble();
					area = base * altura;
					System.out.print("El área del Rectangulo es ");
					System.out.printf("%1.4f",area);
					System.out.println("");
					break;
				case 3: // Triangulo
					System.out.print("Base: ");
					base = console.nextDouble();
					System.out.print("Altura: ");
					altura = console.nextDouble();
					area = base * altura / 2;
					System.out.print("El área del Triangulo es ");
					System.out.printf("%1.4f",area);
					System.out.println("");
					break;
				case 4: // Circulo
					System.out.print("Radio: ");
					double radio = console.nextDouble();
					area = Math.PI * Math.pow(radio, 2);
					System.out.print("El área del Circulo es ");
					System.out.printf("%1.4f",area);
					System.out.println("");
					break;
				default:
					isReady = false;
					System.out.println("Opción no valida. Intentelo nuevamente.");
					break;
			}
		}
	
		console.close();
	}

}
