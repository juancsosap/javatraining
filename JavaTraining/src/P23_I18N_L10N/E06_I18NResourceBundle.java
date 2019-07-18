package P23_I18N_L10N;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class E06_I18NResourceBundle {

	public static void main(String[] args) {
		
		try(Scanner inConsole = new Scanner(System.in)){
			
			System.out.print("Language: ");
			String language = inConsole.nextLine();
			
			Locale locale = new Locale(language);
			
			ResourceBundle info = ResourceBundle.getBundle("Resources.i18n", locale);
			
			System.out.print(info.getString("name"));
			String name = inConsole.nextLine();
			
			System.out.print(info.getString("country"));
			String country = inConsole.nextLine();
			
			String output = info.getString("result");
			System.out.print(String.format(output, name, country));
		
		}
										
	}

}
