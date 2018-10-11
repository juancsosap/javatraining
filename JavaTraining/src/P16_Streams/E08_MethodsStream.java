package P16_Streams;

import java.util.Arrays;
import java.util.List;

public class E08_MethodsStream {

	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90);
		
		long count = nums.stream().filter(d -> d % 2 == 0).count();
		System.out.println(count);
		
		int max = nums.stream().filter(d -> d % 3 == 0).max((d1, d2) -> d1.compareTo(d2)).get();
		System.out.println(max);
		
		int min = nums.stream().filter(d -> d % 4 == 0).min((d1, d2) -> d1.compareTo(d2)).get();
		System.out.println(min);
		
	}

}
