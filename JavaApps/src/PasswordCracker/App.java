package PasswordCracker;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class App {

    public static void main(String ... args) {
        
        try(Scanner scan = new Scanner(System.in)) {
            
            System.out.println("Password Cracker");
            System.out.println("----------------");
            
            try(Getter getter = new Getter()) {
                
                Box<Integer> size = new Box<>(Converter.INT);
                getter.getData("Password Length: ", size);
                
                Box<Boolean> hasNumbers = new Box<>(Converter.BOOL);
                getter.getData("Has Numbers (y/n): ", hasNumbers);
                
                Box<Boolean> hasUppers = new Box<>(Converter.BOOL);
                getter.getData("Has Uppercase Letters (y/n): ", hasUppers);
                
                Box<Boolean> hasLowers = new Box<>(Converter.BOOL);
                getter.getData("Has Lowercase Letters (y/n): ", hasLowers);
                
                Box<Boolean> hasSymbols = new Box<>(Converter.BOOL);
                getter.getData("Has Symbols (y/n): ", hasSymbols);
                
                Box<Boolean> customPasswd = new Box<>(Converter.BOOL);
                getter.getData("Custom Password (y/n): ", customPasswd);
                
                Box<String> passwd = new Box<>(Converter.NO);
                if(customPasswd.get()) {
                    getter.getData("Password: ", passwd);
                }
                
                Box<Boolean> hasLog = new Box<>(Converter.BOOL);
                getter.getData("Logging Console (y/n): ", hasLog);
                
                String chars = "";
                chars += hasNumbers.get() ? "0123456789" : "";
                chars += hasUppers.get() ? "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ" : "";
                chars += hasLowers.get() ? "abcdefghijklmnñopqrstuvwxyz" : "";
                chars += hasSymbols.get() ? ".,;:-_{}[]+~*'?¿!¡\\//\"#$%&()|°" : "";
                
                LocalTime ini = LocalTime.now();
                
                Generator gen = new Generator(chars, size.get());
                String valPasswd = customPasswd.get() ? passwd.get() : gen.getLast();
                for(String pass : gen) {
                    if(hasLog.get()) System.out.println(pass);
                    if(pass.equals(valPasswd)) {
                        System.out.println("Password Found");
                        break;
                    }
                }
                
                LocalTime end = LocalTime.now();
                
                Duration diff = Duration.between(ini, end);
                
                System.out.printf("Time Required: %,.2f mili seconds\n", diff.getNano()/1_000_000.0);
                 
            } catch(Exception ex) {
                System.out.println(ex);
            }
         
        }
        
    }
    
}
