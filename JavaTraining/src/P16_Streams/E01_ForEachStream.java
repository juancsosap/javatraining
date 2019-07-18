package P16_Streams;

import java.util.Arrays;
import java.util.List;

public class E01_ForEachStream {

	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		nums.forEach(System.out::print);
		
		System.out.println();
		
		nums.forEach(d -> System.out.print(d));
		
		System.out.println();
		
		nums.stream().forEach(System.out::print);
		
	}

}
