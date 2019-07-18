package CountApp;

import java.util.Map;

public class Printer {
	
	public static void print(Map<String, Integer> input) {
        
        System.out.println("QUANTITY\tWORD");
        
        input.keySet().stream().sorted(Analytics.outputComp).forEach(k -> System.out.println(input.get(k) + "\t\t" + k));
        
    }

}
