package P07_Arrays;

public class E07_ArrayModification {

	public static void main(String[] args) {
		/*
		int[] lista = {0,1,2,3,4,5,6,7,8,9};
		
		for(int i = 0; i < 10; i++) {
			lista[i]++;
			System.out.println(lista[i]);
		}
		
		System.out.println();
		for(int i : lista) {
			i++;
			System.out.println(i);
		}
		
		System.out.println();
		for(int i : lista) {
			System.out.println(i);
		}
		*/
		
		
		Dato[] listaD = {new Dato(0),new Dato(1),new Dato(2),new Dato(3),new Dato(4)};
		
		for(int i = 0; i < 5; i++) {
			listaD[i].value++;
			System.out.println(listaD[i]);
		}
		
		System.out.println();
		for(var i : listaD) {
			i.value++;
			System.out.println(i);
		}
		
		System.out.println();
		for(Dato i : listaD) {
			System.out.println(i);
		}

	}
	
	static class Dato {
		public int value;
		public Dato(int a) {
			this.value = a;
		}
		
		public String toString() {
			return this.value + "";
		}
	}

}
