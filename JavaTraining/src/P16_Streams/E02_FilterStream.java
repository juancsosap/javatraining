package P16_Streams;

import java.util.Arrays;
import java.util.List;

public class E02_FilterStream {

	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		nums.stream().filter(d -> d % 2 == 0)
		             .forEach(System.out::print);
		
		System.out.println();
		
		nums.stream().filter(d -> d % 2 == 0)
		             .filter(d -> d % 3 == 0)
		             .forEach(System.out::print);
		
		System.out.println();
		
		nums.stream().limit(6)
                     .forEach(System.out::print);

		System.out.println();
		
		// JAVA9
		//nums.stream().takeWhile(d -> d < 5)
        //           .forEach(System.out::print);
		
		System.out.println();
		
		// JAVA9
		//nums.stream().dropWhile(d -> d < 5)
        //           .forEach(System.out::print);
		
	}

}
