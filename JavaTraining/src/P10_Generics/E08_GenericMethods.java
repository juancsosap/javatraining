package P10_Generics;

import java.util.ArrayList;
import java.util.List;

public class E08_GenericMethods {

	public static void main(String[] args) {
		List<Integer> numbers = get(1, 2, 3, 4, 5);
		numbers.forEach(System.out::print);
		
		System.out.println();
		
		var letters = get('a', 'e', 'i', 'o', 'u');
		letters.forEach(System.out::print);
                
                System.out.println();
                
                List<String> people = convert(new Person(), new Person());
                people.forEach(System.out::println);
	}
	
	@SafeVarargs
	public static <T> List<T> get(T ... datas) {
		List<T> list = new ArrayList<>();	
		for(var data : datas.clone()) {
			list.add(data);
		}
		return list;
	}
        
        @SafeVarargs
        public static <D, S extends Convertible<D>> List<D> convert(S ... datas) {
		List<D> list = new ArrayList<>();	
		for(var data : datas.clone()) {
                        D valor = data.convert();
			list.add(valor);
		}
		return list;
        }
        
        private static interface Convertible<T> {
            public T convert();
        }
        
        private static class Person<String> implements Convertible<String> {
            
            public String convert() {
                return (String) this.toString();
            }
            
        }

}
