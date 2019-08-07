package P12_Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class E01_CollectionsClass {

	public static void main(String[] args) {
		
		// The same methods apply for List, Set, Queue and Maps
		
		// Creating an unmodifiable empty list
		List<String> list1 = Collections.emptyList();
		// list1.add("All");
		list1.forEach(System.out::print);
		
		// Creating an unmodifiable list
		List<String> list2 = List.of("Hello", "World");
		System.out.println(list2.getClass().getName());
		// list2.add("All");
		list2.forEach(System.out::print);
		
		System.out.println();
		
		List<String> list3 = Collections.nCopies(5, "Hello");
		// list3.add("All");
		list3.forEach(System.out::print);
		
		System.out.println();
		
		List<Integer> list4 = Arrays.asList(3,5,8,2,5,9,1);
		System.out.println(list4.getClass().getName());
		// list4.add(4);
		list4.forEach(System.out::print);
		
		System.out.println();
		
		// Mutable List
		List<Integer> list51 = new ArrayList<>();
		System.out.println(list51.getClass().getName());
		list51.add(4);
		list51.forEach(System.out::print);
		
		System.out.println();
		
		List<Integer> list52 = Collections.unmodifiableList(list51);
		System.out.println(list52.getClass().getName());
		// list52.add(4);
		list52.forEach(System.out::print);
		
		// Methods available in the class collections
		System.out.print("\nOriginal: ");
		list4.forEach(System.out::print);
		
		Collections.reverse(list4);
		// Collections.reverse(list2); // --> throw and Exception because it's immutable
		System.out.print("\nReversed: ");
		list4.forEach(System.out::print);
		
		System.out.print("\nMax     : " + Collections.max(list4));
		System.out.print("\nMin     : " + Collections.min(list4));
		
		System.out.println();
		
		// Final Collection
		final List<Integer> list6 = new ArrayList<>(list4);
		list6.add(8);
		list6.forEach(System.out::print);
		// list6 = list4; // Not valid final variable
	}

}
