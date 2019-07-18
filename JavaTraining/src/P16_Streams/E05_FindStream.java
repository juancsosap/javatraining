package P16_Streams;

import java.util.Arrays;
import java.util.List;

public class E05_FindStream {

	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		int value = nums.stream().filter(d -> d < 5)
		                        .peek(d -> System.out.print(d + " : "))
		                        .map(d -> d + 1)
		                        .findFirst()
		                        .get();
		System.out.println(value);
		
		// The result could vary when parallel processing is used 
		value = nums.stream().filter(d -> d < 5)
                             .peek(d -> System.out.print(d + " : "))
                             .map(d -> d + 1)
                             .findAny()
                             .get();
		System.out.println(value);

	}

}
