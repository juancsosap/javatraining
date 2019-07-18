package P24_Regex;

import java.util.Arrays;
import java.util.regex.Pattern;

public class E06_PatternSplit {

	public static void main(String[] args) {
		
		// https://regexr.com/
		
		String msg = "Don                  Quijote de la Mancha es una novela escrita por el español Miguel \n"
				   + "de Cervantes Saavedra.	Publicada su primera parte con el título de El \n"
				   + "ingenioso hidalgo don Quijote de la Mancha a comienzos de 1605, es la \n"
				   + "obra más destacada de la literatura española y una de las principales \n"
				   + "de la literatura universal.";
		
		Pattern pattern1 = Pattern.compile("\\s+");
		Arrays.asList(pattern1.split(msg)).forEach(System.out::println);
		
		System.out.println("--------------------------");
		
		Pattern pattern2 = Pattern.compile("[ \n\t]+");
		Arrays.asList(pattern2.split(msg)).forEach(System.out::println);
				
	}

}
