package P09_Classes;

public class E12_PersonStatic {

    public static void main(String[] args) {
        
        System.out.println("Starting Program");
        
        Person p1 = new Person("Juan");
        System.out.println(p1.getId() + " : " + p1.getName());
        
        Person p2 = new Person("Luis");
        System.out.println(p2.getId() + " : " + p2.getName());
        
        Person p3 = new Person("Pepe");
        System.out.println(p3.getId() + " : " + p3.getName());
        
        Person p4 = new Person("Jose");
        System.out.println(p4.getId() + " : " + p4.getName());
        
        p1 = new Person("Ana");
        System.out.println(p1.getId() + " : " + p1.getName());
        
        System.out.println(Person.count());
        
    }
    
    private static class Person {

        private String name;
        private int id;

        private static int count;

        static {
            System.out.println("Const Static");
            count = 0;
        }
        
        public Person(String name) {
            this.id = ++Person.count;
            this.name = name;
        }

        public String getName() { return this.name; }
        public int getId() { return this.id; }

        public static int count() { return Person.count; }
        
    }
    
}