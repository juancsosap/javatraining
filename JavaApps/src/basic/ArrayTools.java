package basic;

@SuppressWarnings("unchecked")
public class ArrayTools<T> {
	
	public static void main(String[] args) {
		Integer[] array = {12, 145, 12, 65, 100, 22};
		ArrayTools<Integer> at = new ArrayTools<>(array);
		at.print();
		System.out.println(at.max());
		System.out.println(at.min());
	}
	
	private Comparable<T>[] array;
	
	public ArrayTools(Comparable<T>[] array) {
		this.array = array;
	}
	
	public T max() {
		int length = array.length;
		if(length > 0) {
			Comparable<T> max = array[0];
			for(int i=1; i < length; i++)
				if(max.compareTo((T) array[i]) == -1)
					max = array[i];
			return (T) max;
		} else return null;
	}
	
	public T min() {
		int length = array.length;
		if(length > 0) {
			Comparable<T> min = array[0];
			for(int i=1; i < length; i++)
				if(min.compareTo((T) array[i]) == 1)
					min = array[i];
			return (T) min;
		} else return null;
	}
		
	public void print() {
		for(Comparable<T> dato: array)
			System.out.print(dato + " ");
		System.out.println();
	}

}