package P11_Interfaces;

public class E14_StaticMethodConflict {

    public static void main(String ... args) {
        
        Class1 obj = new Class1();
        
        // No static method are inherited
        Class1.print("hola");
        // Class1.show("hola");
        
        Int1.print("hola");
        Int1.show("hola");
        
        Int2.print("hola");
        
        
    }
    
    private static interface Int1 {
        public static void print(String msg) {
            System.out.println("From Int1 : " + msg);
        }
        
        public static void show(String msg) {
            System.out.println("From Int1 : " + msg);
        }
    }

    private static interface Int2 {
        public static void print(String msg) {
            System.out.println("From Int2 : " + msg);
        }
    }

    private static class Class1 implements Int1, Int2 {
        public static void print(String msg) {
            Int1.print(msg);
        }
    }

}
