package P23_I18N_L10N;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class E05_I18NProperties {

	public static void main(String[] args) {
		
		try(Scanner inConsole = new Scanner(System.in)){
			
			System.out.print("Language: ");
			String language = inConsole.nextLine();
			
			String path = String.format("files/resources/i18n_%s.properties", language);
			
			try(InputStream in = new FileInputStream(path)) {
				
				Properties p = new Properties();
				p.load(in);
				
				System.out.print(p.getProperty("name", "Nombre Completo: "));
				String name = inConsole.nextLine();
				
				System.out.print(p.getProperty("country", "Pais de Procedencia: "));
				String country = inConsole.nextLine();
				
				String output = p.getProperty("result", "Gracias %s de %s por la información suministrada.");
				System.out.print(String.format(output, name, country));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
										
	}

}
