package P16_Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class E07_OptionalResultStream {

	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		Optional<Integer> value = nums.stream().filter(d -> d > 10).findFirst();
		
		if(value.isPresent())
			System.out.println(value.get());
		else
			System.out.println("Not value found");
		
		value = nums.stream().filter(d -> d < 10).findFirst();
		
		if(value.isPresent())
			System.out.println(value.get());
		else
			System.out.println("Not value found");
		
		nums.stream().filter(d -> d > 5).findFirst().ifPresent(System.out::println);;
		
		// JAVA9
		//nums.stream().filter(d -> d > 10).findFirst().ifPresentOrElse(System.out::println, () -> System.out.println("Not value found"));	
		
		int dato = nums.stream().filter(d -> d > 3).findFirst().orElse(10); 
		System.out.println(dato);
		
		dato = nums.stream().filter(d -> d > 10).findFirst().orElse(10); 
		System.out.println(dato);
		
		dato = nums.stream().filter(d -> d > 10).findFirst().orElseGet(() -> 11); 
		System.out.println(dato);
		
		// JAVA9
		//dato = nums.stream().filter(d -> d > 10).findFirst().or(() -> Optional.of(12)).get(); 
		System.out.println(dato);
		
		
		dato = nums.stream().filter(d -> d > 10).findFirst().orElseThrow(() -> new RuntimeException("Value not found")); 
		System.out.println(dato);

	}

}
