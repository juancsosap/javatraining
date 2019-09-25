package P11_Interfaces;

public class E15_DefaultMethodsConflict {

    public static void main(String ... args) {
        
        Class1 obj1 = new Class1();
        
        obj1.print("hola");
        obj1.show("hola");
        
        obj1.print("hola");
        
        Class2 obj2 = new Class2();
        
        obj2.print("chao");
        obj2.show("chao");
        
        obj2.print("chao");
        
    }
    
    private static interface Int1 {
        public default void print(String msg) {
            System.out.println("From Int1 : " + msg);
        }
        
        public default void show(String msg) {
            System.out.println("From Int1 : " + msg);
        }
    }

    private static interface Int2 {
        public default void print(String msg) {
            System.out.println("From Int2 : " + msg);
        }
    }

    private static class Class1 implements Int1, Int2 {
        @Override
        public void print(String msg) {
            System.out.println("From Class1 : " + msg);
        }
    }
    
    private static class Class2 implements Int1, Int2 {
        @Override
        public void print(String msg) {
            Int1.super.print(msg);
        }
        
        @Override
        public void show(String msg) {
            Int1.super.show(msg);
            System.out.println("From Class2 : " + msg);
        }
    }
    
}
