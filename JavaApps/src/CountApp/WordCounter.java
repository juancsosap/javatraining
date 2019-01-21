package CountApp;

import java.util.Map;
import java.util.TreeMap;

public class WordCounter {

	public static Map<String, Integer> count(String text) {
		Map<String, Integer> output = new TreeMap<>();
		String toreplace = ".,;:\n\t()[]'\"{}-1234567890/\\@+";
		for(char c : toreplace.toCharArray()) {
			text = text.replace(c, ' ');
		}
		String[] words = text.toLowerCase().split(" +");
		for(String w : words) {
			int quantity = output.getOrDefault(w, 0) + 1;
			output.put(w, quantity);
		}
		return output;
	}
	
}
