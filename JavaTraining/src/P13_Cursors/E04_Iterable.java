package P13_Cursors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class E04_Iterable {

	public static void main(String[] args) {
		
		Countries lista = new Countries();
		
		System.out.println(lista);
		
		Iterator<String> iterator = lista.iterator();
		
		System.out.println("#####################");
		while(iterator.hasNext()) {
			String value = iterator.next();
			if(!value.equals("Argentina"))
				System.out.println(value);
			else
				iterator.remove();
		}
		System.out.println("#####################");
		
		System.out.println(lista);
		
	}
	
	private static class Countries implements Iterable<String> {

		private List<String> values = new ArrayList<>();
		
		public Countries() {
			this.values.add("Chile");
			this.values.add("Colombia");
			this.values.add("Argentina");
			this.values.add("Perú");
			this.values.add("Mexico");
		}
		
		@Override
		public Iterator<String> iterator() {
			return CountriesIterator;
		}
		
		@Override
		public String toString() {
			StringBuilder result = new StringBuilder("");
			result.append("---------------------\n");
			for(String value : values) {
				result.append("> " + value + "\n");
			}
			result.append("---------------------");
			return result.toString();
		}
		
		private final Iterator<String> CountriesIterator = new Iterator<String>() {

			private int index = -1;
			
			@Override
			public boolean hasNext() {
				return (index + 1) < values.size();
			}

			@Override
			public String next() {
				return values.get(++index);
			}

			@Override
			public void remove() {
				values.remove(index--);
			}

		};
		
	}

}