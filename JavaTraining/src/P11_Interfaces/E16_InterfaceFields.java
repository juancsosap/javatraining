package P11_Interfaces;

public class E16_InterfaceFields {

    private static interface Ranger {
        public static final int min = 0;
        public int max = 100; // By default are static final
        
        public default boolean validate(int number) {
            // min = 10;
            // max = 1000;
            return number >= min && number <= max;
        }
    }
    
    private static class Number {
        public static final int min;
        public final int max;
        
        static {
            min = 0;
        }
        
        public Number() {
            max = 100;
        }
        
    }
    
}
