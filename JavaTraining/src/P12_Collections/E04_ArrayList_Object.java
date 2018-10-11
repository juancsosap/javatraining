package P12_Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class E04_ArrayList_Object {

	public static void main(String[] args) {
		System.out.println("------ ARREGLOS ------");
		
		int[] arreglo = loadArray(10);
		
		System.out.println("SIZE: " + arreglo.length);
		
		printArray(arreglo);
		
		int[] arreglo_filtrado = filterArray(arreglo, 3);
		
		printArray(arreglo_filtrado);

		System.out.println("------ LISTAS ------");

		List lista = loadList(10);
		
		System.out.println("SIZE: " + lista.size());
		
		printList(lista);
		
		List lista_filtrada = filterList(lista, 3);
		
		printList(lista_filtrada);
		
	}
	
	private static int[] loadArray(int size) {
		int[] array = new int[size]; 
		for(int i=0; i<size; i++) {
			array[i] = (new Random()).nextInt();
		}
		return array;
	}
	
	private static void printArray(int[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.println(i + " : " + array[i]);
		}
		System.out.println();
	}
	
	private static int[] filterArray(int[] array, int multiplier) {
		int count = 0; 
		for(int value : array) {
			if(value % multiplier == 0)
				count++;
		}
		int[] result = new int[count];
		int j = 0;
		for(int i=0; i<array.length; i++) {
			if(array[i] % multiplier == 0)
				result[j++] = array[i];
		}
		
		return result;
	}

	private static List loadList(int size) {
		List list = new ArrayList(size); 
		for(int i=0; i<size; i++) {
			list.add((new Random()).nextInt());
		}
		return list;
	}
	
	private static void printList(List list) {
		for(int i=0; i<list.size(); i++) {
			int value = (Integer) list.get(i);
			System.out.println(i + " : " + value);
		}
		System.out.println();
	}
	
	private static List filterList(List list, int multiplier) {
		List result = new ArrayList();
		for(Object value : list) {
			int value_int = (Integer) value;
			if(value_int % multiplier == 0)
				result.add(value_int);
		}
		
		return result;
	}
	
	@SuppressWarnings("unused")
	private static Integer[] filterList(int[] arreglo, int multiplier) {
		List result = Arrays.asList(arreglo);
		for(int value : arreglo) {
			int value_int = (Integer) value;
			if(value_int % multiplier == 0)
				result.add(value_int);
		}
		
		return (Integer[]) result.toArray();
	}
	

}