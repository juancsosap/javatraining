package netec.ocp.advanced;

public class Test101 extends Cosa {

	public static void main(String[] args) {
		new Cosa().print();
		System.out.println(cosa);
		// cosa = "chao";
	}

}

class Cosa implements Cosable {
	
	static String cosa = "chao";
	
	public void print() {
		System.out.println(cosa);
	}
	
}

interface Cosable {
	
	String cosa = "Thing";
	
}