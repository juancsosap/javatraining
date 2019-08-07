package P12_Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class E02_ArrayList_Generic {

	public static void main(String[] args) {

		List<Integer> lista = loadList(10);
		
		System.out.println("SIZE: " + lista.size());
		
		printList(lista);
		
		List<Integer> lista_filtrada = filterList(lista, 3);
		
		printList(lista_filtrada);
		
		List<Integer> resultado = removeList(lista, lista_filtrada);
		
		printList(resultado);
		
	}
	
	private static List<Integer> loadList(int size) {
		List<Integer> list = new ArrayList<>(); 
		for(int i=0; i<size; i++) {
			list.add((new Random()).nextInt());
		}
		return list;
	}
	
	private static void printList(List<Integer> list) {
		for(int i=0; i<list.size(); i++) {
			System.out.println(i + " : " + list.get(i));
		}
		System.out.println();
	}
	
	private static List<Integer> filterList(List<Integer> list, int multiplier) {
		List<Integer> result = new ArrayList<>();
		for(int value : list) {
			if(value % multiplier == 0)
				result.add(value);
		}
		return result;
	}

	private static List<Integer> removeList(List<Integer> original, List<Integer> invalid) {
		var result = new ArrayList<>(original);
		for(int value : invalid) {
			while(result.contains(value)) {
				int index = result.indexOf(value);
				result.remove(index);
			}
		}
		return result;
	}

}