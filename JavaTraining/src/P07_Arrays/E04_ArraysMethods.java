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
		
	}

}
