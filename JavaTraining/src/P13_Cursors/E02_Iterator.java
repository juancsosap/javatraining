package P13_Cursors;

import java.util.ArrayList;
import java.util.Iterator;

public class E02_Iterator {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		ArrayList<Integer> a1 = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			a1.add(i);
		}
		
		ArrayList<Integer> a2 = (ArrayList<Integer>) a1.clone();
		
		System.out.println(a1);
		
		Iterator<Integer> i1 = a1.iterator();
		
		while(i1.hasNext()) {
			Integer val = i1.next();
			if(val % 2 == 0)
				System.out.print(val + "  ");
		}
		System.out.println();
		
		System.out.println(a1);
		
		System.out.println();
		
		System.out.println(a2);
		
		Iterator<Integer> i2 = a2.iterator();
		
		while(i2.hasNext()) {
			Integer val = i2.next();
			if(val % 2 == 0)
				System.out.print(val + "  ");
			else
				i2.remove();
		}
		System.out.println();
		
		System.out.println(a2);
		
		System.out.println(i1.getClass());
		
	}

}