package P10_Generics;

import java.util.ArrayList;
import java.util.List;

public class E08_GenericMethods {

	public static void main(String[] args) {
		List<Integer> numbers = get(1, 2, 3, 4, 5);
		numbers.forEach(System.out::print);
		
		System.out.println();
		
		List<Character> letters = get('a', 'e', 'i', 'o', 'u');
		letters.forEach(System.out::print);
	}
	
	@SafeVarargs
	public static <T> List<T> get(T ... datas) {
		List<T> list = new ArrayList<>();	
		for(var data : datas) {
			list.add(data);
		}
		return list;
	}

}
