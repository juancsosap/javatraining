package Generator;

import java.util.function.Function;

public class Adder {

	public static int add(int quantity, Function<Integer, Integer> generator) {
		
		int result = 0;
		int value = 0;
		for(int i = 0; i < quantity; i++) {
			value = generator.apply(value);
			result += value;
		}
		return result;
	}
	
	public static int add(int quantity, AbstractGenerator generator) {
		
		int result = 0;
		for(int i = 0; i < quantity; i++) {
			result += generator.generate();
		}
		return result;
	}

}
