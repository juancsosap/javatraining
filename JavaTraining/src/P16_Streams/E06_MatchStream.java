package P16_Streams;

import java.util.Arrays;
import java.util.List;

public class E06_MatchStream {

	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		boolean allMatch = nums.stream().allMatch(d -> d % 2 == 0);
		System.out.println(allMatch);
		
		allMatch = nums.stream().filter(d -> d % 2 == 0).allMatch(d -> d % 2 == 0);
		System.out.println(allMatch);
		
		boolean noneMatch = nums.stream().noneMatch(d -> d % 2 == 0);
		System.out.println(noneMatch);
		
		noneMatch = nums.stream().filter(d -> d % 2 == 0).noneMatch(d -> d % 2 == 1);
		System.out.println(noneMatch);
		
		// The result could vary when parallel processing is used 
		boolean anyMatch = nums.stream().anyMatch(d -> d % 2 == 0);
		System.out.println(anyMatch);
		
		anyMatch = nums.stream().filter(d -> d % 2 == 0).anyMatch(d -> d % 2 == 1);
		System.out.println(anyMatch);
		
		
	}

}
