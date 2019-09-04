package Fluid;

public class Program {

    public static void main(String ... args) {

        StringEditor se = new StringEditor("Hola como estan hoy?");
        se.toUpper()
          .reverse()
          .filter("[?]")
          .apply(System.out::println);

    }
    
}
