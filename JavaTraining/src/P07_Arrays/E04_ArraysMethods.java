package P07_Arrays;

import java.util.Arrays;

public class E04_ArraysMethods {

	public static void main(String[] args) {
		
		int[] array1 = {10, 2, 31, 4, 57};
		String[] array2 = {"Juan", "Luis", "Maria", "Ana", "Jose", "ana"};
		
		Arrays.sort(array1);
		Arrays.sort(array2);
		
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));
		
		int[] array3 = {1, 2, 3, 4, 5, 6, 7}; // 1234567
		int[] array4 = {1, 2, 3, 2, 5, 6, 7}; // 1232567 -> minor than
		
		// Return -1 to minor to, 0 to equal and 1 to mayor to
		System.out.println(Arrays.compare(array3, array4));
		
		// Return the index of the first element different
		System.out.println(Arrays.mismatch(array3, array4));
		
	}

}
