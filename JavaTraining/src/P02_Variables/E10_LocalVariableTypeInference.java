package P02_Variables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class E10_LocalVariableTypeInference {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		int a = 10;
		System.out.println(a);
		
		var b = 10;
		//b = "sdjfhdjkfn";
		
		int[] c = {1,2,3,4};
		
		// Inferred as int
		for(var d : c) {
			
		}
		
		//var a =  new String("");
		
		// Not recommended -> Generic Type is inferred to Object
		var list1 = new ArrayList<>();
		
		// Inferred ArrayList<Integer>
		Integer[] array2 = {1, 2, 3, 4};
		var list2 = new ArrayList<>(Arrays.asList(array2));
		
		// Inferred ArrayList<int[]>
		int[] array3 = {1, 2, 3, 4};
		var list3 = new ArrayList<>(Arrays.asList(array3));
		
		// Inferred Directly as ArrayList<Long>
		var list4 = new ArrayList<Long>();
		
		// Long Version
		Map<String, Map<Integer, String>> map1 = new HashMap<String, Map<Integer, String>>();
		
		// Generic Inference type 
		Map<String, Map<Integer, String>> map2 = new HashMap<>();
		
		// var type inference
		var map3 = new HashMap<String, Map<Integer, String>>();
		
	}

}
