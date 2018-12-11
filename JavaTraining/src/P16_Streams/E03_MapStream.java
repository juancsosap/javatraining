package P16_Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class E03_MapStream {

	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		nums.stream().filter(d -> d < 5)
					 .map(d -> d * d)
		             .forEach(System.out::println);
		
		System.out.println();

		List<String> words = Arrays.asList("zero", "one", "two", "three", "four", 
				                           "five", "six", "seven", "eight", "nine");
		
		words.stream().flatMap(n -> Stream.of(n.split("")))
                      .forEach(c -> System.out.print(c + "-"));

		words.stream().map(n -> n.toUpperCase())
        			  .forEach(System.out::println);
		
		String texto = words.stream().reduce((t1, t2) -> t1 + t2).get();
		System.out.println(texto);
		
	}

}
