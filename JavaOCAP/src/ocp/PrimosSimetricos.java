package ocp;

public class PrimosSimetricos {

	public static void main(String[] args) {
		buscarPrimos(100);
	}
	
	public static void buscarPrimos(int max) {
		for(int i = 0; i < max; i++) {
			int num = i+1;
			if(esPrimo(num)) {
				System.out.println(num + " es primo.");
			}
		}
	}
	
	public static boolean esPrimo(int num) {
		if(num < 2) return false;
		for(int i = 2; i < num; i++) {
			if(num % i == 0) return false;
		}
		return true;
	}

}
