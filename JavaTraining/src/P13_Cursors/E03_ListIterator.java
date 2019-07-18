package P13_Cursors;

import java.util.ArrayList;
import java.util.ListIterator;

public class E03_ListIterator {

	public static void main(String[] args) {
		
		ArrayList<Integer> a1 = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			a1.add(i);
		}
				
		System.out.println(a1);
		
		ListIterator<Integer> i1 = a1.listIterator();
		
		while(i1.hasNext()) {
			Integer index = i1.nextIndex();
			Integer val = i1.next();
			if(val % 2 == 0) {
				System.out.println(index + ": " + val);
				i1.set(val*val);
			} else {
				i1.add(val + 1);
			}
		}
		
		System.out.println(a1);
		
		while(i1.hasPrevious()) {
			Integer index = i1.previousIndex();
			Integer val = i1.previous();
			if(val % 3 == 0)
				System.out.println(index + ": " + val);
			else
				i1.remove();
		}
		
		System.out.println(a1);
		
		System.out.println(i1.getClass());
		
	}

}