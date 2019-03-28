package View;

import Controller.AccessController;
import java.util.Scanner;

public class AccessView {

    private static AccessController ctrl = new AccessController();
    
    public static void getAccess() {
        
        try(Scanner scan = new Scanner(System.in)) {
            
            System.out.println("Card Access Control");
            System.out.print("Reader ID: ");
            int zoneId = scan.nextInt();
            System.out.print("Card ID: ");
            int cardId = scan.nextInt();
            
            boolean open = ctrl.autorize(zoneId, cardId);
            
            if(open) {
                System.out.println("Autorized");
            } else {
                System.out.println("Regected");
            }
            
        }
        
    }
    
}