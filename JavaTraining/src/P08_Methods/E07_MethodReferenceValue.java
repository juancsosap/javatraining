package P08_Methods;

public class E07_MethodReferenceValue {

	public static void main(String[] args) {
	
		int valueInt = 5;
		System.out.println("MAIN INT: " + valueInt);
		changeValue(valueInt);
		System.out.println("MAIN INT: " + valueInt);
		
		System.out.println();
		
		String valueString = "OLD";
		System.out.println("MAIN STRING: " + valueString);
		changeValue(valueString);
		System.out.println("MAIN STRING: " + valueString);
	
		System.out.println();
		
		StringBuilder valueStringBuilder = new StringBuilder();
		valueStringBuilder.append("OLD");
		System.out.println("MAIN STRINGBUILDER: " + valueStringBuilder);
		changeValue(valueStringBuilder);
		System.out.println("MAIN STRINGBUILDER: " + valueStringBuilder);
	
	}
	
	private static void changeValue(int value) {
		System.out.println("METHOD INT: " + value);
		value = 10;
		System.out.println("METHOD INT: " + value);
	}
	
	private static void changeValue(String value) {
		System.out.println("METHOD STRING: " + value);
		value = "NEW";
		System.out.println("METHOD STRING: " + value);
	}

	private static void changeValue(StringBuilder value) {
		System.out.println("METHOD STRINGBUILDER: " + value);
		value.append("NEW");
		System.out.println("METHOD STRINGBUILDER: " + value);
	}
}
