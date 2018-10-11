package P24_Regex;

public class E01_StringMatches {

	public static void main(String[] args) {
		
		// https://regexr.com/
		
		String pattern1 = "[0-9]+";
		validate("1234", pattern1);
		validate("1234p", pattern1);
		validate("abcd", pattern1);
		validate("", pattern1);
		
		System.out.println();
		
		String pattern2 = "[0-9]{1,3}";
		validate("123", pattern2);
		validate("1234", pattern2);
		validate("1234p", pattern2);
		validate("abcd", pattern2);
		validate("", pattern2);

		System.out.println();
		
		String pattern3 = "[a-zA-Z]{4}[0-9]{2}";
		validate("hjzj11", pattern3);
		validate("HJZJ11", pattern3);
		validate("HJzj11", pattern3);
		validate("11hj11", pattern3);
		validate("11hjzj11", pattern3);
		validate("hjzj112", pattern3);

		System.out.println();
		
		String pattern4 = ".+[.]?exe.*";
		validate("adobe.pdf", pattern4);
		validate("config.exe", pattern4);
		validate("configexe.pdf", pattern4);
		validate("config.exe1", pattern4);
		
	}
	
	private static void validate(String value, String pattern) {
		String message = value.matches(pattern) ? "Valid" : "Invalid";
		System.out.println(message);
	}

}
