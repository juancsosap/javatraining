package CountApp;

import java.util.Map;
import java.util.TreeMap;

public class WordCounter {

	public static Map<String, Integer> count(String text, String name) {
		System.out.println("Counting Words from " + name);
		Map<String, Integer> output = new TreeMap<>();
		String toreplace = ".,;:\n\t()[]'\"{}-1234567890/\\@+=><|*#";
		for(char c : toreplace.toCharArray()) {
			text = text.replace(c, ' ');
		}
		String[] words = text.toLowerCase().split(" +");
		for(String w : words) {
			if(w.length() <= 3) continue;
			int quantity = output.getOrDefault(w, 0) + 1;
			output.put(w, quantity);
		}
		return output;
	}
	
}
