package P24_Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E05_PatternMatcher {

	public static void main(String[] args) {
		
		// https://regexr.com/
		
		String msg = "Don                  Quijote de la Mancha ​ es una novela escrita por el español Miguel \n"
				   + "de Cervantes Saavedra. Publicada su primera parte con el título de El \n"
				   + "ingenioso hidalgo don Quijote de la Mancha a comienzos de 1605, es la \n"
				   + "obra más destacada de la literatura española y una de las principales \n"
				   + "de la literatura universal.";
		
		System.out.println(msg);
		
		System.out.println();
		
		Pattern pattern1 = Pattern.compile("[ ]+");
		Matcher matcher1 = pattern1.matcher(msg);
		
		System.out.println(matcher1.replaceAll(","));
		
		System.out.println();
		
		Pattern pattern2 = Pattern.compile("[a-z0-9.,\n]+", Pattern.CASE_INSENSITIVE);
		Matcher matcher2 = pattern2.matcher(msg);
		
		while(matcher2.find()) {
			System.out.print(matcher2.group() + " ");
		}
		
		System.out.println();
		System.out.println();
		
		Matcher matcher3 = pattern2.matcher(msg);
		
		while(matcher3.find()) {
			System.out.println(matcher3.start() + "," + matcher3.end() + ": " + matcher3.group());
		}
				
	}

}
