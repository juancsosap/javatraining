package P03_Strings;

import java.util.Scanner;

public class E09_EmailSimpleValidator {

	public static void main(String[] args) {
		
		try(Scanner scan = new Scanner(System.in)) {
            
            System.out.println(" Email Validator\n------------------\n");
            System.out.print("Email : ");
            
            String email = scan.nextLine();
            
            // No termina en un punto
            char lastChar = email.charAt(email.length() - 1);
            boolean val1 = (lastChar != '.');
            
            // Tiene un solo @
            int indexFirstAt = email.indexOf("@");
            int indexLastAt = email.lastIndexOf("@");
            boolean val2A = (indexFirstAt != -1); // Exist almost 1 
            boolean val2B = (indexFirstAt == indexLastAt); // It's the same
            boolean val2 = val2A && val2B;
            
            // Tiene al menos 4 caracteres en el Nick
            String nick = email.substring(0, indexLastAt);
            int nickLength = nick.length();
            boolean val3 = (nickLength >= 4);
            
            // Tiene al menos 2 caracteres entre puntos en el dominio
            String domain = email.substring(indexLastAt + 1);
            int indexDot = domain.indexOf(".");
            boolean val4A = (indexDot != -1);
            boolean val4B = (indexDot < domain.length() - 2);
            boolean val4C = (indexDot > 1);
            boolean val4 = val4A && val4B && val4C;
            
            boolean val = val1 && val2 && val3 && val4;
            
            System.out.println("Valid : " + val);
            
        }	    

	}

}
