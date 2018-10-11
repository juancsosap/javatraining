package P13_Cursors;

import java.util.Enumeration;
import java.util.Vector;

public class E01_Enumeration {

	public static void main(String[] args) {
		
		Vector<Integer> v1 = new Vector<>();
		
		for(int i=0; i<10; i++) {
			v1.addElement(i);
		}
		
		System.out.println(v1);
		
		Enumeration<Integer> e1 = v1.elements();
		
		while(e1.hasMoreElements()) {
			Integer val = e1.nextElement();
			if(val % 2 == 0)
				System.out.print(val + "  ");
		}
		System.out.println();
		
		System.out.println(v1);
		
		System.out.println(e1.getClass());
		
	}

}
