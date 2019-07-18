package P16_Streams;

import java.util.stream.IntStream;

public class E11_IntStream {

	public static void main(String[] args) {
		
		IntStream.range(0, 10).forEach(n -> System.out.print(n + ","));
		System.out.println();
		
		System.out.println();
		
		IntStream.rangeClosed(0, 10).forEach(n -> System.out.print(n + ","));
		System.out.println();
		
		System.out.println();
		
		IntStream.of(0, 1, 1, 2, 3, 5).forEach(n -> System.out.print(n + ","));
		System.out.println();
		
		System.out.println();
		
		int seed = 0;
		
		for(int i=0; i<5; i++) {
			IntStream.iterate(++seed, n -> n + 2).limit(5).forEach(n -> System.out.print(n + ","));
			System.out.println();
		}
		
		System.out.println();
		
    	for(int i=0; i<5; i++) {
    		// JAVA9
			//IntStream.iterate(++seed, n -> n < 15 ,n -> n + 2).forEach(n -> System.out.print(n + ","));
			System.out.println();
		}
		
	}

}
