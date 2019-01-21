package CountApp;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analytics {

	public static Map<String, Integer> analyze(int top, List<Map<String, Integer>> list) {
		Map<String, Integer> output = new HashMap<>();
		for(Map<String, Integer> map : list) {
			for(String key : map.keySet()) {
				int value = map.get(key);
				int quantity = output.getOrDefault(key, 0) + value;
				output.put(key, quantity);
			}
		}
		Comparator<String> outputComp = (k1, k2) -> output.get(k1) > output.get(k2) ? -1 :
													output.get(k1) < output.get(k2) ? 1 : 0;
		Map<String, Integer> so = new HashMap<>();
		output.keySet().stream().sorted(outputComp).limit(top)
								.forEach(k -> so.put(k, output.get(k)));
		return so;
	}
	
}
