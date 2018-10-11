package P07_Arrays;

public class E01_ComparingLists {

	public static void main(String[] args) {
		
		int[] array1 = {1, 2, 3, 4, 5};
		int array2[] = array1.clone();
		int[] array3 = array1;
		
		System.out.println("Comparando Listas\n");
		
		System.out.println("Las listas clonadas generan la misma lista: " + (array1 == array2) );
		
		// The arrays have the same values?
		boolean same = true;
		for(int i = 0; i < array1.length; i++) {
			if(array1[i] == array2[i]) 
				continue;
			else {
				same = false;
				break;
			}
		}
		
		System.out.println("Las listas clonadas tienen los mismos valores: " + same );
		
		System.out.println("Las listas copiadas son la misma lista: " + (array1 == array3) );
		
		// Testing the list mutability
		int hashCodeBegin = array1.hashCode();
		
		array1[0] = 10;
		
		int hashCodeEnd = array1.hashCode();
		
		System.out.println("Las listas son mutables: " + (hashCodeBegin == hashCodeEnd) );
		
		System.out.println("Las listas clonadas son afectadas cuando se modifica la original: " + (array1[0] == array2[0]) );
		
		System.out.println("Las listas copiadas son afectadas cuando se modifica la original: " + (array1[0] == array3[0]) );
		
	}

}
