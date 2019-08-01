package netec.oca.getstarted;

import java.math.BigInteger;

public class DataTypes {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		// 1Byte
		byte num1 = -128;
		byte num2 = 127;
		byte num3 = Byte.MIN_VALUE;
		
		Byte numA = 100;
		
		// 2Bytes
		short num4 = -32767;
		short num5 = Short.MAX_VALUE;
		
		// 4Bytes
		int num6 = Integer.MIN_VALUE;
		int newnum = Integer.parseInt("100");
		
		// 8Bytes
		long num7 = Long.MAX_VALUE;
		long num8 = 10000000000L;
		long lnum = Integer.MAX_VALUE + 10;
		int inum = 100;
		
		int iinum = (int) lnum;
		long llnum = inum;
		
		System.out.println(iinum);
		
		BigInteger num9 = new BigInteger("10000000000000000000000000000000000000000000000000000000000000");
		
		float num10 = 100000000000000000000000.0F;
		float num11 = 1.0E-32F;
		float num12 = 1.0000001F;
		System.out.println(num12);
		
		double num13 = 1.00000000000001;
		System.out.println(num13);
		
		boolean status1 = true;
		boolean status2 = Boolean.TRUE;
		
		char character1 = '1';
		byte character2 = '2';
		char character3 = 50;
		System.out.println(character3);
		
		String texto1 = "rdtfyhjiokl�";
		
		int numero1 = 5;
		int numero2 = 10;
		int numero3 = 15;
		int numero4 = 20;
		int numero5 = 25;
		
		
		int size = 5;
		
		int[] numero = new int[size];
		
		numero[0] = 5;
		numero[1] = 10;
		numero[2] = 15;
		numero[3] = 20;
		numero[4] = 25;
		
		int Numero[] = {5, 10, 15, 20, 25};
		
		int mynum = Numero[3];
		
		
		int NUMERO[] = new int[] {5, 10, 15, 20, 25};
		
		String[] palabras = {"Hola", "Chao"};
		
		Object[] persona = {"Juan", "Sosa", "35"};
		
		String nombre = (String) persona[0];
		String apellido = (String) persona[1];
		int edad = Integer.parseInt((String) persona[2]);
		
	}

}
