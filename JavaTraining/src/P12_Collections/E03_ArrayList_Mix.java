package P12_Collections;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class E03_ArrayList_Mix {

	public static void main(String[] args) {

		System.out.println("------ LISTAS ------");

		List lista = loadList("Juan Sosa", 35, 1.72, true, 'M');
		
		System.out.println("SIZE: " + lista.size());
		
		printList(lista);
		
	}
	
	private static List loadList(Object ... datos) {
		List list = new ArrayList(); 
		for(Object dato : datos) {
			list.add(dato);
		}
		return list;
	}
	
	private static void printList(List list) {
		for(int i=0; i<list.size(); i++) {
			Object value = list.get(i);
			System.out.println(i + " : " + value.toString() + " - " + value.getClass().getName());
		}
		System.out.println();
	}

}