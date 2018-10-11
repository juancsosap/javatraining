package P24_Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E04_PatternCompile {

	public static void main(String[] args) {
		
		// https://regexr.com/
		
		Pattern pattern1 = Pattern.compile("[a-zA-Z0-9,-.]{2,}@[a-zA-Z0-9]{2,}(\\.[a-zA-Z]{2,})+");
		validate("juan@gmail.com", pattern1);
		validate("juan-sosa@hotmail.co.ve", pattern1);
		validate("juan.sosagmail.com", pattern1);
		validate("juan.sosa@hotmail@com", pattern1);
		validate("juan.sosa@hotmail..com", pattern1);
		validate("juan..sosa@hotmail.com", pattern1);
		validate("j@hotmail.com", pattern1);
		validate("juan@hotmail.c.om", pattern1);
		
		System.out.println();
		
		Pattern pattern2 = Pattern.compile("([+]56)?[1-9][0-9]{8}");
		validate("+56912341234", pattern2);
		validate("912341234", pattern2);
		validate("012341234", pattern2);
		validate("91234123", pattern2);
		validate("+56012341234", pattern2);

		System.out.println();
		
		Pattern pattern3 = Pattern.compile("[a-z]{4}[0-9]{2}", Pattern.CASE_INSENSITIVE);
		validate("hjzj11", pattern3);
		validate("HJZJ11", pattern3);
		validate("HJzj11", pattern3);
		validate("11hj11", pattern3);
		validate("11hjzj11", pattern3);
		validate("hjzj112", pattern3);

		System.out.println();
		
		Pattern pattern4 = Pattern.compile(".+[.]exe", Pattern.CASE_INSENSITIVE);
		validate("adobe.pdf", pattern4);
		validate("config.EXE", pattern4);
		validate("configexe.pdf", pattern4);
		validate("config.exe1", pattern4);
		
	}
	
	private static void validate(String value, Pattern pattern) {
		Matcher matcher = pattern.matcher(value);
		String message = matcher.matches() ? "Valid" : "Invalid";
		System.out.println(message);
	}

}
