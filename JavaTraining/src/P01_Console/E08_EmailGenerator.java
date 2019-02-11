package P01_Console;

import java.util.Scanner;

public class E08_EmailGenerator {

    public static void main(String[] args) {
        
        try(Scanner scan = new Scanner(System.in)) {

            System.out.println("EMAIL Generator\n---------------");

            System.out.print("Name: ");
            String name = scan.nextLine();

            System.out.print("Surname: ");
            String surname = scan.nextLine();

            System.out.print("Domain: ");
            String domain = scan.nextLine();

            System.out.printf("\nEmail: %s.%s@%s\n", name, surname, domain);

        }
        
    }
    
}
