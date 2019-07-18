package netec.oca.getstarted;

public class Errores {

	public static void main(String[] args) {
		System.out.println(dividirTry(10, 3));
		System.out.println(dividirIf(10, 0));
		System.out.println(isIntegerFailed("ertyuj"));
	}
	
	public static int dividirTry(int x, int y) {
		try {
			return x/y;
		} catch(Exception ex) {
			return 100;
		}
	}
	
	public static int dividirIf(int x, int y) throws IllegalArgumentException {
		if(y != 0)
			return x/y;
		else
			throw new IllegalArgumentException("Y no puede ser 0"); 
	}
	
	public static int dividir(int x, int y) {
		try {
			return x/y;
		} catch(Exception ex) {
			return 100;
		}
	}
	
	public static boolean isInteger(String x) {
		try {
			Integer.parseInt(x);
			return true;
		} catch(Exception ex) {
			return false;
		} finally {
			System.err.println("Tested");
		}
	}
	
	public static boolean isIntegerFailed(String x) throws IllegalArgumentException {
		Integer.parseInt(x);
		return true;
	}

}
