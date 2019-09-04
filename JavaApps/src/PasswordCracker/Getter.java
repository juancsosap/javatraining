package PasswordCracker;

import java.util.Scanner;

public class Getter implements AutoCloseable {
    
    private final Scanner scan;
    
    public Getter() {
        this.scan = new Scanner(System.in);
    }
    
    public <T> void getData(String msg, Box<T> box) {
        
        while(true) {
            System.out.print(msg);
            String value = this.scan.nextLine();
            
            try {
                box.convert(value);
                break;
            } catch(RuntimeException ex) {}
        }
        
    }

    @Override
    public void close() throws Exception {
        this.scan.close();
    }
    
}

